package com.cos.dong_area_backend.config.jwt;

public interface JwtProperties {
    String SECRET = "tndisw";
    int EXPIRATION_TIME = (60000*10); // 10분
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}