package com.mercadopago.config;

import org.springframework.beans.factory.annotation.Value;

import com.mercadopago.MercadoPagoConfig;

import jakarta.annotation.PostConstruct;

public class MercadoPagoInitializer {
	
	@Value("${mercadopago.token}")
    private String accessToken;
	
	@PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(accessToken);
    }

}
