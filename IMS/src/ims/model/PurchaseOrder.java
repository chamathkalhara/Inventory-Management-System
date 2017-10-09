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
public class PurchaseOrder {
    private String id;
    private String pid;
    private String sid;
    private String oDate;
    private int qty;
    private double unitPrice;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String id, String pid, String sid, String oDate, int qty, double unitPrice) {
        this.id = id;
        this.pid = pid;
        this.sid = sid;
        this.oDate = oDate;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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

    public String getoDate() {
        return oDate;
    }

    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
     
}
