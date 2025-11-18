package com.bankcase.customer_service.domain.model;

import java.math.BigDecimal;

public class Customer {

    private Long id;
    private String name;
    private String surname;
    private BigDecimal creditLimit;
    private BigDecimal usedCreditLimit;

    public Customer(Long id, String name, String surname,
                    BigDecimal creditLimit, BigDecimal usedCreditLimit) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.creditLimit = creditLimit;
        this.usedCreditLimit = usedCreditLimit;
    }

    public Boolean hasEnoughLimit(BigDecimal amount) {
        return usedCreditLimit.add(amount).compareTo(creditLimit) <= 0;
    }

    public BigDecimal usableCreditLimit() {
        return creditLimit.subtract(usedCreditLimit);
    }

    public void increaseUsedLimit(BigDecimal amount) {
        if (usedCreditLimit.add(amount).compareTo(creditLimit) > 0) {
            throw new IllegalArgumentException("Credit limit exceeded");
        }
        usedCreditLimit = usedCreditLimit.add(amount);
    }

    public void decreaseUsedLimit(BigDecimal amount) {
        usedCreditLimit = usedCreditLimit.subtract(amount);
        if (usedCreditLimit.compareTo(BigDecimal.ZERO) < 0) {
            usedCreditLimit = BigDecimal.ZERO;
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal getUsedCreditLimit() {
        return usedCreditLimit;
    }

    public static Customer create(String name, String surname, BigDecimal creditLimit) {
        return new Customer(
                null,
                name,
                surname,
                creditLimit,
                BigDecimal.ZERO
        );
    }
}
