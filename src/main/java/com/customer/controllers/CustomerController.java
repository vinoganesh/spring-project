package com.cust.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cust.entities.Customer;
import com.cust.services.CustomerService;
import com.cust.services.ValidationService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ValidationService validationService;
    
    @PostMapping("add")
    @ApiOperation("Add Customer")
    public ResponseEntity<?> add(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
        ResponseEntity<Map<String, String>> responseEntity = validationService.validate(bindingResult);
        if(bindingResult.hasErrors())
            return responseEntity;
        Customer c = customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
    }
    
    @GetMapping("get/{id}")
    @ApiOperation("Get Customer by Id")
    public Customer get(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
    
    @GetMapping("getall")
    @ApiOperation("Get All Customer")
    public List<Customer> getAll() {
        return customerService.allCustomer();
    }
    
    @PutMapping("update/{id}")
    @ApiOperation("Update Customer by Id")
    public Customer update(@PathVariable Long id,@RequestBody @Valid Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
    
    @DeleteMapping("delete/{id}")
    @ApiOperation("Delete Customer by Id")
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
    
    @GetMapping("getbyemail/{email}")
    @ApiOperation("Get Customer by Email")
    public List<Customer> getEmail(@PathVariable String email) {
        return customerService.getCustomerbyEmail(email);
    }
}
