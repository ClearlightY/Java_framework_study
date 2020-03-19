package com.itheima.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/17 21:00
 */
@Controller
@RequestMapping("/user")
public class UserHandler {

    @RequestMapping(path = "/hello")
    public String hello() {
        System.out.println("hello....");
        // 视图名称
        return "success";
    }


    @RequestMapping(path = "/testRequestMapping", method = {RequestMethod.GET}, params = {"username=jack"})
    public String testRequestMapping() {
        System.out.println("test RequestMapping");
        return "success";
    }
}
