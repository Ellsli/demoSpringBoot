package com.example.demo.dao;

import com.example.demo.model.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();
    Customer findById(Long id);
    Customer save(Customer customer);
    void deleteById(Long id);
}
