package com.hohuuan.web.model;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    private int id;
    private String name;
    private int price;


    public Product() { }

    public Product(String name, int price) {
        this.id = (int) (Math.random() * Integer.MAX_VALUE);
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
