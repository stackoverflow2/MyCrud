package com.mobiliya.springdemo.Mycrud.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="machine")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="machine_id")
    private int machine_id;


    @Column(name = "name")
    private String name;

    @Column(name = "parts_count")
    private int parts_count;

    @Column(name = "price")
    private float price;

    @Transient
    private float sum;

    @Column(name = "location_id")
    private int location_id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id",insertable = false,updatable = false)
    private Location location;


    public Machine(){}

    public Machine(int machine_id, String name, int parts_count, float price, int location_id, Location location) {
        this.machine_id = machine_id;
        this.name = name;
        this.parts_count = parts_count;
        this.price = price;
        this.location_id = location_id;
        this.location = location;
    }

    public Machine(String name, int parts_count, float price, int location_id, Location location) {
        this.name = name;
        this.parts_count = parts_count;
        this.price = price;
        this.location_id = location_id;
        this.location = location;
    }

    public int getMachine_id() {
        return machine_id;
    }

    public String getName() {
        return name;
    }

    public int getParts_count() {
        return parts_count;
    }

    public float getPrice() {
        return price;
    }

    public int getLocation_id() {
        return location_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setMachine_id(int machine_id) {
        this.machine_id = machine_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParts_count(int parts_count) {
        this.parts_count = parts_count;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "machine_id=" + machine_id +
                ", name='" + name + '\'' +
                ", parts_count=" + parts_count +
                ", price=" + price +
                ", location_id=" + location_id +
                ", location=" + location +
                '}';
    }
}

