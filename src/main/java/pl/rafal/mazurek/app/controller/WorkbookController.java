package pl.rafal.mazurek.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkbookController {

    @GetMapping(path = "/healthcheck")
    public String healthCheck(){
        return "It works";
    }
}
