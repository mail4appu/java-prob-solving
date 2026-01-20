package com.idrive.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ADDRESS")
public class Address {
     int id;

    private String country;
    private String city;
    private String street;
    private int pinCode;

    private List<Student> student = new ArrayList<>();



    public String getCountry() {
		return country;
	}

    public void setCountry(String country) {
		this.country = country;
	}

    public String getCity() {
		return city;
	}
    public void setCity(String city) {
		this.city = city;
	}
    public String getStreet() {
		return street;
	}
    public void setStreet(String street) {
		this.street = street;
	}
    public int getPinCode() {
		return pinCode;
	}
    public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "stdAddress")
    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", pinCode=" + pinCode +
                ", student=" + student +
                '}';
    }
}
