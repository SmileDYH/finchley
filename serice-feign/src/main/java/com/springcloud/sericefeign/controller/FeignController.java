package com.springcloud.sericefeign.controller;

import com.springcloud.sericefeign.service.FeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: feign controller
 * author: dyh
 * date: 2021/4/27 0027 15:22
 */
@RestController
public class FeignController {
    private Logger logger = LoggerFactory.getLogger(FeignController.class);

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    FeignService feignService;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        logger.info("FeignController,name:{}", name);
        return feignService.sayHiFromClientOne( name );
    }

    @GetMapping(value = "/testSleuth")
    public String testSleuth() {
        logger.info("FeignController,testSleuth()");
        String ret = feignService.testSleuth();
        logger.info("FeignController,testSleuth(),ret:{}", ret);
        return ret;
    }
}
