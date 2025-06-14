package com.example.course.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy; // <-- 1. 导入这个类
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Course {

    // 【优化建议】@TableId 已经包含了字段映射功能，可以移除多余的 @TableField
    @TableId(value = "Cno", type = IdType.INPUT)
    private String cno;

    @TableField("Cname")
    private String cname;

    @TableField("Ccredit")
    private Integer ccredit;

    // 【核心修改】在这里指定插入策略为 ALWAYS
    @TableField(value = "Cpno", insertStrategy = FieldStrategy.ALWAYS) // <-- 2. 修改这里
    private String cpno;
}