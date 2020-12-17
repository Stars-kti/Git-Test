package com.gateway.util;



import org.springframework.web.server.ServerWebExchange;

import java.util.List;

/**
 * token校验类
 */
public class UserUtils {

    private static final String AUTHORIZATION = "authorization";

    /**
     * 获取当前请求的token
     * @return
     */
    public static String getCurrentToken(ServerWebExchange exchange) {
        try {
            String token = exchange.getRequest().getHeaders().get(AUTHORIZATION).toString();
            return token.split(" ")[1];
        }catch (Exception e) {
            return null;
        }
    }
}
