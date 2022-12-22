package com.example.rent.Entity.Apartment;

import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.Flat.Flat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APARTMENTS")
@Getter
@Setter
@RequiredArgsConstructor
public class Apartment extends BaseEntity {
    //Deneme
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_APARTMENT", sequenceName = "SEQ_APARTMENT", allocationSize = 1)
    @GeneratedValue(generator = "GEN_APARTMENT", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "APARTMENT_NAME", nullable = false)
    private String apartmentName;

    @Column(name = "APARTMENT_NUMBER", nullable = false)
    private Integer number;

    @Column(name = "STREET_NAME", nullable = false)
    private String streetName;

    @Column(name = "NEIGHBORHOOD", nullable = false)
    private String neighborhood;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE", nullable = false)
    private String state;

    @OneToMany(mappedBy = "apartment", orphanRemoval = true)
    private List<Flat> flatList;
}
