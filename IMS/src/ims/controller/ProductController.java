/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.controller;

import ims.db.DBConnection;
import ims.model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chamath
 */
public class ProductController {

    private BrandController brandController = new BrandController();
    private CategoryController categoryController = new CategoryController();
    private ProductTypeController productTypeController = new ProductTypeController();

    public ArrayList<String> getAllProductNames() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from product";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> productList = new ArrayList<>();

        while (resultSet.next()) {
            productList.add(resultSet.getString(2));
        }
        return productList;
    }
    
    public ArrayList<String> getAllProductNamesForPOID(String poid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select p.name from product p , purchaseorder po where po.pid = p.id AND po.id = '"+poid+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> productList = new ArrayList<>();

        while (resultSet.next()) {
            productList.add(resultSet.getString(1));
        }
        return productList;
    }
    
    public ArrayList<String> getAllProductId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from product";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> productList = new ArrayList<>();

        while (resultSet.next()) {
            productList.add(resultSet.getString(1));
        }
        return productList;
    }

    public Product getProductById(String id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from product where id = '" + id + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        String name = resultSet.getString(2);
        String category = resultSet.getString(3);
        String brand = resultSet.getString(4);
        String productType = resultSet.getString(5);
        String sid = resultSet.getString(6);
        int safetyStock = resultSet.getInt(7);
        Product product = new Product(id, name, category, brand, productType, sid, safetyStock);
        return product;
    }

    public ArrayList<Product> getAllProducts() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select p.id,p.name,c.name,b.name,pt.name,s.id, p.saftyStock from product p, category c, brand b, productType pt, supplier s where p.cid = c.id and p.bid = b.id and p.ptid = pt.id and p.sid = s.id";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Product> productList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String category = resultSet.getString(3);
            String brand = resultSet.getString(4);
            String productType = resultSet.getString(5);
            String supplier = resultSet.getString(6);
            int safetyStock = resultSet.getInt(7);
            Product product = new Product(id, name, category, brand, productType, supplier, safetyStock);
            productList.add(product);
        }
        return productList;
    }

    public int addProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into product values ('" + product.getId() + "','" + product.getName() + "','" + categoryController.getIdByName(product.getCid()) + "','" + brandController.getIdByName(product.getBid()) + "','" + productTypeController.getIdByName(product.getPtid()) + "','" + product.getSid() + "'," + product.getSaftyStock() + ")";
        int result = statement.executeUpdate(sql);
        return result;
    }

    public Product getProduct(String pid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from product where id = '" + pid + "'";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            Product product = new Product();
            product.setId(pid);
            product.setName(result.getString(2));
            product.setSaftyStock(result.getInt(7));
            return product;
        } else {
            return null;
        }
    }

    public boolean ifExist(String id) throws ClassNotFoundException, SQLException {
        return getProduct(id) != null;
    }

    public int changeSafetyStock(Product product) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "update product set saftyStock = " + product.getSaftyStock() + " where id = '" + product.getId() + "'";
        int result = statement.executeUpdate(sql);
        return result;
    }

    public int deleteProduct(String id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "delete from product where id = '" + id + "'";
        int result = statement.executeUpdate(sql);
        return result;
    }

    public int updateProduct(Product product) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "update product set name = '" + product.getName() + "', cid =  '" + categoryController.getIdByName(product.getCid()) + "', bid = '" + brandController.getIdByName(product.getBid()) + "', ptid = '" + productTypeController.getIdByName(product.getPtid()) + "', sid = '" + product.getSid() + "' where id = '" + product.getId() + "'";
        int result = statement.executeUpdate(sql);
        return result;
    }

    public String getNewId() throws ClassNotFoundException, SQLException {
        String lastId = getLastId();
        String substring = lastId.substring(3);
        int lastIdInt = Integer.parseInt(substring);
        return "PDT" + (lastIdInt + 1);
    }

    private String getLastId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from product order by id desc limit 1";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "PDT000";
        }
    }

    public String getIdByName(String name) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select id from product where name = '" + name + "'";
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getString(1);
        } else {
            return "";
        }
    }
}
