package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            entityManager.persist(customer);
        } else {
            customer = entityManager.merge(customer);
        }
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
