package com.springcloud.sericefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: feign service
 * feign默认集成了ribbon（负载均衡）的功能
 * author: dyh
 * date: 2021/4/27 0027 15:23
 */
//服务名
@FeignClient(value = "service-hi")
public interface FeignService {

    //接口全路径名称
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    //测试链路追踪
    @RequestMapping(value = "/api/v1/product/service",method = RequestMethod.GET)
    String testSleuth();
}
