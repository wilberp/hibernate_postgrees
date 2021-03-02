package com.chinock.store.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/teste")
public class StatusController {

@GetMapping(value = "/status")
    public String Status(){
        return "Online";
    }
}
