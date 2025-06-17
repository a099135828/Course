package com.example.course.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.course.dto.PageResult;
import com.example.course.dto.StudentDto;
import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    // 分页查询所有学生（包含选课数量）
    @GetMapping
    public PageResult<StudentDto> getStudents(
            // 修改这里：明确指定请求参数的名称
            @RequestParam(value = "page", defaultValue = "1") long page,
            @RequestParam(value = "size", defaultValue = "10") long size
    ) {
        // 1. 创建 MyBatis-Plus 的 Page 对象
        Page<StudentDto> pageRequest = new Page<>(page, size);

        // 2. 调用修改后的 Mapper 方法进行分页查询
        List<StudentDto> studentRecords = studentMapper.selectStudentWithCourseCount(pageRequest);

        // 3. 封装成我们自定义的 PageResult 对象返回给前端
        return new PageResult<>(studentRecords, pageRequest.getTotal());
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentMapper.selectList(null);
    }

    // 新增学生
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentMapper.insert(student);
        return ResponseEntity.status(201).body(student);
    }

    // 更新学生信息
    @PutMapping("/{sno}")
    public ResponseEntity<Student> updateStudent(@PathVariable("sno") String sno, @RequestBody Student studentDetails) {
        studentDetails.setSno(sno);
        int updatedRows = studentMapper.updateById(studentDetails);
        if (updatedRows > 0) {
            return ResponseEntity.ok(studentDetails);
        }
        return ResponseEntity.notFound().build();
    }

    // 删除学生
    @DeleteMapping("/{sno}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("sno") String sno) {
        studentMapper.deleteById(sno);
        return ResponseEntity.ok().build();
    }
}