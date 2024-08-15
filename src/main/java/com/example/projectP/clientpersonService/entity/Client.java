package com.example.projectP.clientpersonService.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Person {
    private String password;
    private boolean isActive;

    public Client(String name, String dni, String gender, int age, String phone) {
        super(name, dni, gender, age, phone);
    }

    public Client() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Getters y Setters
}