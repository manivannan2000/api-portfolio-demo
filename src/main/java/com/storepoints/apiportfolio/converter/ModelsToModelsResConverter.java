package com.storepoints.apiportfolio.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.storepoints.apiportfolio.domain.AssetAllocation;
import com.storepoints.apiportfolio.domain.Model;
import com.storepoints.apiportfolio.model.ModelRes;
import com.storepoints.apiportfolio.model.ModelRes.ModelType;
import com.storepoints.apiportfolio.model.ModelRes.RebalanceFrequency;
import com.storepoints.apiportfolio.model.ModelsRes;

public class ModelsToModelsResConverter implements Converter<List<Model>, ModelsRes> {

	@Override
	public ModelsRes convert(List<Model> models) {
		ModelsRes modelsRes= new ModelsRes();
		
		modelsRes.setPage(new ArrayList<>());
		for(Model model: models){
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
			
			modelsRes.getPage().add(modelRes);
		}
		
		modelsRes.setTotalNumberOfElements(modelsRes.getPage().size());
		
		return modelsRes;
	}

}
