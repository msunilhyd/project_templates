package com.ram.dto;

import java.util.*;

public class User
{
    int id;
    private String name;
    private String password;
    private String emailId;
    private Date registrationDate;
    private long mobileNumber;
    private String role;
    private List<Address> addressList;
    private List<Work> worksList;
    
    public List<Address> getAddressList() {
        return this.addressList;
    }
    
    public void setAddressList(final List<Address> addressList) {
        this.addressList = addressList;
    }
    
    public List<Work> getWorksList() {
        return this.worksList;
    }
    
    public void setWorksList(final List<Work> worksList) {
        this.worksList = worksList;
    }
    
    public Date getRegistrationDate() {
        return this.registrationDate;
    }
    
    public void setRegistrationDate(final Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public long getMobileNumber() {
        return this.mobileNumber;
    }
    
    public void setMobileNumber(final long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getEmailId() {
        return this.emailId;
    }
    
    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public void setRole(final String role) {
        this.role = role;
    }
}