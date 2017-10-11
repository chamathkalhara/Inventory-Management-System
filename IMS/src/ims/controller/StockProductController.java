/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.StockProduct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chamath
 */
public class StockProductController {

    private ProductController productController = new ProductController();
    private SupplierController supplierController = new SupplierController();

    public String getNewId() throws ClassNotFoundException, SQLException {
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "STP" + (lastIdInt + 1);
    }

    private String getLastId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from stockProducts order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "STP00";
        }
    }

    public ArrayList<StockProduct> getAllStockProducts() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select sp.id,p.name,sp.unitPrice,sp.expDate,sp.qtyAvailable from stockProducts sp, product p where sp.pid = p.id";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<StockProduct> productList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String product = resultSet.getString(2);
            double unitPrice = resultSet.getDouble(3);
            String expDate = resultSet.getString(4);
            int qtyAvailable = resultSet.getInt(5);
            StockProduct stockProduct = new StockProduct(id, product, unitPrice, expDate, qtyAvailable);
            productList.add(stockProduct);
        }
        return productList;
    }

    public StockProduct getStockProductByPid(String pid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from stockProducts where pid = '" + pid + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        
        resultSet.next();
        String id = resultSet.getString(1);
        String product = resultSet.getString(2);
        double unitPrice = resultSet.getDouble(3);
        String expDate = resultSet.getString(4);
        int qtyAvailable = resultSet.getInt(5);
        StockProduct stockProduct = new StockProduct(id, product, unitPrice, expDate, qtyAvailable);
        return stockProduct;

    }

    public int addStockProduct(StockProduct product) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into stockProducts values ('" + product.getId() + "','" + productController.getIdByName(product.getPid()) + "'," + product.getUnitPrice() + ",'" + product.getExpDate() + "'," + product.getQtyAvailable()+ ")";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public int updateStockProduct(StockProduct product) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "update stockProducts set id = '" + product.getId() + "', unitPrice = " + product.getUnitPrice() + ", expDate = '" + product.getExpDate() + "',qtyAvailable = " + product.getQtyAvailable()+ " where pid = '"+product.getPid()+"'";
        int result = statement.executeUpdate(sql);
        return result;
    }

    public int deleteRecord(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "delete from stockProducts where id = '" + id + "'";
        int result = statement.executeUpdate(sql);
        return result;
    }

    public int updateStock(int qty, String type, String pid) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "";
        if (type.equals("reduce")) {
            sql = "update stockProducts set qtyAvailable = qtyAvailable - " + qty + " where pid = '" + pid + "'";
        } else if (type.equals("increase")) {
            sql = "update stockProducts set qtyAvailable = qtyAvailable + " + qty + " where pid = '" + pid + "'";
        }

        return statement.executeUpdate(sql);
    }

}
