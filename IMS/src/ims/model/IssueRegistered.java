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
public class IssueRegistered {
    
    private String id;
    private String cid;
    private String pid;
    private String orderDate;
    private int qty;
    private String expDate;

    public IssueRegistered() {
    }

    public IssueRegistered(String id, String cid, String pid, String orderDate, int qty, String expDate) {
        this.id = id;
        this.cid = cid;
        this.pid = pid;
        this.orderDate = orderDate;
        this.qty = qty;
        this.expDate = expDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    
}

