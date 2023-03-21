package org.jspiders.customerapi.controller;

import org.jspiders.customerapi.model.Customer;
import org.jspiders.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customers")
    public void insertCustomer(@RequestBody Customer c){
        service.insertCustomer(c);
    }

    //get all customer
    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/byid")
    public Customer getCustomerById(@RequestParam int id){
        return service.getCustomerById(id);
    }

    @GetMapping("/byname")
    public List<Customer> getCustomerByName(@RequestParam String name){
        return service.getCustomerByName(name);
    }

    @GetMapping("/byemail")
    public Customer getCustomerByEmail(@RequestParam String email){
        return service.getCustomerByCustomerEmail(email);
    }

    @GetMapping("/byage")
    public List<Customer> getCustomerByAgeGreaterThan(@RequestParam int age){
        return service.getCustomerByCustomerAgeGreaterThan(age);
    }

    @GetMapping("/bypurchase")
    public List<Customer> getCustomerByTotalPurchase(@RequestParam double amt){
        return service.getCustomerByTotalPurchaseLessThan(amt);
    }

    @GetMapping("/name")
    List<Customer> viewCustomer(@RequestParam String name){
        return service.viewCustomer(name);
    }

    @GetMapping("/age")
    List<Customer> ageFilter(@RequestParam int age, @RequestParam double amt){
        return service.ageFilter(age, amt);
    }

    @GetMapping("/namefilter")
    List<String> nameFilter(@RequestParam String ch){
        return service.nameFilter(ch);
    }

    @GetMapping("/namefilter2")
    List<String> nameFilter2(@RequestParam String name){
        return service.nameFilter(name);
    }
}
