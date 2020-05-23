package com.codegym.laptopmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date customer_date_orders;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCustomer_date_orders() {
        return customer_date_orders;
    }

    public void setCustomer_date_orders(Date customer_date_orders) {
        this.customer_date_orders = customer_date_orders;
    }
}
