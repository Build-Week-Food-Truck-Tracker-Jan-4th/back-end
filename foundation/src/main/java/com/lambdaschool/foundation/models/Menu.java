package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menus")
public class Menu extends Auditable implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuid;

    private String itemname;

    private String itemdescription;

    private double itemprice;

    private int customerratings;

    private int customerratingsavg;

    @ManyToOne
    @JoinColumn(name = "truckid")
    @JsonIgnoreProperties(value = "menus", allowSetters = true)
    private Truck truck;

    public Menu()
    {
    }

    public Menu(
        String itemname,
        String itemdescription,
        double itemprice,
        int customerratings,
        int customerratingsavg)
    {
        this.itemname = itemname;
        this.itemdescription = itemdescription;
        this.itemprice = itemprice;
        this.customerratings = customerratings;
        this.customerratingsavg = customerratingsavg;
    }

    public long getMenuid()
    {
        return menuid;
    }

    public void setMenuid(long menuid)
    {
        this.menuid = menuid;
    }

    public String getItemname()
    {
        return itemname;
    }

    public void setItemname(String itemname)
    {
        this.itemname = itemname;
    }

    public String getItemdescription()
    {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription)
    {
        this.itemdescription = itemdescription;
    }

    public double getItemprice()
    {
        return itemprice;
    }

    public void setItemprice(double itemprice)
    {
        this.itemprice = itemprice;
    }

    public int getCustomerratings()
    {
        return customerratings;
    }

    public void setCustomerratings(int customerratings)
    {
        this.customerratings = customerratings;
    }

    public int getCustomerratingsavg()
    {
        return customerratingsavg;
    }

    public void setCustomerratingsavg(int customerratingsavg)
    {
        this.customerratingsavg = customerratingsavg;
    }

    public Truck getTruck()
    {
        return truck;
    }

    public void setTruck(Truck truck)
    {
        this.truck = truck;
    }
}
