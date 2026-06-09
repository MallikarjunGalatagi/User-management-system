package com.logIn.util;

import com.logIn.dao.UserDAO;
import com.logIn.dao.impl.UserDAOImpl;
import com.logIn.model.User;

public class UserTest {

    public static void main(String[] args) {

        UserDAO dao = new UserDAOImpl();

        User user = new User();

        user.setEmail("test@gmail.com");
        user.setUserName("testuser");
        user.setPassword("12345");

        boolean status = dao.addUser(user);

        if(status) {
            System.out.println("User Added Successfully");
        } else {
            System.out.println("User Not Added");
        }
    }
}