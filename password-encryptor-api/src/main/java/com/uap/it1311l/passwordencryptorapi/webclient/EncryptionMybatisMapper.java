package com.uap.it1311l.passwordencryptorapi.webclient;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EncryptionMybatisMapper {
	@Insert("INSERT INTO password(encryptedPassword) VALUES (#{password})")
	public int insert(String password);
	
	@Select("SELECT COUNT(*) FROM password WHERE encryptedPassword = #{password}")
    public int exists(String password);
}
