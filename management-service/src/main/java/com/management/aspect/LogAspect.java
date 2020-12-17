/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.management.aspect;

import com.citic.common.util.RequestHolder;
import com.citic.common.util.StringUtils;
import com.citic.common.util.ThrowableUtil;
import com.management.entity.system.Log;
import com.management.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.security.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 配置@Log的Aop
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

//    private final LogService logService;

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

//    public LogAspect(LogService logService) {
//        this.logService = logService;
//    }

    @Autowired
    LogService logService;

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.citic.common.annotation.Log)")
    public void logPointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        currentTime.set(System.currentTimeMillis());
        result = joinPoint.proceed();
        Log log = new Log("INFO",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.logSave(logInfo(joinPoint, log, request));
        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Log log = new Log("ERROR",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        log.setExceptionDetail(ThrowableUtil.getStackTrace(e).getBytes());
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.logSave(logInfo((ProceedingJoinPoint) joinPoint, log, request));
    }

    /**
     * 处理日志信息
     * @param joinPoint
     * @param log
     * @param request
     * @return
     */
    public Log logInfo(ProceedingJoinPoint joinPoint, Log log, HttpServletRequest request) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //反射Log对象
        com.management.annotation.Log aopLog = method.getAnnotation(com.management.annotation.Log.class);
        //获取ip
        String ip = StringUtils.getIp(request);
        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";
        log.setUsername(getUsername());
        //浏览器
        log.setBrowser(StringUtils.getBrowser(request));
        //参数值
        StringBuilder params = new StringBuilder("{");
        List<Object> argValues = new ArrayList<>(Arrays.asList(joinPoint.getArgs()));
        for (Object argValue : argValues) {
            params.append(argValue).append(" ");
        }
        //操作说明
        log.setDescription(aopLog.value());
        log.setRequestIp(ip);
        log.setMethod(methodName);
        log.setAddress(StringUtils.getCityInfo(ip));
        log.setParams(params + " }");
        log.setOperationType(aopLog.type().getValue());
        return log;
    }

    public String getUsername() {
        try {
            return SecurityUtils.getCurrentUsername();
        }catch (Exception e){
            return "";
        }
    }

}
