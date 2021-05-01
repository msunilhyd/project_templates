package com.ram.dto;

import java.util.*;

public class SubCategory
{
    private int id;
    private String type;
    boolean deleted;
    private List<ServiceType> servicesList;
    int categoryId;
    String subCategoryImage;
    Category category;
    
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(final Category category) {
        this.category = category;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setCategoryId(final int categoryId) {
        this.categoryId = categoryId;
    }
    
    public int getCategoryId() {
        return this.categoryId;
    }
    
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }
    
    public String getSubCategoryImage() {
        return this.subCategoryImage;
    }
    
    public void setSubCategoryImage(final String subCategoryImage) {
        this.subCategoryImage = subCategoryImage;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public List<ServiceType> getServicesList() {
        return this.servicesList;
    }
    
    public void setServicesList(final List<ServiceType> servicesList) {
        this.servicesList = servicesList;
    }
}