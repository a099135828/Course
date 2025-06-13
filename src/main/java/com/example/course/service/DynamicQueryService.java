package com.example.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class DynamicQueryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> executeQuery(String sql) {
        // 1. 安全校验：基础但至关重要
        validateQuery(sql);

        // 2. 执行查询
        // queryForList 非常适合这种动态场景，它返回一个Map列表，
        // 每个Map代表一行，key是列名，value是列值。
        try {
            return jdbcTemplate.queryForList(sql);
        } catch (BadSqlGrammarException e) {
            // 捕获SQL语法错误，向上抛出自定义异常或直接抛出，由Controller处理
            throw new IllegalArgumentException("SQL 语法错误: " + e.getSQLException().getMessage());
        } catch (Exception e) {
            // 其他可能的数据库访问异常
            throw new RuntimeException("数据库查询执行失败", e);
        }
    }

    private void validateQuery(String sql) {
        if (!StringUtils.hasText(sql)) {
            throw new IllegalArgumentException("SQL语句不能为空");
        }

        String trimmedSql = sql.trim().toLowerCase();

        // 必须以 "select" 开头
        if (!trimmedSql.startsWith("select")) {
            throw new IllegalArgumentException("非法操作：只允许执行 SELECT 查询。");
        }

        // 不允许包含分号，防止执行多条语句
        if (trimmedSql.contains(";")) {
            throw new IllegalArgumentException("非法操作：不允许执行多条SQL语句。");
        }
    }
}