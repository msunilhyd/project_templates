package com.ram.dto;

public class Address
{
    private int id;
    private String doorno;
    private String street;
    private String city;
    private String state;
    boolean deleted;
    private String postalCode;
    private int userId;
    
    public String getDoorno() {
        return this.doorno;
    }
    
    public void setDoorno(final String doorno) {
        this.doorno = doorno;
    }
    
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(final String street) {
        this.street = street;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setState(final String state) {
        this.state = state;
    }
    
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }
    
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }
}