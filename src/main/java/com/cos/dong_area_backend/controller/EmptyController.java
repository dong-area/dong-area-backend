package com.cos.dong_area_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmptyController {

    @RequestMapping(method = RequestMethod.OPTIONS, path = "/login")
    @ResponseBody
    public void empty() {
    }

}
