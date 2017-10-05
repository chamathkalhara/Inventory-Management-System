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

/**
 *
 * @author Chamath
 */
public class StockProductController {
    
    private ProductController productController = new ProductController();
    private SupplierController supplierController = new SupplierController();
    
    public String getNewId() throws ClassNotFoundException, SQLException{
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "STP"+(lastIdInt+1);
    }
    
    private String getLastId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from stockProducts order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if(result.next()){
            return result.getString(1);
        }else{
            return "STP00";
        }
    }
    
    public ArrayList<StockProduct> getAllStockProducts() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select sp.id,p.name,s.name,sp.unitPrice,sp.expDate,sp.recievedDate,sp.qtyOrdered,sp.qtyRecieved from stockProducts sp, product p, supplier s where sp.pid = p.id and sp.sid = s.id";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<StockProduct> productList = new ArrayList<>();
        
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String product = resultSet.getString(2);
            String supplier = resultSet.getString(3);
            double unitPrice = resultSet.getDouble(4);
            String expDate = resultSet.getString(5);
            String recievedDate = resultSet.getString(6);
            int qtyOrdered = resultSet.getInt(7);
            int qtyRecieved = resultSet.getInt(8);
            StockProduct stockProduct = new StockProduct(id, product, supplier, unitPrice, expDate, recievedDate, qtyOrdered, qtyRecieved);
            productList.add(stockProduct);
        }
        return productList;
    }
    
    public int addStockProduct(StockProduct product) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into stockProducts values ('"+product.getId()+"','"+productController.getIdByName(product.getPid())+"','"+supplierController.getIdByName(product.getSid())+"',"+product.getUnitPrice()+",'"+product.getExpDate()+"','"+product.getRecievedDate()+"',"+product.getQtyOrdered()+", "+product.getQtyRecieved()+")";
        int result = statement.executeUpdate(sql);
        return result;
    }
    
    public int deleteRecord(String id) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "delete from stockProducts where id = '"+id+"'";
        int result = statement.executeUpdate(sql);
        return result;
    }
}
