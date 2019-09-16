package com.oliveira.raimundo.repositories;

import java.util.Optional;

import com.oliveira.raimundo.model.Customer;
import com.oliveira.raimundo.model.CustomerOpenOut;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOpenOutRepository extends JpaRepository<CustomerOpenOut, Long> {

  Optional<Customer> findCustomerById(Long id);

  Optional<CustomerOpenOut> findByCustomerId(Long customerId);

  CustomerOpenOut saveAll(CustomerOpenOut obj);

  Optional<CustomerOpenOut> findAllById(Long id);

}
