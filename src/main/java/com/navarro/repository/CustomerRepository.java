package com.navarro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navarro.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long> {

	@Transactional(readOnly = true)
	Page<Customer> findAll(Pageable pageRequest);

	@Transactional(readOnly = true)
	Page<Customer> findByCountryAndState(@Param("country") String countryCode, @Param("state") Boolean state,
			Pageable pageRequest);

	@Transactional(readOnly = true)
	Page<Customer> findByCountry(@Param("country") String countryCode, Pageable pageRequest);

	@Transactional(readOnly = true)
	Page<Customer> findByState(@Param("state") Boolean state, Pageable pageRequest);

}
