package pl.rafal.mazurek.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class HealthcheckController {

    @GetMapping(path = "/healthcheck")
    public String healthCheck(){
        return "Application is working!";
    }
}
