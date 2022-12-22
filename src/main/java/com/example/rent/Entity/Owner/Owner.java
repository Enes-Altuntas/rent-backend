package com.example.rent.Entity.Owner;

import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.Land.Land;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OWNERS")
@Getter
@Setter
@RequiredArgsConstructor
public class Owner extends BaseEntity {

    @Id
    @SequenceGenerator(name = "GEN_OWNER", sequenceName = "SEQ_OWNER", allocationSize = 1)
    @GeneratedValue(generator = "GEN_OWNER", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String nameSurname;

    @Column(name = "TCKN", nullable = false, unique = true)
    private String tckn;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @ManyToMany(mappedBy = "owners")
    private List<Land> landList;

}
