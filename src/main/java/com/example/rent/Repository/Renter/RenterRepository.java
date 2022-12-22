package com.example.rent.Repository.Renter;

import com.example.rent.Entity.Renter.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RenterRepository extends JpaRepository<Renter, Integer> {
    List<Renter> findAllByIsActiveIsTrue();
}
