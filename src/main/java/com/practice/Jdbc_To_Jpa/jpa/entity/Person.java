package com.practice.Jdbc_To_Jpa.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private LocalDate birth_date;

    public Person(){}

    public Person(String name, String location, LocalDate birth_date) {
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public Person(Integer id, String name, String location, LocalDate birth_date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
