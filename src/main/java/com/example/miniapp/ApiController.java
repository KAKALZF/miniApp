package com.example.miniapp;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from Spring Boot! 你好，小程序！");
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return response;
    }

    @GetMapping("/user")
    public Map<String, Object> getUserInfo() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1);
        user.put("name", "张三");
        user.put("email", "zhangsan@example.com");
        user.put("avatar", "https://example.com/avatar.jpg");
        return user;
    }

    @PostMapping("/data")
    public Map<String, Object> postData(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("received", data);
        response.put("message", "数据接收成功");
        return response;
    }
}
