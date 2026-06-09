package com.logIn.model;

import java.sql.Timestamp;

public class User {


private int id;
private String email;
private String userName;
private String password;
private String mobileNo;
private Timestamp createdAt;

public User() {
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getMobileNo() {
    return mobileNo;
}

public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
}

public Timestamp getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
}


}
