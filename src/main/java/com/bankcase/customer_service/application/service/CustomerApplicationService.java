package com.bankcase.customer_service.application.service;

import com.bankcase.customer_service.application.dto.CustomerRequest;
import com.bankcase.customer_service.application.dto.CustomerResponse;
import com.bankcase.customer_service.domain.model.Customer;
import com.bankcase.customer_service.domain.repository.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustomerApplicationService {

    private final CustomerRepositoryPort repository;

    public CustomerResponse create(CustomerRequest request) {
        Customer customer = Customer.create(
                request.getName(),
                request.getSurname(),
                request.getCreditLimit()
        );

        Customer saved = repository.save(customer);

        return CustomerResponse.from(saved);
    }

    public CustomerResponse get(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return CustomerResponse.from(customer);
    }

    public BigDecimal availableCredit(Long customerId) {
        Customer customer = repository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        return customer.usableCreditLimit();
    }

    public Boolean hasEnoughLimit(Long customerId, BigDecimal amount) {
        Customer customer = repository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        return customer.hasEnoughLimit(amount);
    }
}
