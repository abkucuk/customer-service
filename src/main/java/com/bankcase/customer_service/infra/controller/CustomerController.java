package com.bankcase.customer_service.infra.controller;

import com.bankcase.customer_service.application.dto.CustomerRequest;
import com.bankcase.customer_service.application.dto.CustomerResponse;
import com.bankcase.customer_service.application.service.CustomerApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerApplicationService service;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.get(customerId));
    }

    @GetMapping("/{customerId}/has-enough-limit")
    public ResponseEntity<Boolean> hasEnoughLimit(@PathVariable Long customerId, @RequestParam BigDecimal amount){
        return ResponseEntity.ok(service.hasEnoughLimit(customerId, amount));
    }

    @GetMapping("/{customerId}/available-credit")
    public ResponseEntity<BigDecimal> check(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.availableCredit(customerId));
    }
}
