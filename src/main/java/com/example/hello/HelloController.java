package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

    @Autowired
    private HelloService service;

    @GetMapping("/")
    public String getHello() {
        // hello.htmlに画面遷移
        return "hello";
    }

    @PostMapping("/hello/employee")
    public String postDbRequest(@RequestParam("employee_id") String id, Model model) {

        // 1件検索
        Employee employee = service.getEmployee(id);

        // 検索結果をModelに登録
        model.addAttribute("employee", employee);

        // employee.htmlに画面遷移
        return "hello/employee";
    }
}