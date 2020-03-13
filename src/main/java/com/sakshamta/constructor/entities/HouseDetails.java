package com.sakshamta.constructor.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "TBL_HOUSEDETAILS")
public class HouseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_description")
    private  String houseDescription;

    @Column(name = "owner_name")
    private  String ownerName;

    @Column(name = "location")
    private  String location;

    @Column(name = "no_of_floor")
    private  String noOfFloor;

    @Column(name = "land_area")
    private  String landArea;

    @Column(name = "estimated_cost")
    private  Long estimateCost;

    @Column(name = "is_sold")
    private  Boolean isSold;

}
