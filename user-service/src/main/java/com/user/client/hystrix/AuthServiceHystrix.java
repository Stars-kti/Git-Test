package com.user.client.hystrix;

import com.user.client.AuthServiceClient;
import com.user.entity.JWT;
import org.springframework.stereotype.Component;

/**
 * @author ChenJiaxing
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {

    @Override
    public JWT getToken(String clientId, String clientSecret, String type, String username, String password) {
        System.out.println("--------opps getToken hystrix---------");
        return null;
    }

    @Override
    public JWT getToken(String type, String refreshToken, String clientId, String clientSecret) {
        System.out.println("--------opps getRefreshToken hystrix---------");
        return null;
    }
}
