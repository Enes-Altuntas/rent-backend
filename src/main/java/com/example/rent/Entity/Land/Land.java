package com.example.rent.Entity.Land;

import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.Owner.Owner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LANDS")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Land extends BaseEntity {

    @Id
    @SequenceGenerator(name = "GEN_LAND", sequenceName = "SEQ_LAND", allocationSize = 1)
    @GeneratedValue(generator = "GEN_LAND", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "PROVINCE", nullable = false)
    private String province;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "NEIGHBOURHOOD", nullable = false)
    private String neighbourhood;

    @Column(name = "ADA_NO", nullable = false)
    private Integer adaNo;

    @Column(name = "PARSEL_NO", nullable = false)
    private Integer parselNo;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @ManyToMany
    @JoinTable(name = "LANDS_OWNERS", joinColumns = @JoinColumn(name = "land_id"), inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private List<Owner> owners;

}
