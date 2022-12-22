package com.example.rent.Repository.Currency;

import com.example.rent.Entity.Currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
