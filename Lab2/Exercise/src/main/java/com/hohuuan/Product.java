package com.hohuuan;

import java.util.Optional;

public class Product {
    private int id;
    private String name;
    private int price;
    private String color;
    private String brand;
    private String description;
    private int quantity;

    public Product() {
    }

    public Product(String name, int price, String color, String brand, String description, int quantity) {
        this.id = 0;
        this.name = name;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(int id, String name, int price, String color, String brand, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
