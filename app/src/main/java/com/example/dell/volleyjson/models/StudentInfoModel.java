package com.example.dell.volleyjson.models;

import java.io.Serializable;

/**
 * Created by Dell on 12/6/2017.
 */

public class StudentInfoModel implements Serializable {
    String id, name, phone_number, subject;

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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
