/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chamath
 */
public class LoginController {

    public static User getUser(String userName) throws SQLException, ClassNotFoundException {
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from users where userName = '" + userName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        User user = new User();
        user.setUserName(userName);
        if (resultSet.next()) {
            String password = resultSet.getString("password");
            String type = resultSet.getString("type");
            user.setPassword(password);
            user.setType(type);
        }
        return user;
    }
}
