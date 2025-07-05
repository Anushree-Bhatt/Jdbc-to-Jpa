package com.practice.Jdbc_To_Jpa.jdbc;

import com.practice.Jdbc_To_Jpa.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

@Repository
public class Dao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirth_date(rs.getDate("birth_date").toLocalDate());
            return person;
        }
    }

    public Person findById(Integer id){
        return jdbcTemplate.queryForObject("select * from Person where id = ?", new Object[]{id}, new PersonRowMapper());
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public int save(Person person){
        return jdbcTemplate.update("insert into Person(id, name, location, birth_date) values(?, ?, ?, ?)",
                                    new Object[]{person.getId(), person.getName(), person.getLocation(), person.getBirth_date()});
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
