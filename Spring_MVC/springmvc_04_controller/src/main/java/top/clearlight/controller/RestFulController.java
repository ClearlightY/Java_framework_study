package top.clearlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/30 21:20
 */
@Controller
public class RestFulController {

    /* 需要如下请求: http://localhost:8080/add?a=12&b=215*/
    @RequestMapping("/add")
    public String test1(int a, int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "a + b = " + res);
        return "hello";
    }

    /* 改为如下请求: http://localhost:8080/multiply/12/3 */
    @RequestMapping("/multiply/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a * b;
        model.addAttribute("msg", "a * b = " + res);
        return "hello";
    }

    /* 改为如下请求: http://localhost:8080/multiply/12/3 */
    @RequestMapping(value = "/multiply2/{a}/{b}", method = RequestMethod.DELETE)
    public String test3(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a * b;
        model.addAttribute("msg", "a * b = " + res);
        return "hello";
    }

    @RequestMapping("/name/{a}/{name}")
    public String test3(@PathVariable int a, @PathVariable String name, Model model) {
        String str = a + name;
        model.addAttribute("msg", "Hello" + str);
        return "hello";
    }

    @PostMapping("/add/{a}/{b}")
    public String test4(@PathVariable int a, @PathVariable String b, Model model) {
        String res = a + b;
        model.addAttribute("msg", "a + b =" + res);
        return "hello";
    }

    /* 如果执行http://localhost:8080/add/1/2的话, 将会走test5方法, 因为有参数为get方式请求*/
    @GetMapping("/add/{a}/{b}")
    public String test5(@PathVariable int a, @PathVariable String b, Model model) {
        String res = a + b;
        model.addAttribute("msg", "a + 'b'=" + res);
        return "hello";
    }
}
