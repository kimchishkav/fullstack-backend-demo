package com.example.demo.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = "*",
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.OPTIONS}
)
@RestController
public class LoginCorsController {

    @RequestMapping(value = "/login", method = RequestMethod.OPTIONS)
    public void loginOptions() {
        // Ничего не делаем — Spring автоматически добавит CORS headers
    }
}