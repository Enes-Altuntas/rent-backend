package com.example.rent.Repository.Flat;

import com.example.rent.Entity.Flat.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Integer> {
}
