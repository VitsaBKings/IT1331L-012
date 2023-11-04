package com.uap.it1311l.passwordencryptorapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionMybatisMapper;

@Service
public class EncryptDecryptService {
	@Autowired
	EncryptionApiClient apiClient;
	
	@Autowired
	EncryptionMybatisMapper mybatisMapper;
	
	public EncryptionResponse encrypt(String password) {
		EncryptionResponse hayst = apiClient.encrypt("kahitanongpassword", password, "AES");
		mybatisMapper.insert(hayst.getResult());
		return hayst;
	}
	
	public String decrypt(String hash) {
		if (mybatisMapper.exists(hash) > 0) {
			EncryptionResponse hayst = apiClient.decrypt("kahitanongpassword", hash, "AES");
			return hayst.getResult();
		} else {
			return "Encrypted Password does not exist.";
		}
	}
}
