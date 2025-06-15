package com.example.course.controller;

import com.example.course.dto.StudentDto;
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

    // 查询所有学生（包含选课数量）
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentMapper.selectStudentWithCourseCount();
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
        studentDetails.setSno(sno); // 确保主键一致
        int updatedRows = studentMapper.updateById(studentDetails);
        if (updatedRows > 0) {
            return ResponseEntity.ok(studentDetails);
        }
        return ResponseEntity.notFound().build();
    }

    // 删除学生
    @DeleteMapping("/{sno}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("sno") String sno) {
        // 注意：在实际应用中，删除学生前可能需要先删除 SC 表中关联的记录，以避免外键约束冲突
        studentMapper.deleteById(sno);
        return ResponseEntity.ok().build();
    }
}