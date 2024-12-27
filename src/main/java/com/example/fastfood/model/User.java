package com.example.fastfood.model;

public class User {
    private int id;
    private String phone, password, fullName, role;
    private Boolean status;



    public User(int id, String phone, String password, String fullName, String role, Boolean status) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public User(String phone, String password, String fullName, String role, Boolean status) {
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public User(String fullName, String phone, String password) {
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
    }

    public User(int idUser, String phone, String fullName) {
        this.phone = phone;
        this.id = idUser;
        this.fullName = fullName;
    }


    public User(int id, String phone, String password, String fullName, Boolean status) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
