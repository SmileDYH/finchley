package com.springcloud.serviceribbon.controller;

import com.springcloud.serviceribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 测试controller
 * author: dyh
 * date: 2021/4/27 0027 14:52
 */
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return testService.hiService( name );
    }
}
