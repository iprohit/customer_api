package org.jspiders.customerapi.service;

import org.jspiders.customerapi.model.Customer;
import org.jspiders.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;




    public void insertCustomer(Customer c) {
        repository.save(c);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList=repository.findAll();
        return customerList;
    }

    //get customer by id
    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);
    }


    //get customer by name
    public List<Customer> getCustomerByName(String name){
        return repository.findByCustomerName(name);
    }

    //get customer by email
    public Customer getCustomerByCustomerEmail(String email) {
        return repository.findByCustomerEmail(email);
    }

    //get customer having age greater than ?(user value)
    public List<Customer> getCustomerByCustomerAgeGreaterThan(int age) {
        return repository.getCustomerByCustomerAgeGreaterThan(age);
    }

    public List<Customer> getCustomerByTotalPurchaseLessThan(double amt) {
        return repository.getCustomerByTotalPurchaseLessThan(amt);
    }

    public List<Customer> viewCustomer(String name) {
        return repository.viewCustomer(name);
    }

    public List<Customer> ageFilter(int age, double amt) {
        return repository.ageFilter(age, amt);
    }

    public List<String> nameFilter(String name) {
        return repository.nameFilter(name);
    }
}
