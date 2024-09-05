package org.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.task.dto.CustomerCreateDTO;
import org.test.task.entity.Customer;
import org.test.task.enums.MarketType;
import org.test.task.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(CustomerCreateDTO dto) {
        Customer customer = new Customer(dto.getName());
        customer.setMarketType(MarketType.KORZINKA);
        customerRepository.save(customer);
        return customer;
    }

    public Customer update(Long id, CustomerCreateDTO dto) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setName(dto.getName());
        customer.setMarketType(MarketType.KORZINKA);
        customerRepository.save(customer);
        return customer;
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);

    }

    public Customer get(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
