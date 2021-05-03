package com.ram.service;

import java.util.*;
import com.ram.dto.*;
import com.ram.dao.*;

public class RAMService
{
    public boolean addCategory(final Category category) {
        return CategoryDAO.add(category);
    }
    
    public boolean deleteCategory(final int categoryId) {
        return CategoryDAO.delete(categoryId);
    }
    
    public Category getCategory(final int categoryId) {
        return CategoryDAO.get(categoryId);
    }
    
    public List<Category> getCategories() {
        return (List<Category>)CategoryDAO.getCategories();
    }
    
    public boolean addSubCategory(final SubCategory subCategory) {
        return SubCategoryDAO.add(subCategory);
    }
    
    public boolean deleteSubCategory(final int subCategoryId) {
        return SubCategoryDAO.delete(subCategoryId);
    }
    
    public SubCategory getSubCategory(final int subCategoryId) {
        return SubCategoryDAO.get(subCategoryId);
    }
    
    public List<SubCategory> getSubCategories() {
        return (List<SubCategory>)SubCategoryDAO.getSubCategories();
    }
    
    public List<SubCategory> getSubCategories(final int categoryId) {
        return (List<SubCategory>)SubCategoryDAO.getSubCategories(categoryId);
    }
    
    public boolean addServiceType(final ServiceType serviceType) {
        return ServiceTypeDAO.add(serviceType);
    }
    
    public boolean deleteServiceType(final int serviceTypeId) {
        return ServiceTypeDAO.delete(serviceTypeId);
    }
    
    public ServiceType getServiceType(final int serviceTypeId) {
        return ServiceTypeDAO.get(serviceTypeId);
    }
    
    public List<ServiceType> getServiceTypes(final int subCategoryId) {
        return (List<ServiceType>)ServiceTypeDAO.getServiceTypes(subCategoryId);
    }
    
    public List<ServiceType> getForceServiceTypes(final int userId) {
        return (List<ServiceType>)ServiceTypeDAO.getServiceTypes(userId);
    }
    
    public List<ServiceType> getServiceTypes() {
        return (List<ServiceType>)ServiceTypeDAO.getServiceTypes();
    }
    
    public User registerUser(final User user) {
        return UserDAO.register(user);
    }
    
    public User loginUser(final String email, final String password) {
        return UserDAO.login(email, password);
    }

    
    public User getUserDetails(final int userId) {
        return new UserDAO().get(userId);
    }
    
    public User getUserDetails(final String emailId) {
        return new UserDAO().get(emailId);
    }
    
    public Address addAddress(final Address address) {
        return new AddressDAO().add(address);
    }
    
    public boolean addAWork(final Work work) {
        return new WorkDAO().addWork(work);
    }
    
    public boolean deleteAddress(final int addressId) {
        return new AddressDAO().delete(addressId);
    }
    
    public Address getAddress(final int addressId) {
        return new AddressDAO().get(addressId);
    }
    
    public List<Address> getAddressList(final int userId) {
        return (List<Address>)new AddressDAO().getAddressList(userId);
    }
    
    public boolean updateUserDetails(final String password, final long mobileNumber, final int userId) {
        return new UserDAO().updateUserDetails(password, mobileNumber, userId);
    }
    
    public Force registerForce(final Force force) {
        return ForceDAO.register(force);
    }
    
    public Force loginForce(final String email, final String password) {
        return new ForceDAO().login(email, password);
    }
    
    public Force getForceDetails(final int userId) {
        return new ForceDAO().get(userId);
    }
    
    public Force getForceDetails(final String emailId) {
        return new ForceDAO().get(emailId);
    }
    
    public boolean approveForce(final int userId, final int serviceId, final char status) {
        return new ForceDAO().approveForce(userId, serviceId, status);
    }
    
    public List<Skill> getSkillsList(final Force force) {
        return (List<Skill>)new SkillDAO().getSkillsList(force);
    }
    
    
    public boolean addSkill(final Skill skill) {
        return new SkillDAO().addSkill(skill);
    }
    
    
    public List<Work> getActiveWorks(final int forceId) {
        return (List<Work>)new WorkDAO().getWorks(forceId);
    }
    
    public List<Skill> getUnapprovedSkillsList() {
        return (List<Skill>)new SkillDAO().getUnapprovedSkillsList();
    }
}