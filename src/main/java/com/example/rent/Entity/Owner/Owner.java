package com.example.rent.Entity.Owner;

import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Land.Land;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OWNERS")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Owner extends BaseEntity {

    @Id
    @SequenceGenerator(name = "GEN_OWNER", sequenceName = "SEQ_OWNER", allocationSize = 1)
    @GeneratedValue(generator = "GEN_OWNER", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "NAMESURNAME", nullable = false)
    private String nameSurname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TC_NO", nullable = false, unique = true)
    private String tckn;

    @Column(name = "BANK", nullable = false)
    private String bankName;

    @Column(name = "BRANCH", nullable = false)
    private String bankBranch;

    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private Integer accountNumber;

    @Column(name = "IBAN", nullable = false, unique = true, length = 26)
    private String iban;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @ManyToMany(mappedBy = "flatOwners")
    private List<Flat> flatList;

    @ManyToMany(mappedBy = "owners")
    private List<Land> landList;

}
