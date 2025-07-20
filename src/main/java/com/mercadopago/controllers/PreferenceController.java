package com.mercadopago.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.services.PreferenceService;

@RestController
@RequestMapping("/pagamentos")
public class PreferenceController {

	@Autowired
	private PreferenceService preferenceService;
	
	@PostMapping
    public ResponseEntity<?> criarPreferencia() throws MPException, MPApiException {
        preferenceService.criarPagamento();
		return null;
    }
}
