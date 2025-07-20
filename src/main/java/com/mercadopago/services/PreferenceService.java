package com.mercadopago.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

@Service
public class PreferenceService {

	@Value("${mercadopago.token}")
    private String accessToken;

	public void criarPagamento() throws MPException, MPApiException {
		MercadoPagoConfig.setAccessToken(accessToken);
		PreferenceItemRequest itemRequest =
			       PreferenceItemRequest.builder()
			           .id("1234")
			           .title("Games")
			           .description("PS5")
			           .pictureUrl("http://picture.com/PS5")
			           .categoryId("games")
			           .quantity(2)
			           .currencyId("BRL")
			           .unitPrice(new BigDecimal("4000"))
			           .build();
			   List<PreferenceItemRequest> items = new ArrayList<>();
			   items.add(itemRequest);
			PreferenceRequest preferenceRequest = PreferenceRequest.builder()
			.items(items).build();
			PreferenceClient client = new PreferenceClient();
			Preference preference = client.create(preferenceRequest);
			System.out.println(preference.getSandboxInitPoint());
	}
}
