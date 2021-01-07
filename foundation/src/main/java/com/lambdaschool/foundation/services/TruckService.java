package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Truck;

import java.util.List;

public interface TruckService
{

    List<Truck> findAll();

    Truck findTruckById(long id);

    Truck save(Truck truck);

    void delete(long id);
}
