package com.example.course.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("SC")
public class SC {

    //学号 (复合主键之一)
    @TableField("Sno")
    private String sno;

    //课程号 (复合主键之一)
    @TableField("Cno")
    private String cno;

    //成绩
    @TableField("Grade")
    private Integer grade;

    //学期
    @TableField("Semester")
    private String semester;

    //教学班
    @TableField("Teachingclass")
    private String teachingclass;
}