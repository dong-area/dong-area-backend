package com.cos.dong_area_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/collabo")
public class CollaboController {
    @GetMapping("/request")
    public String collaboRequest(){
        return null;
    }
}
