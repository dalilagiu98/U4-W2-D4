package org.example.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    //ATTRIBUTES LIST:
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    //CONSTRUCTOR:
    public Order(Customer customer) {
        Random random = new Random();
        this.id = random.nextLong();
        this.status = "Order processed!";
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now().plusWeeks(1);
        this.products = new ArrayList<>();
        this.customer = customer;
    }

    //METHODS:
    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotal () {
        return this.products.stream().mapToDouble(product -> product.getPrice()).sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public long getId() {
        return id;
    }
}
