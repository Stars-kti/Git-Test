package com.uaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * 获取RAS公钥接口
 */
public class KeyPairController {

//    @Autowired
//    private KeyPair keyPair;
//
//    @GetMapping("/rsa/publicKey")
//    public Map<String, Object> getKey() {
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        return new JWKSet(key).toJSONObject();
//    }
}
