package com.example.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.course.dto.StudentDto;
import com.example.course.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 建议加上 @Mapper 注解
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 多表查询：查询所有学生及其选课数量
     * 使用 LEFT JOIN 确保即使学生未选课也能被查询出来
     * @return 包含选课数量的学生列表
     */
    @Select(
            "SELECT s.*, count(sc.Cno) AS courseCount " +
                    "FROM student s " +
                    "LEFT JOIN sc ON s.Sno = sc.Sno " +
                    "GROUP BY s.Sno"
    )
    List<StudentDto> selectStudentWithCourseCount();
}