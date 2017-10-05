/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.Category;
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
            categoryList.add(resultSet.getString(2));
        }
        return categoryList;
    } 
    
    public int addCategory(Category category) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into category values ('"+category.getId()+"','"+category.getName()+"')";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public String getNewId() throws ClassNotFoundException, SQLException{
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "CAT"+(lastIdInt+1);
    }
    
    private String getLastId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from category order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if(result.next()){
            return result.getString(1);
        }else{
            return "CAT000";
        }
    }
    
    public String getIdByName(String name) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from category where name = '"+name+"'";
        ResultSet result = statement.executeQuery(sql);
        result.next();
        return result.getString(1);
    }
}
