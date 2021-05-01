package com.ram.dto;

public class Skill
{
    private User user;
    private ServiceType serviceType;
    private int experience;
    private String certificateImage;
    private boolean approved;
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(final User user) {
        this.user = user;
    }
    
    public ServiceType getServiceType() {
        return this.serviceType;
    }
    
    public void setServiceType(final ServiceType serviceType) {
        this.serviceType = serviceType;
    }
    
    public int getExperience() {
        return this.experience;
    }
    
    public void setExperience(final int experience) {
        this.experience = experience;
    }
    
    public String getCertificateImage() {
        return this.certificateImage;
    }
    
    public void setCertificateImage(final String certificateImage) {
        this.certificateImage = certificateImage;
    }
    
    public boolean isApproved() {
        return this.approved;
    }
    
    public void setApproved(final boolean approved) {
        this.approved = approved;
    }
}