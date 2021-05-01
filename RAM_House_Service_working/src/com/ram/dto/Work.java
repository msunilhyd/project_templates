package com.ram.dto;

import java.util.*;

public class Work
{
    private int id;
    private Date postedDate;
    private User postedBy;
    private ServiceType service;
    private String description;
    private boolean status;
    private Address address;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setPostedDate(final Date postedDate) {
        this.postedDate = postedDate;
    }
    
    public User getPostedBy() {
        return this.postedBy;
    }
    
    public void setPostedBy(final User postedBy) {
        this.postedBy = postedBy;
    }
    
    public ServiceType getService() {
        return this.service;
    }
    
    public void setService(final ServiceType service) {
        this.service = service;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(final boolean status) {
        this.status = status;
    }
    
    public Date getPostedDate() {
        return this.postedDate;
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(final Address address) {
        this.address = address;
    }
}