package org.example.entities;

import java.util.Random;

public class Customer {

    //ATTRIBUTES LIST:
    private long id;
    private String name;
    private int tier;

    //CONSTRUCTOR:
    public Customer(String name) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
        this.tier = random.nextInt(0, 10);
    }

    //METHODS:

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
