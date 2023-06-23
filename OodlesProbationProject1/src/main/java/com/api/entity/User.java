package com.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private int active= 1; // Tells whether a user is active(1) or not active(0)

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(int active) {
        this.active = active;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getActive() {
        return active;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", age: " + age + ", active: " + active;
    }

}
