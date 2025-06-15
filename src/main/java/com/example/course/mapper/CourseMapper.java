package com.example.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.course.dto.CourseDto;
import com.example.course.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 多表分页查询：查询课程的详细信息，包括选课人数、平均分和先修课名称
     * @param page 分页对象
     * @return 包含详细信息的课程列表
     */
    @Select(
            "SELECT " +
                    "  c1.*, " +
                    "  COUNT(sc.Sno) AS studentCount, " +
                    "  AVG(sc.Grade) AS averageGrade, " +
                    "  c2.Cname AS prerequisiteCourseName " +
                    "FROM " +
                    "  course c1 " +
                    "LEFT JOIN " + // 使用 LEFT JOIN 确保没有学生选的课也能被查询出来
                    "  sc ON c1.Cno = sc.Cno " +
                    "LEFT JOIN " + // 自连接，用于查询先修课名称
                    "  course c2 ON c1.Cpno = c2.Cno " +
                    "GROUP BY " +
                    "  c1.Cno"
    )
    List<CourseDto> selectCourseDetails(Page<CourseDto> page);
}