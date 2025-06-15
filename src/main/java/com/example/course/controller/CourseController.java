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
public class CourseController {
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
    public ResponseEntity<Void> deleteCourse(@PathVariable("cno") String cno) {
        courseMapper.deleteById(cno);
        return ResponseEntity.ok().build();
    }

    // 查询所有课程（用于前端表格）
    @GetMapping
    public List<Course> getAllCourses() {
        return courseMapper.selectList(null);
    }

    @PutMapping("/{cno}")
    public ResponseEntity<Void> updateCourse(@PathVariable("cno") String cno, @RequestBody Course courseDetails) {
        System.out.println("准备更新课程，Cno: " + cno);
        System.out.println("更新后的数据：" + courseDetails);

        // 确保前端传来的 courseDetails 里的 cno 和路径中的 cno 一致，或者以后者为准
        courseDetails.setCno(cno);

        // MyBatis Plus 的 updateById 会根据主键 (Cno) 去更新
        int result = courseMapper.updateById(courseDetails);

        if (result > 0) {
            return ResponseEntity.ok().build(); // 更新成功
        } else {
            return ResponseEntity.notFound().build(); // 如果没找到对应 cno 的课程
        }
    }
}