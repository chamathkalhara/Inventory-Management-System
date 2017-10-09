/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.Supplier;
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
    
    public ArrayList<String> getAllSupplierId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from supplier";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> supplierList = new ArrayList<>();
        
        while (resultSet.next()) {
            supplierList.add(resultSet.getString(1));
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
    
    public boolean ifExist(String id) throws ClassNotFoundException, SQLException{
        if("Not Found".equals(getNameById(id))){
            return false;
        }else{
            return true;
        }
    }
    
    public String getNameById(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from supplier where id = '"+id+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            return resultSet.getString(2);
        }else{
            return "Not Found";
        }     
    }
    
    public String getNewId() throws ClassNotFoundException, SQLException {
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "SUP" + (lastIdInt + 1);
    }

    private String getLastId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from supplier order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "SUP000";
        }
    }
    
    public ArrayList<Supplier> getAllSuppliers() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from supplier";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Supplier> supplierList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String nic = resultSet.getString(5);
            String address = resultSet.getString(6);
            String mobileNumber = resultSet.getString(3);
            String email = resultSet.getString(4);
            
            Supplier supplier = new Supplier(id, name, mobileNumber, email, nic, address);
            supplierList.add(supplier);
        }
        return supplierList;
    }
    
    public int addSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into supplier values ('" + supplier.getId() + "','" + supplier.getName()+ "','" + supplier.getMobileNumber()+ "','" + supplier.getEmail()+ "','" + supplier.getNic()+ "','" + supplier.getAddress()+ "')";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public int updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "update supplier set name = '" + supplier.getName()+ "', address = '" + supplier.getAddress()+ "', mobileNumber = '" + supplier.getMobileNumber()+ "', email = '" + supplier.getEmail()+ "', nic = '" + supplier.getNic()+ "' where id = '"+supplier.getId()+"'";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public int deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "delete from supplier where id = '"+id+"'";
        int result = statement.executeUpdate(sql);
        return result;
    }
}
