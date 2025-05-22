package com.example.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// 1. Controller 层
@RestController
@CrossOrigin // 允许跨域访问
@RequestMapping("/api")
public class SqlController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/execute-sql")
    public ResponseEntity<?> executeSql(@RequestBody String sql) {
        try {
            // 使用 JdbcTemplate 执行动态 SQL
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // 捕获 SQL 异常
            return ResponseEntity.status(500).body("SQL Error: " + e.getMessage());
        }
    }
}