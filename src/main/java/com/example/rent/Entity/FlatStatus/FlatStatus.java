package com.example.rent.Entity.FlatStatus;

import com.example.rent.Entity.Base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FLAT_STATUSES")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class FlatStatus extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_FLAT_STATUS", sequenceName = "SEQ_FLAT_STATUS", allocationSize = 1)
    @GeneratedValue(generator = "GEN_FLAT_STATUS", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FLAT_STATUS_VALUE", nullable = false)
    private String flatStatusValue;

}
