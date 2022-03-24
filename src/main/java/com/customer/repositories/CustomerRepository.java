package com.cust.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cust.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    @Query(value = "select c from Customer c where c.email = ?1")
    public List<Customer> findByEmail(String email);
}
