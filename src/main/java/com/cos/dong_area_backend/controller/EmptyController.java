package com.cos.dong_area_backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmptyController {

    @RequestMapping(method = RequestMethod.OPTIONS, path = "/login")
    @ResponseBody
    public void empty() {
    }

}
