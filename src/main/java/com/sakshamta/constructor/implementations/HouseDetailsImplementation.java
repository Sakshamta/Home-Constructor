package com.sakshamta.constructor.implementations;

import com.sakshamta.constructor.entities.HouseDetails;
import com.sakshamta.constructor.interfaces.HouseDetailsInterface;
import com.sakshamta.constructor.model.CostFilter;
import com.sakshamta.constructor.repositories.HouseDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HouseDetailsImplementation implements HouseDetailsInterface {
   @Autowired
   private HouseDetailsRepo houseDetailsRepo;

    @Override
    public HouseDetails save(HouseDetails houseDetails) {
        if(houseDetails.getIsSold()==null){
            houseDetails.setIsSold(false);
        }
        return houseDetailsRepo.save(houseDetails);
    }

    @Override
    public Map<String, String> delete(Long id) {
        Map<String, String> jsonMap = new HashMap<>();
        HouseDetails houseDetails = houseDetailsRepo.getOne(id);
        houseDetailsRepo.delete(houseDetails);
        jsonMap.put("response", "Deleted");
        return jsonMap;
    }

    @Override
    public List<HouseDetails> listAll() {
        return houseDetailsRepo.findAll();
    }

    @Override
    public HouseDetails listById(Long id) {
        Optional<HouseDetails> houseDetails = houseDetailsRepo.findById(id);
        return houseDetails.get();
    }

    @Override
    public HouseDetails edit(HouseDetails houseDetails, Long id) {
        HouseDetails existingDetails = houseDetailsRepo.findById(id).get();
        existingDetails.setHouseDescription(houseDetails.getHouseDescription());
        existingDetails.setOwnerName(houseDetails.getOwnerName());
        existingDetails.setLocation(houseDetails.getLocation());
        existingDetails.setNoOfFloor(houseDetails.getNoOfFloor());
        existingDetails.setLandArea(houseDetails.getLandArea());
        existingDetails.setEstimateCost(houseDetails.getEstimateCost());

        return houseDetailsRepo.save(existingDetails);
    }

    @Override
    public List<HouseDetails> findByLocation(String location) {
        return houseDetailsRepo.findByLocation(location);
    }

    @Override
    public List<HouseDetails> findByIsSold(String isSold) {
        boolean flag = Boolean.parseBoolean(isSold);
        return houseDetailsRepo.findByIsSold(flag);
    }

    @Override
    public List<HouseDetails> findByEstimateCostBetween(CostFilter costFilter) {
        System.out.println("costfilter "+costFilter);
        List<HouseDetails> houseDetails = new ArrayList<>();
            if(costFilter.getMaxEstimatedCost()==(long)0){
             System.out.println("max estimated cost----------------------"+houseDetailsRepo.findMaxEstimatedCost());
                costFilter.setMaxEstimatedCost(houseDetailsRepo.findMaxEstimatedCost());
            }
            houseDetails = houseDetailsRepo.findByEstimateCostBetween(costFilter.getMinEstimatedCost(),costFilter.getMaxEstimatedCost());
        System.out.println(costFilter.getMaxEstimatedCost());
        return houseDetails;
    }

    @Override
    public List<HouseDetails> findByLandAreaAndNoOfFloor(String landArea, String noOfFloor) {
        return houseDetailsRepo.findByLandAreaAndNoOfFloor(landArea, noOfFloor);
    }

    @Override
    public Long findMaxCost() {
        return houseDetailsRepo.findMaxEstimatedCost();
    }


}
