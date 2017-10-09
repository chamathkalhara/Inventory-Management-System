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
public class GoodsReceived {
    private String poid;
    private String rDate;
    private String pid;
    private int qty;

    public GoodsReceived() {
    }

    public GoodsReceived(String poid, String rDate, String pid, int qty) {
        this.poid = poid;
        this.rDate = rDate;
        this.pid = pid;
        this.qty = qty;
    }

    public String getPoid() {
        return poid;
    }

    public void setPoid(String poid) {
        this.poid = poid;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    
}
