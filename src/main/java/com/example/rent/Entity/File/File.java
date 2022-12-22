package com.example.rent.Entity.File;

import com.example.rent.Entity.Payment.Payment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FILES")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class File {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_FILE", sequenceName = "SEQ_FILE", allocationSize = 1)
    @GeneratedValue(generator = "GEN_FILE", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    @OneToOne(mappedBy = "file")
    private Payment payment;

}
