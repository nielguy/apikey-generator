package com.nielo.apikeygenerator.controller;

import com.nielo.apikeygenerator.service.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @Autowired
    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @GetMapping("/generator-key")
    public ResponseEntity<Map<String, String>> generateApiKey() {
        String apiKey = apiKeyService.generateApiKey();
        String apiSecret = apiKeyService.generateApiSecrete();

        Map<String, String> response = new HashMap<>();
        response.put("apiKey", apiKey);
        response.put("apiSecret", apiSecret);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
