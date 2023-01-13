package com.example.rent.Entity.Employee;

import com.example.rent.Entity.Base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Employee extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_EMPLOYEE", sequenceName = "SEQ_EMPLOYEE", allocationSize = 1)
    @GeneratedValue(generator = "GEN_EMPLOYEE", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAMESURNAME", nullable = false)
    private String nameSurname;

}
