package com.storepoints.apiportfolio.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.storepoints.apiportfolio.exception.AdvisorNotFoundException;
import com.storepoints.apiportfolio.domain.Advisor;
import com.storepoints.apiportfolio.domain.AdvisorRepository;
import com.storepoints.apiportfolio.domain.Model;
import com.storepoints.apiportfolio.domain.ModelRepository;
import com.storepoints.apiportfolio.domain.ModelType;
import com.storepoints.apiportfolio.domain.RebalanceFrequency;
import com.storepoints.apiportfolio.exception.ErrorDetails;
import com.storepoints.apiportfolio.exception.InvalidTotalAllocationException;
import com.storepoints.apiportfolio.model.AdvisorCreateRequest;
import com.storepoints.apiportfolio.model.AssetAllocation;
import com.storepoints.apiportfolio.model.ModelCreateRequest;
import com.storepoints.apiportfolio.model.ModelReq;
import com.storepoints.apiportfolio.model.ModelRes;
import com.storepoints.apiportfolio.model.ModelsRes;
import com.storepoints.apiportfolio.service.ModelService;
import com.storepoints.apiportfolio.validator.AllocationTotalValidator;


@RestController
public class ModelsController {
	
	@Autowired
	private AdvisorRepository advisorRepository;
	
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	ConversionService conversionService;
	
    private final AllocationTotalValidator allocationTotalValidator;
    
    private final ModelService modelService;    

    @Autowired
    public ModelsController(ModelService modelService, AllocationTotalValidator allocationTotalValidator) {
        this.modelService=modelService;
        this.allocationTotalValidator = allocationTotalValidator;
    }
	
 	@GetMapping("/admin/api/v1/advisors")
    public List<Advisor> indexAdvisors() {
 		return modelService.indexAdvisors();
 	}
 	
    @PostMapping("/admin/api/v1/advisors")
    @ResponseStatus(HttpStatus.CREATED)
    public Advisor createAdvisors(HttpServletRequest request, @RequestBody AdvisorCreateRequest advisorCreateRequest) {
    	return modelService.createAdvisors(advisorCreateRequest.getName(), advisorCreateRequest.getLoginId());
    }
 	
    @GetMapping("/api/v1/advisor/{advisorId}/model")
    public ResponseEntity<?> showModels(@PathVariable String advisorId, @RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
    	
    	ModelsRes modelsRes=modelService.findModels(advisorId, pageNumber, pageSize);
    	
    	return new ResponseEntity<>(modelsRes,HttpStatus.OK);
    }
    
    
    
    @PutMapping("/api/v1/advisor/{advisorId}/model")
    public ResponseEntity<?> createOrUpdateModel(HttpServletRequest request,  @PathVariable String advisorId, @RequestBody ModelReq modelReq,  Errors errors) {
    	allocationTotalValidator.validate(modelReq, errors);
    	if (errors.hasErrors()) {
    		throw new InvalidTotalAllocationException("allocation.percentage.total.invalid");
    	}

    	ModelRes modelRes= modelService.createOrUpdateModel(advisorId, modelReq);
    	
    	return new ResponseEntity<>(modelRes,HttpStatus.OK);
    	
    }

}
