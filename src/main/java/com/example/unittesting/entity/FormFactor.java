package com.example.unittesting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class FormFactor {

    @Id
    private int id;
    private int phoneNo;
    private String userName;

    @Transient
    private String details;

    public FormFactor() {
    }

    public FormFactor(int id, int phoneNo, String userName) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "FormFactor{" +
                "id=" + id +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
