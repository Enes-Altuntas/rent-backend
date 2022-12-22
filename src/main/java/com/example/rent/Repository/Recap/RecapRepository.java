package com.example.rent.Repository.Recap;

import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Renter.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecapRepository extends JpaRepository<Renter, Integer> {
}
