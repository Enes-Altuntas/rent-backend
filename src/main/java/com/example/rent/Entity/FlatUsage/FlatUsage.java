package com.example.rent.Entity.FlatUsage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FLAT_USAGE_TYPE")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class FlatUsage {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_FLAT_USAGE_TYPE", sequenceName = "SEQ_FLAT_USAGE_TYPE", allocationSize = 1)
    @GeneratedValue(generator = "GEN_FLAT_USAGE_TYPE", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "USAGE_VALUE",nullable = false)
    private String usageValue;
}
