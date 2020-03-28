package top.clearlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/28 17:39
 */
@Controller
@RequestMapping("/ct")
public class ControllerTest2 {

    @RequestMapping("/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "hello ct/t1");
        return "hello";
    }

}
