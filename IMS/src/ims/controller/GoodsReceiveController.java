/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.GoodsReceived;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chamath
 */
public class GoodsReceiveController {

    public String getReceivedDate(String poid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from goodsReceived where poid = '" + poid + "'";
        ResultSet result = statement.executeQuery(sql);
        if(result.next())
            return result.getString(2);
        else
            return "";
    }

    public GoodsReceived getReceivedGoods(String poid, String pid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from goodsReceived where poid = '" + poid + "' and pid = ''" + pid + "";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            GoodsReceived goodsReceived = new GoodsReceived();
            goodsReceived.setPoid(result.getString(1));
            goodsReceived.setrDate(result.getString(2));
            goodsReceived.setPid(result.getString(3));
            goodsReceived.setQty(result.getInt(1));
            return goodsReceived;
        }else{
            return null;
        }
    }
    
    public int addReceivedGood(GoodsReceived goodsReceived) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into goodsReceived values ('" + goodsReceived.getPoid()+ "','" + goodsReceived.getrDate()+ "','" + goodsReceived.getPid()+ "'," + goodsReceived.getQty()+ ")";
        int result = statement.executeUpdate(sql);
        return result;
    }
}
