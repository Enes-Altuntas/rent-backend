package com.example.rent.Entity.Currency;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCIES")
@Getter
@Setter
@RequiredArgsConstructor
public class Currency {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_CURRENCY", sequenceName = "SEQ_CURRENCY", allocationSize = 1)
    @GeneratedValue(generator = "GEN_CURRENCY", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "CURRENCY_VALUE", nullable = false)
    private String currencyValue;

}
