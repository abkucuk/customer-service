package com.bankcase.customer_service.infra.entity;

import com.bankcase.customer_service.domain.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(precision = 19, scale = 2)
    private BigDecimal creditLimit;

    @Column(precision = 19, scale = 2)
    private BigDecimal usedCreditLimit;

    public static CustomerEntity fromDomain(Customer c) {
        return new CustomerEntity(
                c.getId(),
                c.getName(),
                c.getSurname(),
                c.getCreditLimit(),
                c.getUsedCreditLimit()
        );
    }

    public Customer toDomain() {
        return new Customer(id, name, surname, creditLimit, usedCreditLimit);
    }
}
