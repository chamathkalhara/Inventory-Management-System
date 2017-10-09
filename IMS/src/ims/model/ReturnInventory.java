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
public class ReturnInventory {
    private String id;
    private String pid;
    private int qtyReturn;
    private double unitPrice;
    private String rDate;

    public ReturnInventory() {
    }

    public ReturnInventory(String id, String pid, int qtyReturn, double unitPrice, String rDate) {
        this.id = id;
        this.pid = pid;
        this.qtyReturn = qtyReturn;
        this.unitPrice = unitPrice;
        this.rDate = rDate;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
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

    public int getQtyReturn() {
        return qtyReturn;
    }

    public void setQtyReturn(int qtyReturn) {
        this.qtyReturn = qtyReturn;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
}
