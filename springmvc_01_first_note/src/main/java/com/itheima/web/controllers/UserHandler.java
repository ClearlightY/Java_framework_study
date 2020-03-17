package com.itheima.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/17 21:00
 */
@Controller
public class UserHandler {

    @RequestMapping(path = "/uesr/hello")
    public String hello() {
        System.out.println("hello....");
        // 视图名称
        return "success";
    }

}
