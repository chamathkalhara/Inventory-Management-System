/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.Product;
import ims.model.StockProduct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        Object[][] data = new Object[count][7];
        for (int i = 0; rst.next(); i++) {

            data[i] = new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5), rst.getDouble(6), rst.getDouble(6) * rst.getInt(5)};

        }
        DefaultTableModel dtm = new DefaultTableModel(data, column);
        return dtm;
    }

    public DefaultTableModel getProductDescriptionReportData() throws ClassNotFoundException, SQLException {
        ProductController productController = new ProductController();
        ArrayList<Product> allProducts = productController.getAllProducts();

        Object[] column = {"pid", "pName", "cName", "bName", "ptName"};

        Object[][] data = new Object[allProducts.size()][7];
        for (int i = 0; i < allProducts.size(); i++) {

            data[i] = new Object[]{allProducts.get(i).getId(), allProducts.get(i).getName(), allProducts.get(i).getCid(), allProducts.get(i).getBid(), allProducts.get(i).getPtid()};

        }
        DefaultTableModel dtm = new DefaultTableModel(data, column);
        return dtm;
    }
    
    public DefaultTableModel getInventoryLevelReportData() throws ClassNotFoundException, SQLException{
        StockProductController stockProductController = new StockProductController();
        ArrayList<StockProduct> allProducts = stockProductController.getAllStockProducts();

        ProductController productController = new ProductController();
        
        Object[] column = {"pid", "pName", "aQty", "expDate", "uPrice"};

        Object[][] data = new Object[allProducts.size()][5];
        for (int i = 0; i < allProducts.size(); i++) {
            String pid = productController.getIdByName(allProducts.get(i).getPid());
            data[i] = new Object[]{pid, allProducts.get(i).getPid(), allProducts.get(i).getQtyAvailable(), allProducts.get(i).getExpDate(), allProducts.get(i).getUnitPrice()};

        }
        DefaultTableModel dtm = new DefaultTableModel(data, column);
        return dtm;
    }
    
    public DefaultTableModel getIssueReportData() throws SQLException, ClassNotFoundException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();

        String sql = "select i.id as billID, c.firstName , c.lastName , p.name as pName, i.qty as qty, sp.unitPrice as uPrice, sp.unitPrice*i.qty as tPrice from product p, issueRegistered i, stockProducts sp, customer c where sp.pid = i.pid and p.id = i.pid and i.cid = c.id";
        ResultSet rst = stm.executeQuery(sql);

        Object[] column = {"billID", "cName", "pName", "qty", "uPrice", "tPrice"};
        int count = 0;
        while (rst.next()) {
            count++;
        }
        rst.beforeFirst();
        Object[][] data = new Object[count][6];
        for (int i = 0; rst.next(); i++) {

            data[i] = new Object[]{rst.getString(1), rst.getString(2)+" "+rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDouble(6), rst.getDouble(6) * rst.getInt(5)};

        }
        DefaultTableModel dtm = new DefaultTableModel(data, column);
        return dtm;
    }
}
