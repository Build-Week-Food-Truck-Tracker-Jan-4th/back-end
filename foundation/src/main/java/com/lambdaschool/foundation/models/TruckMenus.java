package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "truckmenus")
@IdClass(TruckMenusId.class)
public class TruckMenus extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "truckid")
    @JsonIgnoreProperties(value = "menus", allowSetters = true)
    private Truck truck;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "menuid")
    @JsonIgnoreProperties(value = "trucks", allowSetters = true)
    private Menu menu;

    public TruckMenus()
    {
    }

    public TruckMenus(
        Truck truck,
        Menu menu)
    {
        this.truck = truck;
        this.menu = menu;
    }

    public Truck getTruck()
    {
        return truck;
    }

    public void setTruck(Truck truck)
    {
        this.truck = truck;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }
}
