/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.PurchaseOrder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chamath
 */
public class PurchaseOrderController {

    public String getNewId() throws ClassNotFoundException, SQLException {
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "POD" + (lastIdInt + 1);
    }

    private String getLastId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from purchaseOrder order by id desc";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "POD00";
        }
    }

    public ArrayList<String> getAllId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select DISTINCT id from purchaseOrder";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public String getSupplierName(String poid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select s.name from purchaseOrder p, supplier s where p.id = '" + poid + "' and p.sid = s.id";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            return resultSet.getString(1);
        } else {
            return "";
        }
    }
    
    public int addPurchaseOrder(PurchaseOrder purchaseOrder) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into purchaseOrder values ('" + purchaseOrder.getId() + "','" + purchaseOrder.getPid() + "','" + purchaseOrder.getSid()+ "','" + purchaseOrder.getoDate()+ "'," + purchaseOrder.getQty()+ ", "+purchaseOrder.getUnitPrice()+")";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public PurchaseOrder getPurchaseOrder(String poid, String pid) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from purchaseOrder where pid = '" + pid + "' and id = '"+poid+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        
        resultSet.next();
        
        double unitPrice = resultSet.getDouble(6);
        int qty = resultSet.getInt(5);
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setQty(qty);
        purchaseOrder.setUnitPrice(unitPrice);
        return purchaseOrder;
    }
}
