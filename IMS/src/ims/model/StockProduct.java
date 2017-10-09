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
    private double unitPrice;
    private String expDate;
    private int qtyAvailable;

    public StockProduct() {
    }

    public StockProduct(String id, String pid, double unitPrice, String expDate, int qtyAvailable) {
        this.id = id;
        this.pid = pid;
        this.unitPrice = unitPrice;
        this.expDate = expDate;
        this.qtyAvailable = qtyAvailable;
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

    public int getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(int qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    
}
