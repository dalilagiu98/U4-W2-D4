package org.example.entities;

import java.util.Random;

public class Product {
    //ATTRIBUTES LIST
    private long id;
    private String name;
    private String category;
    private double price;

    //CONSTRUCTOR:
    public Product(String name, String category) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
        this.category = category;
        this.price = random.nextDouble(0, 1000);
    }

    //METHODS:

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
