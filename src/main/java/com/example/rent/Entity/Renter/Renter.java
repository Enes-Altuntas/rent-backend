package com.example.rent.Entity.Renter;

import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Payment.Payment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RENTERS")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Renter extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_RENTER", sequenceName = "SEQ_RENTER", allocationSize = 1)
    @GeneratedValue(generator = "GEN_RENTER", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "RENTER_CODE")
    private String code;

    @Column(name = "TC_NO", nullable = false, unique = true)
    private String tckn;

    @Column(name = "NAME", nullable = false)
    private String nameSurname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "ACTIVE", nullable = false)
    private boolean isActive = true;

    @OneToMany(mappedBy = "renter")
    private List<Flat> flatList;

    @OneToMany(mappedBy = "renter")
    private List<Payment> payments;

}
