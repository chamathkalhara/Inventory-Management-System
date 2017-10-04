/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chamath
 */
public class CategoryController {
    
    public ArrayList<String> getAllCategoryNames() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from category";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> categoryList = new ArrayList<>();
        
        while (resultSet.next()) {
            categoryList.add(resultSet.getString(1));
        }
        return categoryList;
    } 
}
