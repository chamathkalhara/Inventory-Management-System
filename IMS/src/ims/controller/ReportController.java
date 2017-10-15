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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chamath
 */
public class ReportController {

    public DefaultTableModel getGoodReceiveNoteReport(String sid) throws ClassNotFoundException, SQLException {

        
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();

        String sql = "select g.poid as oid, g.pid as pid, p.name as pName, po.qty as oQty, g.qty as rQty, po.unitPrice as uPrice, po.unitPrice*g.qty as tPrice from product p, goodsReceived g, purchaseOrder po where po.sid ='" + sid + "' and po.id = g.poid and po.pid = g.pid and p.id = po.pid";
        ResultSet rst = stm.executeQuery(sql);

        Object[] column = {"oid", "pid", "pName", "oQty", "rQty", "uPrice", "tPrice"};
        int count = 0;
        while (rst.next()) {
            count++;
        }
        rst.beforeFirst();
        Object[][] data = new Object[count][6];
        for (int i = 0; rst.next(); i++) {

            data[i] = new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5), rst.getDouble(6) , rst.getDouble(6)*rst.getInt(5)};

        }
        DefaultTableModel dtm = new DefaultTableModel(data, column);
        return dtm;
    }
}
