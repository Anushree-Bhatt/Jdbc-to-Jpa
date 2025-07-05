package com.practice.Jdbc_To_Jpa.jdbc.entity;

public class Person {
    private Integer Id;
    private String name;
    private String location;

    public Person(){}

    public Person(Integer id, String name, String location) {
        Id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
