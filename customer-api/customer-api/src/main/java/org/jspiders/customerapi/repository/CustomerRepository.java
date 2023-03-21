package org.jspiders.customerapi.repository;

import org.jspiders.customerapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //return the list of all customers having specific name
    List<Customer> findByCustomerName(String name);

    //return the customer details based on email id
    Customer findByCustomerEmail(String email);

    List<Customer> getCustomerByCustomerAgeGreaterThan(int age);

    List<Customer> getCustomerByTotalPurchaseLessThan(double amt);

    //returns the list of customer having name=? and age=?



    @Query("select c from Customer c where c.customerName=:name")
    List<Customer> viewCustomer(@Param("name") String name);

    @Query("select c from Customer c where c.customerAge<:age and c.totalPurchase>=:amt")
    List<Customer> ageFilter(@Param("age") int age, @Param("amt") double amt);

    //write JPQL to fetch customer names whose name contains given characters
    @Query("select c.customerName from Customer c where c.customerName like %:ch%")
    List<String> nameFilter(@Param("ch") String name);

    @Query("select c.customerName from Customer c where c.customerName like %:name")
    List<String> nameFilter2(@Param("name") String name);
}
