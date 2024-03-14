package org.example;

import com.github.javafaker.Faker;
import org.example.entities.Customer;
import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {

        //CREATION CUSTOMERS:
        Supplier<Customer> customerSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            return new Customer(faker.gameOfThrones().character());
        };

        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            customerList.add(customerSupplier.get());
        }

        customerList.forEach(customer -> System.out.println(customer));


        //CREATION PRODUCTS:
        Supplier<Product> productSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            return new Product(faker.book().title(), faker.book().genre());
        };

        List<Product> productList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            productList.add(productSupplier.get());
        }

        productList.forEach(product -> System.out.println(product));

        //CREATION ORDERS:
        
    }
}
