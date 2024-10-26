package com.nielo.apikeygenerator.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private static final SecureRandom secureRandom = new SecureRandom();

    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    @Override
    public String generateApiKey() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String generateApiSecrete() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
