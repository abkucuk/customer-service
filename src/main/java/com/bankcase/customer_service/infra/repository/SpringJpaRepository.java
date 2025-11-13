package com.bankcase.customer_service.infra.repository;

import com.bankcase.customer_service.infra.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
