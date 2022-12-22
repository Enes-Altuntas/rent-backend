package com.example.rent.Entity.Flat;

import com.example.rent.Entity.Apartment.Apartment;
import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.Currency.Currency;
import com.example.rent.Entity.FlatContract.FlatContract;
import com.example.rent.Entity.FlatType.FlatType;
import com.example.rent.Entity.Renter.Renter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FLATS")
@Getter
@Setter
@RequiredArgsConstructor
public class Flat extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_FLAT", sequenceName = "SEQ_FLAT", allocationSize = 1)
    @GeneratedValue(generator = "GEN_FLAT", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FLAT_NUMBER", nullable = false)
    private Integer flatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLATTYPE_ID")
    private FlatType flatType;

    @Column(name = "FLAT_PRICE", nullable = false)
    private Integer flatPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @Column(name = "FLAT_AREA", nullable = false)
    private String flatArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APARTMENT_ID")
    private Apartment apartment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FLAT_CONTRACT_ID")
    private FlatContract flatContract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RENTER_ID")
    private Renter renter;

}
