package com.example.course.dto; // 建议放在专门的 dto 包下

import com.example.course.entity.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true) // 确保 equals 和 hashCode 也包含父类字段
public class StudentDto extends Student {

    // 用于存放该学生选择的课程数量
    private Integer courseCount;
}