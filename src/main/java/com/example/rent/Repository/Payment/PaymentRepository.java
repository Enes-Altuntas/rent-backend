package com.example.rent.Repository.Payment;

import com.example.rent.Entity.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
