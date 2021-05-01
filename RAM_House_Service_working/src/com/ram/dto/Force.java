package com.ram.dto;

import java.util.*;

public class Force extends User
{
    private String aadharImage;
    private List<Skill> skillsList;
    
    public String getAadharImage() {
        return this.aadharImage;
    }
    
    public void setAadharImage(final String aadharImage) {
        this.aadharImage = aadharImage;
    }
    
    public List<Skill> getSkillsList() {
        return this.skillsList;
    }
    
    public void setSkillsList(final List<Skill> skillsList) {
        this.skillsList = skillsList;
    }
}