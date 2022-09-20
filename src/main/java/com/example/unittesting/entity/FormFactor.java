package com.example.unittesting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormFactor {

    private int id;
    private int phoneNo;

    public FormFactor(int id, int phoneNo) {
        this.id = id;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {
        return "FormFactor{" +
                "id=" + id +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
