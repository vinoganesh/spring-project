package com.cust.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.entities.Customer;
import com.cust.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer oldCustomer = customerRepository.getById(id);
        oldCustomer.setFirstName(customer.getFirstName());
        oldCustomer.setLastName(customer.getLastName());
        oldCustomer.setLocation(customer.getLocation());
        oldCustomer.setEmail(customer.getEmail());
        return customerRepository.save(oldCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.getById(id);
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> getCustomerbyEmail(String email) {
        return customerRepository.findByEmail(email);
    }
    
}
