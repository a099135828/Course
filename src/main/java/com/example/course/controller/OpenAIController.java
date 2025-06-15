package com.example.course.controller;

import com.example.course.dto.ChatRequest; // 1. 导入我们创建的 DTO
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*; // 2. 导入 PostMapping 和 RequestBody
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
public class OpenAIController {

    @Autowired
    private OpenAiChatModel chatModel;

    /**
     * 普通的、非流式的聊天接口
     * 同样建议改为 POST 以保持一致性
     */
    @PostMapping("/openai") // 建议也改为 POST
    public String openai(@RequestBody ChatRequest request) {
        String result = chatModel.call(request.getMessage());
        System.out.println(result);
        return result;
    }

    /**
     * 流式聊天接口
     * 已修改为 POST 方法，以接收包含大量上下文的请求体
     */
    @PostMapping(value = "/openai/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=UTF-8") // 3. 改为 @PostMapping
    public Flux<String> openaiStream(@RequestBody ChatRequest request) { // 4. 使用 @RequestBody 和 DTO
        // 5. 从请求对象中获取消息
        String message = request.getMessage();

        // 核心的 AI调用逻辑保持不变
        Flux<String> result = chatModel.stream(message);

        // 打印流式输出到控制台 (用于调试)
        result.doOnNext(System.out::print).subscribe();

        return result;
    }
}