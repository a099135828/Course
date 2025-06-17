package com.example.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.course.entity.SC;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SCMapper extends BaseMapper<SC> {
    // 对于基本的增删改查，BaseMapper 已经提供了足够的方法（如 selectList, insert, update, delete）。
    // 如果未来有复杂的多表连接查询（例如，查询某学生选的所有课程及其详细信息），可以在这里添加自定义的 SQL 方法。
}