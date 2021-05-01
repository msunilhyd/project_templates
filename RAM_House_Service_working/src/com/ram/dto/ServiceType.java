package com.ram.dto;

public class ServiceType
{
    int id;
    String description;
    float approxPrice;
    int subCategoryId;
    boolean deleted;
    String serviceTypeImage;
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getServiceTypeImage() {
        return this.serviceTypeImage;
    }
    
    public void setServiceTypeImage(final String serviceTypeImage) {
        this.serviceTypeImage = serviceTypeImage;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public float getApproxPrice() {
        return this.approxPrice;
    }
    
    public void setApproxPrice(final float approxPrice) {
        this.approxPrice = approxPrice;
    }
    
    public int getSubCategoryId() {
        return this.subCategoryId;
    }
    
    public void setSubCategoryId(final int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
    
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }
}