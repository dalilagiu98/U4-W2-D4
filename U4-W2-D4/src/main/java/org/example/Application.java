package org.example;

import com.github.javafaker.Faker;
import org.example.entities.Customer;
import org.example.entities.Order;
import org.example.entities.Product;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {

    static List<Customer> customerList = new ArrayList<>();
    static List<Product> productList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();
    public static void main(String[] args) {

        //CREATION CUSTOMERS:
        Supplier<Customer> customerSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            return new Customer(faker.gameOfThrones().character());
        };

        for (int i = 0; i < 20; i++) {
            customerList.add(customerSupplier.get());
        }



        //CREATION PRODUCTS:
        Supplier<Product> productSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            return new Product(faker.book().title(), faker.book().genre());
        };

        for(int i = 0; i < 100; i++) {
            productList.add(productSupplier.get());
        }


        //CREATION ORDERS:
        Order orderOne = new Order(customerList.get(0));
        Order orderTwo = new Order(customerList.get(1));
        Order orderThree = new Order(customerList.get(2));
        Order orderFour = new Order(customerList.get(3));
        Order orderFive = new Order(customerList.get(4));
        Order orderSix = new Order(customerList.get(4));

        Product productOne = productList.get(0);
        Product productTwo = productList.get(1);
        Product productThree = productList.get(2);
        Product productFour = productList.get(3);
        Product productFive = productList.get(4);

        orderOne.addProduct(productOne);
        orderOne.addProduct(productFive);
        orderOne.addProduct(productThree);

        orderTwo.addProduct(productTwo);
        orderTwo.addProduct(productThree);

        orderThree.addProduct(productFour);
        orderThree.addProduct(productOne);
        orderThree.addProduct(productTwo);

        orderFour.addProduct(productOne);
        orderFour.addProduct(productFour);

        orderFive.addProduct(productThree);

        orderSix.addProduct(productFour);

        orderList.addAll(Arrays.asList(orderOne, orderTwo, orderThree, orderFour, orderFive, orderSix));


        System.out.println("--------------GET ORDER BY CUSTOMER-------------");
        getOrderByCustomer().forEach((customer, order) -> {
                    System.out.println("--->The customer is: " + customer.getName() + " number of orders: " + order.size());
                    System.out.println("---> The order is: " + order);
            }
        );

        System.out.println("--------------GET ORDER BY CUSTOMER-------------");
        getOrderAndTotal().forEach((name, total) -> {
            System.out.println("NAME: " + name);
            System.out.println("TOTAL: " + total);
            System.out.println("-----------------------------");
        });

        System.out.println("--------------GET MOST EXPENSIVE PRODUCT-------------");
        getMostExpensive().forEach(System.out::println);

    }

    public static Map<Customer, List<Order>> getOrderByCustomer() {
        return orderList.stream().collect(Collectors.groupingBy(Order:: getCustomer));
    }

    public static Map<String, Double> getOrderAndTotal() {
        return orderList.stream().collect(Collectors.groupingBy(order -> order.getCustomer().getName() , Collectors.summingDouble(order -> order.getTotal())));
    }

    public static List<Product> getMostExpensive() {
        return productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(10).collect(Collectors.toList());
    }
}
