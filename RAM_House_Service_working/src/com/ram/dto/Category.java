package com.ram.dto;

import java.util.*;

public class Category
{
    private int id;
    private String type;
    private List<SubCategory> subCategoriesList;
    boolean deleted;
    String categoryImage;
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }
    
    public String getCategoryImage() {
        return this.categoryImage;
    }
    
    public void setCategoryImage(final String categoryImage) {
        this.categoryImage = categoryImage;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public List<SubCategory> getSubCategoriesList() {
        return this.subCategoriesList;
    }
    
    public void setSubCategoriesList(final List<SubCategory> subCategoriesList) {
        this.subCategoriesList = subCategoriesList;
    }
}