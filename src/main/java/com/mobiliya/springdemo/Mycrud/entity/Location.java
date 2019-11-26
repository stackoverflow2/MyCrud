package com.mobiliya.springdemo.Mycrud.entity;



import javax.crypto.Mac;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int location_id;


    @Column(name = "city")
    private String city;

    @Column(name = "area_code")
    private  int area_code;



//    @OneToOne(mappedBy = "location")
//    private Machine machine;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "location_id", nullable = false)
//    private Machine machine;


    public Location(){}

    public Location(int location_id, String city, int area_code) {
        this.location_id = location_id;
        this.city = city;
        this.area_code = area_code;
    }

    public Location(String city, int area_code) {
        this.city = city;
        this.area_code = area_code;
    }

    public int getLocation_id() {
        return location_id;
    }

    public String getCity() {
        return city;
    }

    public int getArea_code() {
        return area_code;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea_code(int area_code) {
        this.area_code = area_code;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", city='" + city + '\'' +
                ", area_code=" + area_code +
                '}';
    }
}
