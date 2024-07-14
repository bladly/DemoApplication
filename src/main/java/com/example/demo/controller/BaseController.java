package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ErrorMessageDto;

public abstract class BaseController {

    protected ResponseEntity<ErrorMessageDto> badRequest(String message) {
        return ResponseEntity.badRequest()
                .body(new ErrorMessageDto(message));
    }
}
