package com.storepoints.apiportfolio.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Model implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String guid;

	@Column(nullable = false)
    private String name;
	

	@Column(nullable = false)
    private String description;
	
	@Column(nullable = false)
	private Integer cashHoldingPercentage;
	
	@Column(nullable = false)
    private Integer driftPercentage;
	
	@Column(nullable = false)
    private String createdOn;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ModelType modelType;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RebalanceFrequency rebalanceFrequency;
	
	@Column(nullable = false)
    private String advisorId;
	
	
	@OneToMany(
	        mappedBy = "model", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true)
	private List<AssetAllocation> assetAllocations; 	
	
	protected Model() {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly
	}
	
	public Model(String name){
		this.name=name;
	}
	
	

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCashHoldingPercentage() {
		return cashHoldingPercentage;
	}

	public void setCashHoldingPercentage(Integer cashHoldingPercentage) {
		this.cashHoldingPercentage = cashHoldingPercentage;
	}

	public Integer getDriftPercentage() {
		return driftPercentage;
	}

	public void setDriftPercentage(Integer driftPercentage) {
		this.driftPercentage = driftPercentage;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public ModelType getModelType() {
		return modelType;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

	public RebalanceFrequency getRebalanceFrequency() {
		return rebalanceFrequency;
	}

	public void setRebalanceFrequency(RebalanceFrequency rebalanceFrequency) {
		this.rebalanceFrequency = rebalanceFrequency;
	}

	public String getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(String advisorId) {
		this.advisorId = advisorId;
	}

	public List<AssetAllocation> getAssetAllocations() {
		return assetAllocations;
	}

	public void setAssetAllocations(List<AssetAllocation> assetAllocations) {
		this.assetAllocations = assetAllocations;
	}
	
	 public void addAssetAllocation(AssetAllocation assetAllocation) {
		 assetAllocations.add(assetAllocation);
		 assetAllocation.setModel(this);
	 }	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Model )) return false;
	
		return guid != null && guid.equals(((Model) o).guid);
	}

	@Override
	public int hashCode() {
		return 33;
	}	
	

}


