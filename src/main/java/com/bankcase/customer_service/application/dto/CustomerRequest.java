package com.bankcase.customer_service.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerRequest {

    private String name;
    private String surname;
    private BigDecimal creditLimit;
}
