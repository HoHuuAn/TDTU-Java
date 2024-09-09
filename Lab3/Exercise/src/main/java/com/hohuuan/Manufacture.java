package com.hohuuan;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Manufacture")
public class Manufacture {
    @Id
    private String ID;

    @Column(nullable = false, length = 128)
    private String Name;

    @Column(nullable = false)
    private String Location;

    @Column(nullable = false)
    private int Employee;

    @OneToMany(mappedBy = "manufacture", fetch = FetchType.EAGER)
    private List<Phone> phones;

    public Manufacture(){

    }

    public Manufacture(String ID, String name, String location, int employee, List<Phone> phones) {
        this.ID = ID;
        Name = name;
        Location = location;
        Employee = employee;
        this.phones = phones;
    }

    public Manufacture(String ID, String name, String location, int employee) {
        this.ID = ID;
        Name = name;
        Location = location;
        Employee = employee;
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getEmployee() {
        return Employee;
    }

    public void setEmployee(int employee) {
        Employee = employee;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", Employee=" + Employee +
                ", Phones=" + phones.size() +
                '}';
    }
}