package com.cos.dong_area_backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.dong_area_backend.config.jwt.JwtProperties;
import com.cos.dong_area_backend.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@RestController
@RequestMapping("/collabo")
@RequiredArgsConstructor
public class CollaboController {
    private final AlarmService alarmService;
    @GetMapping("/request")
    public String collaboRequest(@RequestParam("target")String target, @RequestHeader Map<String, String> headers){
        String token = headers.get("authorization").replace(JwtProperties.TOKEN_PREFIX,"");
        String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token).getClaim("username").asString();
        alarmService.sendAlarm(username,target);
        return "sending message succeed!";
    }
}
