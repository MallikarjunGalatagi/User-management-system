package com.logIn.dao.impl;

import com.logIn.dao.UserDAO;
import com.logIn.model.User;
import com.logIn.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {


@Override
public boolean addUser(User user) {

    String sql = "INSERT INTO users(email,user_name,password,mobile_no) VALUES(?,?,?,?)";

    try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, user.getEmail());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getMobileNo());

        return ps.executeUpdate() > 0;

    } catch(Exception e) {
        e.printStackTrace();
    }

    return false;
}

@Override
public User login(String loginId, String password) {

    String sql =
        "SELECT * FROM users WHERE (email=? OR user_name=?) AND password=?";

    try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, loginId);
        ps.setString(2, loginId);
        ps.setString(3, password);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            return mapUser(rs);
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}

@Override
public User getUserById(int id) {

    String sql = "SELECT * FROM users WHERE id=?";

    try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            return mapUser(rs);
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}

@Override
public List<User> getAllUsers() {

    List<User> users = new ArrayList<>();

    String sql = "SELECT * FROM users";

    try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {

        while(rs.next()) {
            users.add(mapUser(rs));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return users;
}

@Override
public boolean updateUser(User user) {

    String sql =
        "UPDATE users SET email=?,user_name=?,password=?,mobile_no=? WHERE id=?";

    try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, user.getEmail());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getMobileNo());
        ps.setInt(5, user.getId());

        return ps.executeUpdate() > 0;

    } catch(Exception e) {
        e.printStackTrace();
    }

    return false;
}

@Override
public boolean deleteUser(int id) {

    String sql = "DELETE FROM users WHERE id=?";

    try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);

        return ps.executeUpdate() > 0;

    } catch(Exception e) {
        e.printStackTrace();
    }

    return false;
}

private User mapUser(ResultSet rs) throws SQLException {

    User user = new User();

    user.setId(rs.getInt("id"));
    user.setEmail(rs.getString("email"));
    user.setUserName(rs.getString("user_name"));
    user.setPassword(rs.getString("password"));
    user.setMobileNo(rs.getString("mobile_no"));
    user.setCreatedAt(rs.getTimestamp("created_at"));

    return user;
}


}
