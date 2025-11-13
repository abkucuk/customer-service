package com.bankcase.customer_service.infra.controller;

import com.bankcase.customer_service.application.dto.CustomerRequest;
import com.bankcase.customer_service.application.dto.CustomerResponse;
import com.bankcase.customer_service.application.service.CustomerApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerApplicationService service;

    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable Long id) {
        return service.get(id);
    }
}
