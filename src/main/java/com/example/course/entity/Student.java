package com.example.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.sql.Date;

@Data // Lombok 注解：自动生成 Getter, Setter, toString, equals, hashCode
public class Student {

    @TableId(value = "Sno", type = IdType.INPUT) // 声明主键，类型为手动输入
    private String sno;

    @TableField("Sname")
    private String sname;

    @TableField("Ssex")
    private String ssex; // 补全 Ssex 字段

    @TableField("Sbirthdate")
    private Date sbirthdate;

    @TableField("Smajor")
    private String smajor;
}