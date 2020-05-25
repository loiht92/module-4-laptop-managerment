package com.codegym.laptopmanager.model;

import org.springframework.web.multipart.MultipartFile;


public class LaptopForm {
    private Long id;

    private String name;

    private MultipartFile image;

    private String description;

    private double price;

    private Status status;

    private Orders orders;

    private Producer producer;

    private Customer customer;

    public LaptopForm() {
    }

    public LaptopForm(Long id, String name, MultipartFile image, String description, double price, Status status,
                      Orders orders, Producer producer, Customer customer) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.status = status;
        this.orders = orders;
        this.producer = producer;
        this.customer = customer;
    }

    public LaptopForm(String name, MultipartFile image, String description, double price, Status status,
                      Orders orders, Producer producer, Customer customer) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.status = status;
        this.orders = orders;
        this.producer = producer;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Orders getOrders() {
        return orders;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Orders getOrder() {
        return orders;
    }

    public void setOrder(Orders orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
