package com.storepoints.apiportfolio.converter;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;

import com.storepoints.apiportfolio.domain.AssetAllocation;
import com.storepoints.apiportfolio.domain.Model;
import com.storepoints.apiportfolio.model.ModelRes;
import com.storepoints.apiportfolio.model.ModelRes.ModelType;
import com.storepoints.apiportfolio.model.ModelRes.RebalanceFrequency;

public class ModelToModelResConverter implements Converter<Model, ModelRes> {

	@Override
	public ModelRes convert(Model model) {
		ModelRes modelRes= new ModelRes();
		modelRes.setGuid(model.getGuid());
		modelRes.setName(model.getName());
		modelRes.setDescription(model.getDescription());
		modelRes.setCashHoldingPercentage(model.getCashHoldingPercentage());
		modelRes.setDriftPercentage(model.getDriftPercentage());
		modelRes.setCreatedOn(model.getCreatedOn());
		modelRes.setModelType(ModelType.valueOf(model.getModelType().toString()));
		modelRes.setRebalanceFrequency(RebalanceFrequency.valueOf(model.getRebalanceFrequency().toString()));
		modelRes.setAdvisorId(model.getAdvisorId());
		
		modelRes.setAssetAllocations(new ArrayList<com.storepoints.apiportfolio.model.AssetAllocation>());
		for(AssetAllocation assetAllocation:model.getAssetAllocations()){
			com.storepoints.apiportfolio.model.AssetAllocation assetAllocationModel= new com.storepoints.apiportfolio.model.AssetAllocation();
			assetAllocationModel.setSymbol(assetAllocation.getSymbol());
			assetAllocationModel.setPercentage(assetAllocation.getPercentage());
			modelRes.getAssetAllocations().add(assetAllocationModel);
		}
		
		return modelRes;
	}

}
