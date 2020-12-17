package com.user.client;


import com.user.client.hystrix.AuthServiceHystrix;
import com.user.entity.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ChenJiaxing
 */
@FeignClient(value = "uaa-service",fallback = AuthServiceHystrix.class )
public interface AuthServiceClient {
    /**
     * 从授权服务上获取Token
     * @param client_Id 客户端ID
     * @param client_Secret 客户端名称
     * @param type 操作类型
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestParam("client_id")String client_Id, @RequestParam("client_secret") String client_Secret,
                 @RequestParam("grant_type") String type, @RequestParam("username") String username,
                 @RequestParam("password") String password);

    /**
     * 使用refreshToken刷新Token
     * @param type 操作类型
     * @param refresh_Token refreshToken
     * @param client_Id 客户端id
     * @param client_Secret 客户端名称
     * @return
     */
    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestParam("grant_type") String type, @RequestParam("refresh_token") String refresh_Token,
                 @RequestParam("client_id")String client_Id, @RequestParam("client_secret") String client_Secret);
}



