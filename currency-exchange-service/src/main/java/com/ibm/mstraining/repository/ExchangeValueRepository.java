package com.ibm.mstraining.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.mstraining.beans.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
	Optional<ExchangeValue> findByCountryCode(String countryCode);
}
