package com.uap.it1311l.passwordencryptorapi.webclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;

@HttpExchange
public interface EncryptionApiClient {
	@GetExchange("/encryptstring?secretKey={secretKey}&plainText={plainText}&cryptAlgorithm={cryptAlgorithm}")
	EncryptionResponse encrypt(@PathVariable String secretKey, @PathVariable String plainText, @PathVariable String cryptAlgorithm);
	
	@GetExchange("/decryptstring?secretKey={secretKey}&encryptedText={encryptedText}&cryptAlgorithm={cryptAlgorithm}")
	EncryptionResponse decrypt(@PathVariable String secretKey, @PathVariable String encryptedText, @PathVariable String cryptAlgorithm);
}
