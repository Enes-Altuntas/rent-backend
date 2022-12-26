package com.example.rent.Entity.FlatContact;

import com.example.rent.Entity.Base.BaseEntity;
import com.example.rent.Entity.Flat.Flat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FLAT_CONTACTS")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class FlatContact extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_FLAT_CONTACT", sequenceName = "SEQ_FLAT_CONTACT", allocationSize = 1)
    @GeneratedValue(generator = "GEN_FLAT_CONTACT", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAMESURNAME", nullable = false)
    private String contactNameSurname;

    @Column(name = "EMAIL")
    private String contactEmail;

    @Column(name = "TC_NO", nullable = false, unique = true)
    private String contactTckn;

    @Column(name = "BANK", nullable = false)
    private String contactBankName;

    @Column(name = "BRANCH", nullable = false)
    private String contactBankBranch;

    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private Integer contactAccountNumber;

    @Column(name = "IBAN", nullable = false, unique = true, length = 26)
    private String contactIban;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String contactPhoneNumber;

    @Column(name = "ADDRESS", nullable = false)
    private String contactAddress;

    @OneToOne(mappedBy = "flatContact")
    private Flat flat;
}
