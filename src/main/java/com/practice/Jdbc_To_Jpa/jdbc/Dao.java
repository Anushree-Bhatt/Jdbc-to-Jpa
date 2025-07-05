package com.practice.Jdbc_To_Jpa.jdbc;

import com.practice.Jdbc_To_Jpa.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public class Dao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Person findById(Integer id){
        return jdbcTemplate.queryForObject("select * from Person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public int update(Person person){
        return jdbcTemplate.update(
                    "update Person " +
                        "set name = ?, location = ?, birth_date = ? " +
                        "where id = ? ", new Object[]{person.getName(), person.getLocation(), person.getBirth_date(), person.getId()});
    }

    public int deleteById(int id1, int id2) {
        return jdbcTemplate.update("delete from Person where id in (?, ?)", new Object[]{id1, id2});
    }


}
