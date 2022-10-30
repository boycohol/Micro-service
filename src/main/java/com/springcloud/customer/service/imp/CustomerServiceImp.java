package com.springcloud.customer.service.imp;

import com.springcloud.customer.entity.CustomerEntity;
import com.springcloud.customer.repository.CustomerRepository;
import com.springcloud.customer.request.CustomerRequest;
import com.springcloud.customer.response.FraudResponse;
import com.springcloud.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void registerCustomer(CustomerRequest customerRequest) {
        CustomerEntity customer = new CustomerEntity();
        customer.setPassword(customerRequest.getPassword());
        customer.setLastName(customerRequest.getLastName());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setEmail(customerRequest.getEmail());
        CustomerEntity customerResponse = customerRepository.saveAndFlush(customer);
        FraudResponse fraudResponse = restTemplate.getForObject("http://localhost:8085/fraud/api/v1/fraud/{customerId}",
                FraudResponse.class, customerResponse.getId());
        if (fraudResponse.getIsFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
    }
}
