package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LearnController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/findALLcourses")
    public List<Course> find(){return userMapper.SelectAllStudentsAndCourses();}

    @GetMapping("/hello")
    public String hello() {
        return "你好！";
    }

//    @GetMapping("/insert")
//    public void insert(){
//        Course course = new Course();
//        course.setCno("<UNK>");
//        course.setCname("123456");
//        userMapper.insert(course);
//    }

    @GetMapping("/select")
    public List<Course> query(){
        List<Course> list= userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
}