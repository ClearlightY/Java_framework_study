package top.clearlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.clearlight.pojo.User;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/3 9:29
 */
@Controller
public class UserController {

    /*他就不会走视图解析器, 会直接返回一个字符串*/
    @ResponseBody
    @RequestMapping("/j1")
    public String json1() {
        // 创建一个对象
        User user = new User(1, "你好", 18);
        return user.toString();
    }
}
