package com.bankcase.customer_service.domain.repository;

import com.bankcase.customer_service.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
}
