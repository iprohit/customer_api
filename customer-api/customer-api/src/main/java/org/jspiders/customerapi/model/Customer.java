package org.jspiders.customerapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "customer_sales")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id")
    private int customerId;
    @Column(name = "cus_name")
    private String customerName;
    @Column(name = "cus_email")
    private String customerEmail;
    @Column(name = "cus_age")
    private int customerAge;
    @Column(name = "total_purchase")
    private double totalPurchase;

}
