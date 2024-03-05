package com.example.bccom.controllers;

import com.example.bccom.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@ComponentScan({"com.example.bccom.controllers", "com.example.bccom.models", "com.example.bccom.services",
        "com.example.bccom.repo"})

public class UserController implements ErrorController {

    private final UserService userService;

        @GetMapping("/login")
    public String registration(){
        return "login";
    }

}
