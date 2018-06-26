package com.storepoints.apiportfolio.model;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "symbol",
    "percentage"
})
public class AssetAllocation {

    /**
     * The asset symbol
     * (Required)
     * 
     */
    @JsonProperty("symbol")
    private String symbol;
    /**
     * The percentage of the model to allocate for the symbol
     * (Required)
     * 
     */
    @JsonProperty("percentage")
    private Double percentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The asset symbol
     * (Required)
     * 
     * @return
     *     The symbol
     */
    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    /**
     * The asset symbol
     * (Required)
     * 
     * @param symbol
     *     The symbol
     */
    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * The percentage of the model to allocate for the symbol
     * (Required)
     * 
     * @return
     *     The percentage
     */
    @JsonProperty("percentage")
    public Double getPercentage() {
        return percentage;
    }

    /**
     * The percentage of the model to allocate for the symbol
     * (Required)
     * 
     * @param percentage
     *     The percentage
     */
    @JsonProperty("percentage")
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(symbol).append(percentage).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AssetAllocation) == false) {
            return false;
        }
        AssetAllocation rhs = ((AssetAllocation) other);
        return new EqualsBuilder().append(symbol, rhs.symbol).append(percentage, rhs.percentage).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
