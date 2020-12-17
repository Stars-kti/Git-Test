package com.log.rabbit;

import com.alibaba.fastjson.JSON;
import com.log.entity.Log;
import com.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    LogService logService;
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        Log log =  JSON.parseObject(message,Log.class);
        logService.logSave(log);
        latch.countDown();
    }
}