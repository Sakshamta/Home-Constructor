package com.sakshamta.constructor.controllers;


import com.sakshamta.constructor.entities.HouseDetails;
import com.sakshamta.constructor.interfaces.HouseDetailsInterface;
import com.sakshamta.constructor.model.CostFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/house")
public class HouseDetailsController {
    @Autowired
    private HouseDetailsInterface service;

    @PostMapping
    public HouseDetails post(@RequestBody  HouseDetails houseDetails){

        return service.save(houseDetails);
    }

    @GetMapping
    public List<HouseDetails> get(){
        return service.listAll();
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Map<String, String> delete(@PathVariable("id") Long id){

        return service.delete(id);
    }

    @GetMapping("/{id}")
    public  HouseDetails getOneById(@PathVariable("id") Long id){
        return  service.listById(id);
    }

    @GetMapping ("/max")
    public Long getMaxCost(){
        return  service.findMaxCost();
    }

    @PutMapping("/{id}")
    public HouseDetails put(@RequestBody HouseDetails houseDetails, @PathVariable("id") Long id){
        return service.edit(houseDetails, id);
    }

    //*****getting list with the location name****
    @PostMapping("/{location}")
    public List<HouseDetails>  getByLocation(@PathVariable("location") String location){

        return  service.findByLocation(location);

    }

    //*****getting list which is either sold or in sale****
    @PostMapping("/sold/{isSold}")
    public List<HouseDetails>  getBySold(@PathVariable("isSold") String isSold){
        return  service.findByIsSold(isSold);
    }

    @PostMapping("/costfilter")
    public  List<HouseDetails> findByEstimateCostBetween(@RequestBody CostFilter costFilter){
        return service.findByEstimateCostBetween(costFilter);
    }

    @PostMapping("/area/{landArea}/floor/{noOfFloor}")
    public List<HouseDetails> findByLandAreaAndNoOfFloor(@PathVariable("landArea") String landArea, @PathVariable("noOfFloor") String noOfFloor){
        return service.findByLandAreaAndNoOfFloor(landArea, noOfFloor);
    }
}
