package com.example.unittesting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormFactor {

    private int id;
    private int phoneNo;

    private String userName;

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

    @Override
    public String toString() {
        return "FormFactor{" +
                "id=" + id +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
