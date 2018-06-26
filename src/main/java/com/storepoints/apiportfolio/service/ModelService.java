package com.storepoints.apiportfolio.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storepoints.apiportfolio.exception.AdvisorNotFoundException;
import com.storepoints.apiportfolio.domain.Advisor;
import com.storepoints.apiportfolio.domain.AdvisorRepository;
import com.storepoints.apiportfolio.domain.Model;
import com.storepoints.apiportfolio.domain.ModelRepository;
import com.storepoints.apiportfolio.domain.ModelType;
import com.storepoints.apiportfolio.domain.RebalanceFrequency;
import com.storepoints.apiportfolio.model.AssetAllocation;
import com.storepoints.apiportfolio.model.ModelReq;
import com.storepoints.apiportfolio.model.ModelRes;
import com.storepoints.apiportfolio.model.ModelsRes;

@Service
public class ModelService {
	
	@Autowired
	private AdvisorRepository advisorRepository;
	
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	ConversionService conversionService;
	
	@Transactional(readOnly = true)
	public List<Advisor> indexAdvisors(){
 		long count = advisorRepository.count();
 		
 		Page<Advisor> advisors=advisorRepository.findAll(PageRequest.of(0, (new Long(count)).intValue()));

 		return advisors.getContent();
	}
	
	@Transactional
	public Advisor createAdvisors(String advisorName, String userId){
    	Advisor advisor= new Advisor(advisorName, userId);
    	advisorRepository.save(advisor);
    	return advisor;
	}
	
	
	@Transactional
	public ModelRes createOrUpdateModel(String advisorId, ModelReq modelReq){
    	List<Advisor> advisorList= advisorRepository.findByAdvisorId(advisorId);
    	ModelRes modelRes=null;
    	
    	if(advisorList.size()==0){
    		//handle AdvisorNotFoundException
    		throw new AdvisorNotFoundException("advisor.not.found");
    	}
    	
    	
    	String modelName=modelReq.getName();
    	List<Model> modelList=modelRepository.findByName(modelName);
    	
    	if(modelList.size()==0){
	    	Model model= conversionService.convert(modelReq, Model.class);
	    	model.setAdvisorId(advisorId);
	    	modelRepository.save(model);
	    	modelRes=conversionService.convert(model, ModelRes.class);
    	} else {
    		// Update Model Req content manually and not with conversion service as it gives new object
    		Model modelUpdate=modelList.get(0);
    		modelUpdate.setDescription(modelReq.getDescription());
    		modelUpdate.setCashHoldingPercentage(modelReq.getCashHoldingPercentage());
    		modelUpdate.setDriftPercentage(modelReq.getDriftPercentage());
    		modelUpdate.setCreatedOn(modelReq.getCreatedOn());
    		modelUpdate.setModelType(ModelType.valueOf(modelReq.getModelType().toString()));
    		modelUpdate.setRebalanceFrequency(RebalanceFrequency.valueOf(modelReq.getRebalanceFrequency().toString()));
        	
    		modelUpdate.setAssetAllocations(new ArrayList<com.storepoints.apiportfolio.domain.AssetAllocation>());
        	for(AssetAllocation assetAllocationModel: modelReq.getAssetAllocations()){
        		com.storepoints.apiportfolio.domain.AssetAllocation assetAllocationEntity= new com.storepoints.apiportfolio.domain.AssetAllocation(assetAllocationModel.getSymbol(), assetAllocationModel.getPercentage());
        		modelUpdate.addAssetAllocation(assetAllocationEntity);
        	}
    		
    		modelRepository.save(modelUpdate);
    		modelRes=conversionService.convert(modelUpdate, ModelRes.class);
    	}
    	
    	return modelRes;
		
		
	}
	
	
	
	@Transactional(readOnly = true)
	public ModelsRes findModels(String advisorId, Integer pageNumber, Integer pageSize) {
		
		Integer pageNumberConsidered=pageNumber != null ? pageNumber : 0;
		Integer pageSizeConsidered=pageSize != null  && pageSize.compareTo(Integer.valueOf(0))>0? pageSize : 10;
		
		List<Advisor> advisorList = advisorRepository.findByAdvisorId(advisorId);

		if (advisorList.size() == 0) {
			throw new AdvisorNotFoundException("advisor.not.found");
		}

		Page<Model> pages = modelRepository.findByAdvisorId(advisorId, PageRequest.of(pageNumberConsidered,
				pageSizeConsidered, Sort.Direction.ASC, "advisorId"));

		List<Model> models = pages.getContent();

		ModelsRes modelsRes = conversionService.convert(models, ModelsRes.class);
		modelsRes.setPageNumber(pageNumberConsidered);
		modelsRes.setPageSize(pageSizeConsidered);
		modelsRes.setNumberOfPages(modelsRes.getTotalNumberOfElements()<pageSizeConsidered? 1: Math.round(modelsRes.getTotalNumberOfElements()/pageSizeConsidered));

		return modelsRes;

	}

}
