package com.storepoints.apiportfolio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AssetAllocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;	

	@Column(nullable = false)
    private String symbol;
	
	@Column(nullable = false)
    private Double percentage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model_id")
	private Model model;
	
	protected AssetAllocation() {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly
	}
	
	public AssetAllocation(String symbol, Double percentage){
		this.symbol= symbol;
		this.percentage= percentage;
	}

	public String getSymbol() {
		return symbol;
	}


	public Double getPercentage() {
		return percentage;
	}
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AssetAllocation )) return false;
	
		return id != null && id.equals(((AssetAllocation) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}	

}
