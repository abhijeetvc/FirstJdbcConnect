package com.firstjdbcapp.FirstJdbcConnect.impl;

import com.firstjdbcapp.FirstJdbcConnect.model.Student;
import com.firstjdbcapp.FirstJdbcConnect.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

/**
 * Created by abhi on 31/10/17.
 */

@Repository
public class StudentImpl implements StudentRepo{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getData() {

        String sql="select * from student";

        List<Student> list=
                jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));

        return list;
    }

    @Override
    public Student getStudent(Integer id) {

        String sql="select * from student where id=?";

        Student st=
                jdbcTemplate
                        .queryForObject(sql,new Object[]{id},new int[]{Types.INTEGER},
                                new BeanPropertyRowMapper<>(Student.class));
        return st;
    }

    @Override
    public void saveData(Student st) {

        String sql="insert into student values(?,?,?)";

        jdbcTemplate.update(sql,new Object[]{st.getId(),st.getName(),st.getCity()},
                new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR});

    }

    @Override
    public void updateData(Integer id, String name) {

        String sql="update student set name=? where id=?";

        jdbcTemplate.update(sql,new Object[]{name,id},new int[]{Types.VARCHAR,Types.INTEGER});


    }
}
