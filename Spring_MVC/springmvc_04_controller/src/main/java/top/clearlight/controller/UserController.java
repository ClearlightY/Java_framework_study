package top.clearlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.clearlight.pojo.User;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/2 20:19
 */
@Controller
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        // 1. 接受前端参数
        System.out.println("接受到的前端参数为" + name);

        // 2. 将返回的结果传递给前端, Model
        model.addAttribute("msg", name);

        // 3. 视图跳转
        return "hello";
    }

    /*
     * 1. 接受前端用户传递的参数, 判断参数的名字, 假设名字直接在方法上, 可以直接使用
     * 2. 假设传递的是一个对象User, 匹配User对象中的字段名: 如果名字一直则ok, 否则, 匹配不到
     * */
    @GetMapping("t2")
    public String test2(User user) {
        System.out.println(user);
        return "hello";
    }
}
