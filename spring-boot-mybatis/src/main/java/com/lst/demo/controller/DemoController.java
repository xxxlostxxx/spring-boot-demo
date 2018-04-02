package com.lst.demo.controller;


import com.lst.demo.service.DemoService;
import com.lst.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;


    /**
     * spring-boot 整合mybatis后一次简单的请求
     * @param id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable Long id){
        Result result = new Result();
        result.data = demoService.getUser(id);

        return result;
    }
}
