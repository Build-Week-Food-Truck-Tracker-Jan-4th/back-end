package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Truck;
import org.springframework.data.repository.CrudRepository;

public interface TruckRepository extends CrudRepository<Truck, Long>
{
}
