/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chamath
 */
public class CustomerController {
    
    public ArrayList<String> getAllCustomerId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from customer";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> customerList = new ArrayList<>();
        
        while (resultSet.next()) {
            customerList.add(resultSet.getString(1));
        }
        return customerList;
    } 
    
    public String getNameById(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from customer where id = '"+id+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            return resultSet.getString(2)+" "+resultSet.getString(3);
        }else{
            return "Not Found";
        }     
    }
    
    public boolean ifExist(String id) throws ClassNotFoundException, SQLException{
        if("Not Found".equals(getNameById(id))){
            return false;
        }else{
            return true;
        }
    }
    
    public String getNewId() throws ClassNotFoundException, SQLException {
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "CUS" + (lastIdInt + 1);
    }

    private String getLastId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from customer order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "CUS000";
        }
    }
    
    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from customer";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String fName = resultSet.getString(2);
            String lName = resultSet.getString(3);
            String address = resultSet.getString(4);
            String mobileNumber = resultSet.getString(5);
            String email = resultSet.getString(6);
            String date = resultSet.getString(7);
            Customer customer = new Customer(id, fName, lName, address, mobileNumber, email, date);
            customerList.add(customer);
        }
        return customerList;
    }
    
    public int addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into customer values ('" + customer.getId() + "','" + customer.getFirstName()+ "','','" + customer.getAddress()+ "','" + customer.getMobileNumber()+ "','" + customer.getEmail()+ "','" + customer.getDate()+ "')";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public int updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "update customer set firstName = '" + customer.getFirstName()+ "', address = '" + customer.getAddress()+ "', mobileNumber = '" + customer.getMobileNumber()+ "', email = '" + customer.getEmail()+ "', date = '" + customer.getDate()+ "' where id = '"+customer.getId()+"'";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public int deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "delete from customer where id = '"+id+"'";
        int result = statement.executeUpdate(sql);
        return result;
    }
}
