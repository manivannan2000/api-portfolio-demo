package com.storepoints.apiportfolio.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "description",
    "cashHoldingPercentage",
    "driftPercentage",
    "createdOn",
    "modelType",
    "rebalanceFrequency",
    "assetAllocations"
})
public class ModelReq {

    /**
     * Unique Name for the model
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * Description of the model
     * (Required)
     * 
     */
    @JsonProperty("description")
    private String description;
    /**
     * Percentage of cash to hold in the model
     * (Required)
     * 
     */
    @JsonProperty("cashHoldingPercentage")
    private Integer cashHoldingPercentage;
    /**
     * Percentage of drift from target allocation of assets
     * (Required)
     * 
     */
    @JsonProperty("driftPercentage")
    private Integer driftPercentage;
    /**
     * Date model created
     * 
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /**
     * Type of model
     * (Required)
     * 
     */
    @JsonProperty("modelType")
    private ModelReq.ModelType modelType;
    /**
     * Frequency to rebalance model
     * (Required)
     * 
     */
    @JsonProperty("rebalanceFrequency")
    private ModelReq.RebalanceFrequency rebalanceFrequency;
    /**
     * Asset Allocations
     * (Required)
     * 
     */
    @JsonProperty("assetAllocations")
    private List<AssetAllocation> assetAllocations = new ArrayList<AssetAllocation>();

    /**
     * Unique Name for the model
     * (Required)
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Unique Name for the model
     * (Required)
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description of the model
     * (Required)
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description of the model
     * (Required)
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Percentage of cash to hold in the model
     * (Required)
     * 
     * @return
     *     The cashHoldingPercentage
     */
    @JsonProperty("cashHoldingPercentage")
    public Integer getCashHoldingPercentage() {
        return cashHoldingPercentage;
    }

    /**
     * Percentage of cash to hold in the model
     * (Required)
     * 
     * @param cashHoldingPercentage
     *     The cashHoldingPercentage
     */
    @JsonProperty("cashHoldingPercentage")
    public void setCashHoldingPercentage(Integer cashHoldingPercentage) {
        this.cashHoldingPercentage = cashHoldingPercentage;
    }

    /**
     * Percentage of drift from target allocation of assets
     * (Required)
     * 
     * @return
     *     The driftPercentage
     */
    @JsonProperty("driftPercentage")
    public Integer getDriftPercentage() {
        return driftPercentage;
    }

    /**
     * Percentage of drift from target allocation of assets
     * (Required)
     * 
     * @param driftPercentage
     *     The driftPercentage
     */
    @JsonProperty("driftPercentage")
    public void setDriftPercentage(Integer driftPercentage) {
        this.driftPercentage = driftPercentage;
    }
    
    /**
     * Date model created
     * 
     * @return
     *     The createdOn
     */
    @JsonProperty("createdOn")
    public String getCreatedOn() {
        return createdOn;
    }

    /**
     * Date model created
     * 
     * @param createdOn
     *     The createdOn
     */
    @JsonProperty("createdOn")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
    

    /**
     * Type of model
     * (Required)
     * 
     * @return
     *     The modelType
     */
    @JsonProperty("modelType")
    public ModelReq.ModelType getModelType() {
        return modelType;
    }

    /**
     * Type of model
     * (Required)
     * 
     * @param modelType
     *     The modelType
     */
    @JsonProperty("modelType")
    public void setModelType(ModelReq.ModelType modelType) {
        this.modelType = modelType;
    }

    /**
     * Frequency to rebalance model
     * (Required)
     * 
     * @return
     *     The rebalanceFrequency
     */
    @JsonProperty("rebalanceFrequency")
    public ModelReq.RebalanceFrequency getRebalanceFrequency() {
        return rebalanceFrequency;
    }

    /**
     * Frequency to rebalance model
     * (Required)
     * 
     * @param rebalanceFrequency
     *     The rebalanceFrequency
     */
    @JsonProperty("rebalanceFrequency")
    public void setRebalanceFrequency(ModelReq.RebalanceFrequency rebalanceFrequency) {
        this.rebalanceFrequency = rebalanceFrequency;
    }

    /**
     * Asset Allocations
     * (Required)
     * 
     * @return
     *     The assetAllocations
     */
    @JsonProperty("assetAllocations")
    public List<AssetAllocation> getAssetAllocations() {
        return assetAllocations;
    }

    /**
     * Asset Allocations
     * (Required)
     * 
     * @param assetAllocations
     *     The assetAllocations
     */
    @JsonProperty("assetAllocations")
    public void setAssetAllocations(List<AssetAllocation> assetAllocations) {
        this.assetAllocations = assetAllocations;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(description).append(cashHoldingPercentage).append(driftPercentage).append(createdOn).append(modelType).append(rebalanceFrequency).append(assetAllocations).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ModelReq) == false) {
            return false;
        }
        ModelReq rhs = ((ModelReq) other);
        return new EqualsBuilder().append(name, rhs.name).append(description, rhs.description).append(cashHoldingPercentage, rhs.cashHoldingPercentage).append(driftPercentage, rhs.driftPercentage).append(createdOn, rhs.createdOn).append(modelType, rhs.modelType).append(rebalanceFrequency, rhs.rebalanceFrequency).append(assetAllocations, rhs.assetAllocations).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum ModelType {

        QUALIFIED("QUALIFIED"),
        TAXABLE("TAXABLE");
        private final String value;
        private static Map<String, ModelReq.ModelType> constants = new HashMap<String, ModelReq.ModelType>();

        static {
            for (ModelReq.ModelType c: values()) {
                constants.put(c.value, c);
            }
        }

        private ModelType(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static ModelReq.ModelType fromValue(String value) {
            ModelReq.ModelType constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public static enum RebalanceFrequency {

        MONTHLY("MONTHLY"),
        QUARTERLY("QUARTERLY"),
        SEMI_ANNUAL("SEMI_ANNUAL"),
        ANNUAL("ANNUAL");
        private final String value;
        private static Map<String, ModelReq.RebalanceFrequency> constants = new HashMap<String, ModelReq.RebalanceFrequency>();

        static {
            for (ModelReq.RebalanceFrequency c: values()) {
                constants.put(c.value, c);
            }
        }

        private RebalanceFrequency(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static ModelReq.RebalanceFrequency fromValue(String value) {
            ModelReq.RebalanceFrequency constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
