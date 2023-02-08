package com.cos.dong_area_backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmptyController {

    @RequestMapping(method = RequestMethod.OPTIONS, path = "/login")
    @ResponseBody
    @Operation(summary = "야매")
    public String empty() {
        return "Empty";
    }
}
