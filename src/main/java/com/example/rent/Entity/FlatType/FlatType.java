package com.example.rent.Entity.FlatType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FLAT_TYPES")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class FlatType {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_FLATTYPE", sequenceName = "SEQ_FLATTYPE", allocationSize = 1)
    @GeneratedValue(generator = "GEN_FLATTYPE", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FLAT_TYPE_VALUE", nullable = false)
    private String flatTypeValue;

}
