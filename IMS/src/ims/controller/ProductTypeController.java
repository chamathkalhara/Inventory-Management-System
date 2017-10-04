/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.Category;
import ims.model.ProductType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chamath
 */
public class ProductTypeController {
    
    public ArrayList<String> getAllProductTypeNames() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from productType";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> productTypeList = new ArrayList<>();
        
        while (resultSet.next()) {
            productTypeList.add(resultSet.getString(1));
        }
        return productTypeList;
    } 
    
    public int addproductTypeList(ProductType productType) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into productType values ('"+productType.getId()+"','"+productType.getName()+"')";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public String getNewId() throws ClassNotFoundException, SQLException{
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "PRT"+lastIdInt+1;
    }
    
    private String getLastId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from productType desc 1 limit 1";
        ResultSet result = statement.executeQuery(sql);
        if(result.next()){
            return result.getString(0);
        }else{
            return "PRT000";
        }
    }
}
