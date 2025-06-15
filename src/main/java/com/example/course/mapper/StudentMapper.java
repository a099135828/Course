package com.example.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.course.dto.StudentDto;
import com.example.course.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 多表分页查询：查询所有学生及其选课数量
     * @param page 分页对象，必须放在第一个参数位置
     * @return 分页后的学生列表
     */
    @Select(
            "SELECT s.*, count(sc.Cno) AS courseCount " +
                    "FROM student s " +
                    "LEFT JOIN sc ON s.Sno = sc.Sno " +
                    "GROUP BY s.Sno"
    )
    List<StudentDto> selectStudentWithCourseCount(Page<StudentDto> page); // 参数变为 Page 对象
}