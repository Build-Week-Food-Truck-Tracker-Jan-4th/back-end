package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Truck;
import com.lambdaschool.foundation.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "truckService")
public class TruckServiceImpl implements TruckService
{
    @Autowired
    private TruckRepository truckrepos;

    @Override
    public List<Truck> findAll()
    {
        List<Truck> list = new ArrayList<>();
        truckrepos.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    public Truck findTruckById(long id) throws ResourceNotFoundException
    {
        return truckrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Truck id " + id + " not found!"));
    }

    @Transactional
    @Override
    public Truck save(Truck truck)
    {
        Truck newTruck = new Truck();

        if (truck.getTruckid() != 0)
        {
            newTruck = truckrepos.findById(truck.getTruckid()).orElseThrow(() -> new ResourceNotFoundException("Truck id " + truck.getTruckid() + " not found!"));
        }

        newTruck.setTruckname(truck.getTruckname());
        newTruck.setCuisinetype(truck.getCuisinetype());
        newTruck.setDeparturetime(truck.getDeparturetime());
        newTruck.setImageoftruck(truck.getImageoftruck());

        return truckrepos.save(newTruck);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        truckrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Truck id " + id + " not found!"));
        truckrepos.deleteById(id);
    }
}
