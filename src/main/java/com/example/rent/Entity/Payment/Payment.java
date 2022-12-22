package com.example.rent.Entity.Payment;

import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.File.File;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Renter.Renter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAYMENTS")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Payment extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_PAYMENT", sequenceName = "SEQ_PAYMENT", allocationSize = 1)
    @GeneratedValue(generator = "GEN_PAYMENT", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate = Date.from(java.time.Instant.now());

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLAT_ID")
    private Flat flat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RENTER_ID")
    private Renter renter;

    //TODO resmi ve gayriresmi enum

}
