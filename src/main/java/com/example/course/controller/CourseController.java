package com.example.course.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.course.dto.CourseDto;
import com.example.course.dto.PageResult; // 引入我们创建的 PageResult
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

    // 新增课程 (保持不变)
    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        courseMapper.insert(course);
        return ResponseEntity.status(201).build();
    }

    // 删除课程 (保持不变，但要确保注解正确)
    @DeleteMapping("/{cno}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("cno") String cno) { // 确保有 ("cno")
        courseMapper.deleteById(cno);
        return ResponseEntity.ok().build();
    }

    // 更新课程 (保持不变)
    @PutMapping("/{cno}")
    public ResponseEntity<Void> updateCourse(@PathVariable("cno") String cno, @RequestBody Course courseDetails) {
        courseDetails.setCno(cno);
        courseMapper.updateById(courseDetails);
        return ResponseEntity.ok().build();
    }

    // 查询所有课程 -> 修改为查询课程详情（分页）
    @GetMapping
    public PageResult<CourseDto> getAllCourses(
            @RequestParam(value = "page", defaultValue = "1") long page,
            @RequestParam(value = "size", defaultValue = "10") long size
    ) {
        // 1. 创建 Page 对象，注意泛型是 CourseDto
        Page<CourseDto> pageRequest = new Page<>(page, size);

        // 2. 调用我们自定义的 Mapper 方法
        List<CourseDto> courseRecords = courseMapper.selectCourseDetails(pageRequest);

        // 3. 封装成 PageResult 返回
        return new PageResult<>(courseRecords, pageRequest.getTotal());
    }
}