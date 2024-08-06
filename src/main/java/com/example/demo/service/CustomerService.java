package com.example.demo.service;



import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    public Customer findById(Long id) {
        return customerDAO.findById(id);
    }

    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    public void deleteById(Long id) {
        customerDAO.deleteById(id);
    }
}
