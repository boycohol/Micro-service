package com.springcloud.customer.service;

import com.springcloud.customer.entity.CustomerEntity;
import com.springcloud.customer.request.CustomerRequest;

public interface CustomerService {
    public void registerCustomer(CustomerRequest customerRequest);
}
