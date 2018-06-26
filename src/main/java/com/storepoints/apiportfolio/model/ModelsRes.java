package com.storepoints.apiportfolio.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "pageNumber",
    "pageSize",
    "numberOfPages",
    "totalNumberOfElements",
    "page"
})
public class ModelsRes {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pageNumber")
    private Integer pageNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pageSize")
    private Integer pageSize;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPages")
    private Integer numberOfPages;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalNumberOfElements")
    private Integer totalNumberOfElements;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("page")
    private List<Object> page = new ArrayList<Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pageNumber
     */
    @JsonProperty("pageNumber")
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * 
     * (Required)
     * 
     * @param pageNumber
     *     The pageNumber
     */
    @JsonProperty("pageNumber")
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pageSize
     */
    @JsonProperty("pageSize")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 
     * (Required)
     * 
     * @param pageSize
     *     The pageSize
     */
    @JsonProperty("pageSize")
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The numberOfPages
     */
    @JsonProperty("numberOfPages")
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * 
     * (Required)
     * 
     * @param numberOfPages
     *     The numberOfPages
     */
    @JsonProperty("numberOfPages")
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The totalNumberOfElements
     */
    @JsonProperty("totalNumberOfElements")
    public Integer getTotalNumberOfElements() {
        return totalNumberOfElements;
    }

    /**
     * 
     * (Required)
     * 
     * @param totalNumberOfElements
     *     The totalNumberOfElements
     */
    @JsonProperty("totalNumberOfElements")
    public void setTotalNumberOfElements(Integer totalNumberOfElements) {
        this.totalNumberOfElements = totalNumberOfElements;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The page
     */
    @JsonProperty("page")
    public List<Object> getPage() {
        return page;
    }

    /**
     * 
     * (Required)
     * 
     * @param page
     *     The page
     */
    @JsonProperty("page")
    public void setPage(List<Object> page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pageNumber).append(pageSize).append(numberOfPages).append(totalNumberOfElements).append(page).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ModelsRes) == false) {
            return false;
        }
        ModelsRes rhs = ((ModelsRes) other);
        return new EqualsBuilder().append(pageNumber, rhs.pageNumber).append(pageSize, rhs.pageSize).append(numberOfPages, rhs.numberOfPages).append(totalNumberOfElements, rhs.totalNumberOfElements).append(page, rhs.page).isEquals();
    }

}
