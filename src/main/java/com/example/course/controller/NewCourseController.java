package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/courses")
public class NewCourseController {
    @Autowired
    private CourseMapper courseMapper;

    // 新增课程
    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        System.out.println("接收到的课程数据：" + course);
        courseMapper.insert(course);
        return ResponseEntity.status(201).build();
    }

    // 删除课程
    @DeleteMapping("/{cno}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String cno) {
        courseMapper.deleteById(cno);
        return ResponseEntity.ok().build();
    }

    // 查询所有课程（用于前端表格）
    @GetMapping
    public List<Course> getAllCourses() {
        return courseMapper.selectList(null);
    }
}