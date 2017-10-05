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
 * @author Chamath
 */
public class SupplierController {
    
    public ArrayList<String> getAllSupplierNames() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from supplier";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> supplierList = new ArrayList<>();
        
        while (resultSet.next()) {
            supplierList.add(resultSet.getString(2));
        }
        return supplierList;
    } 
    
    public String getIdByName(String name) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from supplier where name = '"+name+"'";
        ResultSet result = statement.executeQuery(sql);
        result.next();
        return result.getString(1);
    }
}
