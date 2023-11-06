package com.trading.TradingUpFundationBackend.security;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Encryption{
    @Value("${encryption.key}")
    private String key;

    @Bean
    public BasicTextEncryptor encryptor(){
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(key);
        return encryptor;
    }


    public String encrypt(String chain){return encryptor().encrypt(chain);}
    public String decrypt(String encryptedChain){return encryptor().decrypt(encryptedChain);}
}