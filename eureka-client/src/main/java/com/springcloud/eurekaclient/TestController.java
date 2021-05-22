package com.springcloud.eurekaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 测试controller
 * author: dyh
 * date: 2021/4/27 0027 13:25
 */
@RestController
@RequestMapping("/api/v1/product")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/service")
    public String productService() {
        logger.info("测试链路追踪...");
        return "测试链路追踪...";
    }

}
