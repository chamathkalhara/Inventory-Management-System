/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.IssueRegistered;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chamath
 */
public class IssueController {
    
    private StockProductController stockProductController;
    
    public String getNewId() throws ClassNotFoundException, SQLException{
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "SOI"+(lastIdInt+1);
    }
    
    private String getLastId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from issueRegistered order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if(result.next()){
            return result.getString(1);
        }else{
            return "SOI00";
        }
    }
    
    public void addIssueInventryRegistered(IssueRegistered issue) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into issueRegistered values ('" + issue.getId() + "','" + issue.getCid()+ "','" + issue.getPid()+ "','" + issue.getOrderDate()+ "'," + issue.getQty()+ ")";
        statement.executeUpdate(sql);
        //productController.updateVolume(issue.getQty());
        stockProductController.updateStock(issue.getQty(),"reduce",issue.getPid());
    }
}
