package com.firstjdbcapp.FirstJdbcConnect.repository;

import com.firstjdbcapp.FirstJdbcConnect.model.Student;

import java.util.List;

/**
 * Created by abhi on 31/10/17.
 */
public interface StudentRepo {

    List<Student> getData();

    Student getStudent(Integer id);

    void saveData(Student st);

    void updateData(Integer id,String name);

}
