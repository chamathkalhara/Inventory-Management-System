/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.model;

/**
 *
 * @author Chamath
 */
public class StockProduct {
    private String id;
    private String pid;
    private String sid;
    private double unitPrice;
    private String expDate;
    private String recievedDate;
    private int qtyOrdered;
    private int qtyRecieved;

    public StockProduct() {
    }

    public StockProduct(String id, String pid, String sid, double unitPrice, String expDate, String recievedDate, int qtyOrdered, int qtyRecieved) {
        this.id = id;
        this.pid = pid;
        this.sid = sid;
        this.unitPrice = unitPrice;
        this.expDate = expDate;
        this.recievedDate = recievedDate;
        this.qtyOrdered = qtyOrdered;
        this.qtyRecieved = qtyRecieved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getRecievedDate() {
        return recievedDate;
    }

    public void setRecievedDate(String recievedDate) {
        this.recievedDate = recievedDate;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public int getQtyRecieved() {
        return qtyRecieved;
    }

    public void setQtyRecieved(int qtyRecieved) {
        this.qtyRecieved = qtyRecieved;
    }

}
