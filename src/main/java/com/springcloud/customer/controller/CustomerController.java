package com.springcloud.customer.controller;

import com.springcloud.customer.request.CustomerRequest;
import com.springcloud.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register")
    public void registerCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
