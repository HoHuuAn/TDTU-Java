package com.hohuuan;

import jakarta.persistence.*;
@Entity
@Table(name = "MobilePhone")
public class Phone {
    @Id
    private String ID;

    @Column(nullable = false, length = 128)
    private String Name;

    @Column(nullable = false)
    private int Price;

    @Column(nullable = false, length = 128)
    private String Color;

    @Column(nullable = false)
    private String Country;

    @Column(nullable = false)
    private int Quantity;

    @ManyToOne
    @JoinColumn(name = "manufacture_id", referencedColumnName = "ID" )
    private Manufacture manufacture;

    public Phone() {
    }

    public Phone(String ID, String name, int price, String color, String country, int quantity, Manufacture manufacture) {
        this.ID = ID;
        Name = name;
        Price = price;
        Color = color;
        Country = country;
        Quantity = quantity;
        this.manufacture = manufacture;
    }

    public Phone(String ID, String name, int price, String color, String country, int quantity) {
        this.ID = ID;
        Name = name;
        Price = price;
        Color = color;
        Country = country;
        Quantity = quantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Color='" + Color + '\'' +
                ", Country='" + Country + '\'' +
                ", Quantity=" + Quantity +
                ", Manufacture=" + (manufacture == null ? "Not Found" : manufacture.getName())  +
                '}';
    }
}
