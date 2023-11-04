package com.uap.it1311l.passwordencryptorapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;

@Configuration
public class EncryptionApiConfig {
	@Bean
	EncryptionApiClient encryptionApi() {
		WebClient webClient = WebClient.builder()
				.baseUrl("https://encryption-api1.p.rapidapi.com/api/Cryptor")
				.defaultHeader("X-RapidAPI-Key", "3fc51b736bmsh458a641c22fc8e8p14df64jsnccf7781b67fe")
				.defaultHeader("X-RapidAPI-Host", "encryption-api1.p.rapidapi.com")
				.build();
		
		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(webClient))
				.build();
		return httpServiceProxyFactory.createClient(EncryptionApiClient.class);
	}
}
