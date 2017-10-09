/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.ReturnInventory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chamath
 */
public class ReturnInventoryController {
    
    private StockProductController stockProductController = new StockProductController();
    
    public String getNewId() throws ClassNotFoundException, SQLException {
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "RTI" + (lastIdInt + 1);
    }

    private String getLastId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from returnInventory order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "RTI000";
        }
    }
    
    public void addReturnInventory(ReturnInventory returnI) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into returnInventory values ('" + returnI.getId() + "','" + returnI.getPid()+ "'," + returnI.getQtyReturn()+ "," + returnI.getUnitPrice()+ ",'" + returnI.getrDate()+ "')";
        statement.executeUpdate(sql);
        //productController.updateVolume(issue.getQty());
        stockProductController.updateStock(returnI.getQtyReturn(),"increase",returnI.getPid());
    }
}
