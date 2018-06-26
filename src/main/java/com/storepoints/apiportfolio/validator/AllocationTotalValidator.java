package com.storepoints.apiportfolio.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.storepoints.apiportfolio.model.AssetAllocation;
import com.storepoints.apiportfolio.model.ModelReq;

@Component
public class AllocationTotalValidator {
	
    public void validate( ModelReq modelReq, Errors errors) {
    	
    	double allocationTotal= modelReq.getCashHoldingPercentage().doubleValue();
    	
    	Double assetAllocationsTotal= Double.valueOf(0);
    	for(AssetAllocation assetAllocation:modelReq.getAssetAllocations()){
    		
    		assetAllocationsTotal= Double.sum(assetAllocationsTotal,assetAllocation.getPercentage());
    	}
    	
    	allocationTotal= allocationTotal+ assetAllocationsTotal;
    	
    	if(Math.round(allocationTotal*100.0)/100.0!=100.0){
    		 errors.reject("allocation.percentage.total.invalid");
    	}
    }

}
