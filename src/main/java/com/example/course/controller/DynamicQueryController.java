package com.example.course.controller;

import com.example.course.dto.SqlQueryRequest;
import com.example.course.service.DynamicQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/query")
public class DynamicQueryController {

    @Autowired
    private DynamicQueryService dynamicQueryService;

    @PostMapping("/execute")
    public ResponseEntity<?> executeSql(@RequestBody SqlQueryRequest request) {
        try {
            List<Map<String, Object>> result = dynamicQueryService.executeQuery(request.getSql());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // 捕获我们自定义的校验异常 (400 Bad Request)
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (Exception e) {
            // 捕获其他运行时异常 (500 Internal Server Error)
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "服务器内部错误: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}