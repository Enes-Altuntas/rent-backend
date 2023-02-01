package com.example.rent.Repository.Renter;

import com.example.rent.Entity.Renter.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RenterRepository extends JpaRepository<Renter, Integer> {
    List<Renter> findAllByActiveIsTrue();

    Optional<Renter> findByTckn(String tckn);
}
