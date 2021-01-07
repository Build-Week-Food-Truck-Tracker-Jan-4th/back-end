package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trucks")
public class Truck extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long truckid;

    private String truckname;

    private String imageoftruck;

    private String cuisinetype;

    private long departuretime;

    private long latitude;

    private long longitude;

    @OneToMany(mappedBy = "truck", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "truck", allowSetters = true)
    private Set<TruckMenus> menus = new HashSet<>();

    public Truck()
    {
    }

    public Truck(
        String truckname,
        String imageoftruck,
        String cuisinetype,
        long departuretime,
        long latitude,
        long longitude)
    {
        this.truckname = truckname;
        this.imageoftruck = imageoftruck;
        this.cuisinetype = cuisinetype;
        this.departuretime = departuretime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getTruckid()
    {
        return truckid;
    }

    public void setTruckid(long truckid)
    {
        this.truckid = truckid;
    }

    public String getTruckname()
    {
        return truckname;
    }

    public void setTruckname(String truckname)
    {
        this.truckname = truckname;
    }

    public String getImageoftruck()
    {
        return imageoftruck;
    }

    public void setImageoftruck(String imageoftruck)
    {
        this.imageoftruck = imageoftruck;
    }

    public String getCuisinetype()
    {
        return cuisinetype;
    }

    public void setCuisinetype(String cuisinetype)
    {
        this.cuisinetype = cuisinetype;
    }

    public long getDeparturetime()
    {
        return departuretime;
    }

    public void setDeparturetime(long departuretime)
    {
        this.departuretime = departuretime;
    }

    public long getLatitude()
    {
        return latitude;
    }

    public void setLatitude(long latitude)
    {
        this.latitude = latitude;
    }

    public long getLongitude()
    {
        return longitude;
    }

    public void setLongitude(long longitude)
    {
        this.longitude = longitude;
    }

    public Set<TruckMenus> getMenus()
    {
        return menus;
    }

    public void setMenus(Set<TruckMenus> menus)
    {
        this.menus = menus;
    }
}
