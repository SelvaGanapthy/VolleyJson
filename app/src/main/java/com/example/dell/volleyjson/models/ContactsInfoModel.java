package com.example.dell.volleyjson.models;

import java.io.Serializable;

/**
 * Created by Dell on 12/6/2017.
 */

public class ContactsInfoModel implements Serializable {
    String id, name,email,address, phone_mobile,phone_office,phone_home;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_mobile() {
        return phone_mobile;
    }

    public void setPhone_mobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
    }

    public String getPhone_office() {
        return phone_office;
    }

    public void setPhone_office(String phone_office) {
        this.phone_office = phone_office;
    }

    public String getPhone_home() {
        return phone_home;
    }

    public void setPhone_home(String phone_home) {
        this.phone_home = phone_home;
    }
}
