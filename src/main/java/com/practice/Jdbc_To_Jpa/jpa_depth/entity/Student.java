package com.practice.Jdbc_To_Jpa.jpa_depth.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    public Student() {

    }

    public Student(String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", passport=" + passport+
                '}';
    }
}
