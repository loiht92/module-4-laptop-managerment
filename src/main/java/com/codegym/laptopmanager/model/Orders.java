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
    private Date order_date;

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

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
}
