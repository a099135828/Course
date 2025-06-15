package com.example.course.dto;

import com.example.course.entity.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true) // 确保 DTO 的 equals 和 hashCode 方法能正确处理父类字段
public class CourseDto extends Course {

    /**
     * 选修该课程的学生人数
     */
    private Integer studentCount;

    /**
     * 该课程的平均分
     */
    private Double averageGrade;

    /**
     * 先修课的课程名称
     */
    private String prerequisiteCourseName; // Cpno 对应的课程名
}