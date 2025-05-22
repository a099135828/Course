package com.example.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.course.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<Course> {

    @Select("select * from SC")
    @Results({
            @Result(column = "Cno", property = "Cno"),
            @Result(column = "Cname", property = "Cname"),
            @Result(column = "Ccredit", property = "Ccredit"),
            @Result(column = "Cpno", property = "Cpno")
    })
    List<Course> SelectAllStudentsAndCourses();
}