package com.sincro.practice.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement(name = "record")
public class Report {
    private int id;
    private long sales;
    private int quantity;
    private String staffName;
    private Date date;


    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "sales")
    public long getSales() {
        return sales;
    }
    public void setSales(long sales) {
        this.sales = sales;
    }

    @XmlElement(name = "quantity")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement(name = "staffName")
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @XmlElement(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "Report = [id="+this.id+", sales="+this.sales+", quantity="+this.quantity+", staff name="+this.staffName+"]";
    }
}
