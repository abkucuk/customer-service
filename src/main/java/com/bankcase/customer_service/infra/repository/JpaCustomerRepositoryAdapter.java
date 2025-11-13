package com.bankcase.customer_service.infra.repository;

import com.bankcase.customer_service.domain.model.Customer;
import com.bankcase.customer_service.infra.entity.CustomerEntity;
import com.bankcase.customer_service.domain.repository.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerRepositoryPort {

    private final SpringJpaRepository jpaRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerEntity.fromDomain(customer);
        return jpaRepository.save(entity).toDomain();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id).map(CustomerEntity::toDomain);
    }
}
