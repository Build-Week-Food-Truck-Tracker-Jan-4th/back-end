package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.models.Truck;
import com.lambdaschool.foundation.services.TruckService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/trucks")
public class TruckController
{
    @Autowired
    private TruckService truckService;

    @GetMapping(value = "/trucks", produces = "application/json")
    public ResponseEntity<?> listAllTrucks()
    {
        List<Truck> myTrucks = truckService.findAll();
        return new ResponseEntity<>(myTrucks, HttpStatus.OK);
    }

    @GetMapping(value = "/truck/{truckid}", produces = "application/json")
    public ResponseEntity<?> getTruckById(@PathVariable Long truckid)
    {
        Truck t = truckService.findTruckById(truckid);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PostMapping(value = "/truck", consumes = "application/json")
    public ResponseEntity<?> addNewTruck(@Valid @RequestBody Truck newTruck) throws URISyntaxException
    {
        newTruck.setTruckid(0);
        newTruck = truckService.save(newTruck);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTruckURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{truckid}").buildAndExpand(newTruck.getTruckid()).toUri();
        responseHeaders.setLocation(newTruckURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/truck/{truckid}", consumes = "application/json")
    public ResponseEntity<?> updateFullTruck(@Valid @RequestBody Truck updateTruck, @PathVariable long truckid)
    {
        updateTruck.setTruckid(truckid);
        truckService.save(updateTruck);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/truck/{truckid}", consumes = "application/json")
    public ResponseEntity<?> deleteTruck(@PathVariable long truckid)
    {
        truckService.delete(truckid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
