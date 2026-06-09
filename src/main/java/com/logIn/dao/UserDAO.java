package com.logIn.dao;

import java.util.List;
import com.logIn.model.User;

public interface UserDAO {


boolean addUser(User user);

User login(String loginId, String password);

User getUserById(int id);

List<User> getAllUsers();

boolean updateUser(User user);

boolean deleteUser(int id);


}
