package top.clearlight.controller;

import org.springframework.stereotype.Controller;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/16 21:12
 */
@Controller
public class HelloController {

    // @RequestMapping
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return null;
    }
}
