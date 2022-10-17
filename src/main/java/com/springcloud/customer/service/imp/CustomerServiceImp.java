package com.springcloud.customer.service.imp;

import com.springcloud.customer.entity.CustomerEntity;
import com.springcloud.customer.repository.CustomerRepository;
import com.springcloud.customer.request.CustomerRequest;
import com.springcloud.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp  implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerEntity registerCustomer(CustomerRequest customerRequest) {
        CustomerEntity customer=new CustomerEntity();
        customer.setPassword(customerRequest.getPassword());
        customer.setLastName(customerRequest.getLastName());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setEmail(customerRequest.getEmail());
        return customerRepository.saveAndFlush(customer);
    }
}
