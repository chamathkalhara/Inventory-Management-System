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
public class Product {
    private String id;
    private String name;
    private String cid;
    private String bid;
    private String ptid;
    private int volume;
    private int saftyStock;

    public Product() {
    }

    public Product(String id, String name, String cid, String bid, String ptid, int volume, int saftyStock) {
        this.id = id;
        this.name = name;
        this.cid = cid;
        this.bid = bid;
        this.ptid = ptid;
        this.volume = volume;
        this.saftyStock = saftyStock;
    }

    public int getSaftyStock() {
        return saftyStock;
    }

    public void setSaftyStock(int saftyStock) {
        this.saftyStock = saftyStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    
}
