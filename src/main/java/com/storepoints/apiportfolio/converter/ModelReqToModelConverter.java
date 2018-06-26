package com.storepoints.apiportfolio.converter;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;

import com.storepoints.apiportfolio.model.AssetAllocation;
import com.storepoints.apiportfolio.domain.Model;
import com.storepoints.apiportfolio.domain.ModelType;
import com.storepoints.apiportfolio.domain.RebalanceFrequency;
import com.storepoints.apiportfolio.model.ModelReq;

public class ModelReqToModelConverter implements Converter<ModelReq, Model> {

	@Override
	public Model convert(ModelReq modelReq) {
    	Model model= new Model(modelReq.getName());
    	model.setDescription(modelReq.getDescription());
    	model.setCashHoldingPercentage(modelReq.getCashHoldingPercentage());
    	model.setDriftPercentage(modelReq.getDriftPercentage());
    	model.setCreatedOn(modelReq.getCreatedOn());
    	model.setModelType(ModelType.valueOf(modelReq.getModelType().toString()));
    	model.setRebalanceFrequency(RebalanceFrequency.valueOf(modelReq.getRebalanceFrequency().toString()));
    	
    	
    	model.setAssetAllocations(new ArrayList<com.storepoints.apiportfolio.domain.AssetAllocation>());
    	for(AssetAllocation assetAllocationModel: modelReq.getAssetAllocations()){
    		com.storepoints.apiportfolio.domain.AssetAllocation assetAllocationEntity= new com.storepoints.apiportfolio.domain.AssetAllocation(assetAllocationModel.getSymbol(), assetAllocationModel.getPercentage());
    		model.addAssetAllocation(assetAllocationEntity);
    	}
		return model;
	}

}
