package com.sakshamta.constructor.repositories;

import com.sakshamta.constructor.entities.HouseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface HouseDetailsRepo extends JpaRepository<HouseDetails, Long>
{
    public  List<HouseDetails> findByLocation(String location);

    public List<HouseDetails>  findByIsSold(Boolean isSold);

    public List<HouseDetails> findByEstimateCostBetween(Long minEstimatedCost, Long maxEstimatedCost);


   @Query(nativeQuery = true, value = "select MAX(estimated_cost) from tbl_housedetails")
   public Long findMaxEstimatedCost(); //give the maximum cost


   public List<HouseDetails> findByLandAreaAndNoOfFloor (String landArea , String noOfFloor);
}
