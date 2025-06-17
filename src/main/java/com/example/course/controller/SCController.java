package com.example.course.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.course.entity.SC;
import com.example.course.mapper.SCMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/SC")
public class SCController {
    @Autowired
    private SCMapper scMapper;

    // 1. 查询这条记录
    @GetMapping("/all")
    public List<SC> getScRecord() {
        return scMapper.selectList( null);
    }
}
