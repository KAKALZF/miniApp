package com.example.miniapp;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    private final String[] greetings = {
        "Hello from Spring Boot! 你好，小程序！",
        "Welcome to MiniApp! 欢迎使用小程序！",
        "Have a nice day! 祝你今天愉快！",
        "Spring Boot is awesome! Spring Boot 真棒！",
        "Hello World! 世界你好！",
        "Greetings from the backend! 来自后端的问候！",
        "Enjoy your coding! 享受编程的乐趣！",
        "May the code be with you! 愿代码与你同在！"
    };
    
    private final Random random = new Random();

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        String randomGreeting = greetings[random.nextInt(greetings.length)];
        response.put("message", randomGreeting);
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
