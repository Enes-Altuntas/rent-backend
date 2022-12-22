package com.example.rent.Repository.Apartment;

import com.example.rent.Entity.Apartment.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
}
