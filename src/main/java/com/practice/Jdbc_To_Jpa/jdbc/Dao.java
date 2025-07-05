package com.practice.Jdbc_To_Jpa.jdbc;

import com.practice.Jdbc_To_Jpa.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Person findById(Integer id){
        return jdbcTemplate.queryForObject("select * from Person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }
}
