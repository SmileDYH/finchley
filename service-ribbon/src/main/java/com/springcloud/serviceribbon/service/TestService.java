package com.springcloud.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * description: 测试service
 * author: dyh
 * date: 2021/4/27 0027 14:47
 */
@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 通过之前注入ioc容器的restTemplate来消费service-hi服务的“/hi”接口
     * @param name
     * @return
     */
    public String hiService(String name) {
        //SERVICE-HI = eureak客户端name变大写,也就是消费者的服务名
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
