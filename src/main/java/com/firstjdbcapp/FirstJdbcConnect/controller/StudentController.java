package com.firstjdbcapp.FirstJdbcConnect.controller;

import com.firstjdbcapp.FirstJdbcConnect.impl.StudentImpl;
import com.firstjdbcapp.FirstJdbcConnect.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by abhi on 31/10/17.
 */


@RestController
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    StudentImpl studentImpl;

    @RequestMapping(value="/listofstudents")
    public List<Student> getStudentData(){

        List<Student> list=studentImpl.getData();

        return list;
    }

    @RequestMapping(value="/student/{id}")
    public Student getStudent(@PathVariable Integer id){

        Student list=studentImpl.getStudent(id);

        return list;
    }

    @RequestMapping(value="/save")
    public String saveStudent(@RequestBody Student stu){

       studentImpl.saveData(stu);
        return "Data saved successfully";
    }

    @RequestMapping(value="/update/{id}/{name}")
    public String updateStudent(@PathVariable Integer id,@PathVariable String name){

        studentImpl.updateData(id,name);

        return "Data updated successfully";
    }
}
