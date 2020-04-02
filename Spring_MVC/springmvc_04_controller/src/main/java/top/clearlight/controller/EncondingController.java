package top.clearlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/2 23:24
 */
@Controller
public class EncondingController {

    @PostMapping("/e/t1")
    public String test1(String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg", name);
        return "hello";
    }
}
