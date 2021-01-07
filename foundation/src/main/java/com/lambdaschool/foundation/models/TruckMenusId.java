package com.lambdaschool.foundation.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TruckMenusId implements Serializable
{
    private long truck;

    private long menu;

    public TruckMenusId()
    {
    }

    public long getTruck()
    {
        return truck;
    }

    public void setTruck(long truck)
    {
        this.truck = truck;
    }

    public long getMenu()
    {
        return menu;
    }

    public void setMenu(long menu)
    {
        this.menu = menu;
    }
}
