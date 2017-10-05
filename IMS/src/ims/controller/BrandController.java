/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.Brand;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chamath
 */
public class BrandController {
    
    public ArrayList<String> getAllBrandNames() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from brand";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> brandList = new ArrayList<>();
        
        while (resultSet.next()) {
            brandList.add(resultSet.getString(2));
        }
        return brandList;
    } 
    
    public int addBrandList(Brand brand) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into brand values ('"+brand.getId()+"','"+brand.getName()+"')";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public String getNewId() throws ClassNotFoundException, SQLException{
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "BND"+(lastIdInt+1);
    }
    
    private String getLastId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from brand order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if(result.next()){
            return result.getString(1);
        }else{
            return "BND00";
        }
    }
    
    public String getIdByName(String name) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from brand where name = '"+name+"'";
        ResultSet result = statement.executeQuery(sql);
        result.next();
        return result.getString(1);
    }
}
