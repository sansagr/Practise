package org.example.onlinebookstore.models;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private int age;
    private String address;
    private String email;
    private String phoneNo;

    public User (String id, String name, int age, String address, String email, String phoneNo){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
    }
}
