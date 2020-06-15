package com.APIProject.apiProject.domain.model;

import java.util.Date;

import static com.APIProject.apiProject.util.JsonUtil.toJson;

public class IssueModel {
    private String Address;
    private String Client;
    private Integer phone;
    private String description;
    private Integer id;
    private Integer idClient;
    private Integer SupportUserAssigned;
    private Date reportTimestamp;
    private String service;
    private String status;

    //Getters and Setters
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getSupportUserAssigned() {
        return SupportUserAssigned;
    }

    public void setSupportUserAssigned(Integer supportUserAssigned) {
        SupportUserAssigned = supportUserAssigned;
    }

    public Date getReportTimestamp() {
        return reportTimestamp;
    }

    public void setReportTimestamp(Date reportTimestamp) {
        this.reportTimestamp = reportTimestamp;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){ return toJson(this);}
}