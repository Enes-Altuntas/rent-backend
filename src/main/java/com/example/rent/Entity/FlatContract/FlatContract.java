package com.example.rent.Entity.FlatContract;

import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Payment.Payment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FLAT_CONTRACTS")
@Getter
@Setter
@RequiredArgsConstructor
public class FlatContract {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_FLAT_CONTRACT", sequenceName = "SEQ_FLAT_CONTRACT", allocationSize = 1)
    @GeneratedValue(generator = "GEN_FLAT_CONTRACT", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @Column(name = "PAYMENT_DUE", nullable = false)
    private Integer paymentDue;

    @OneToMany(mappedBy = "flat")
    private List<Payment> payment;

    @OneToOne(mappedBy = "flatContract")
    private Flat flat;

}
