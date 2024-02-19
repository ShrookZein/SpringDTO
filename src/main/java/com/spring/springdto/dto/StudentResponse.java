package com.spring.springdto.dto;

public class StudentResponse {
    private String name;
    private String phone;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
