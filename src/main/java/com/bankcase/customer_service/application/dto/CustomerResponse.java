package com.bankcase.customer_service.application.dto;


import com.bankcase.customer_service.domain.model.Customer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CustomerResponse {

    private Long id;
    private String name;
    private String surname;
    private BigDecimal creditLimit;
    private BigDecimal usedCreditLimit;

    public static CustomerResponse from(Customer c) {
        return CustomerResponse.builder()
                .id(c.getId())
                .name(c.getName())
                .surname(c.getSurname())
                .creditLimit(c.getCreditLimit())
                .usedCreditLimit(c.getUsedCreditLimit())
                .build();
    }
}
