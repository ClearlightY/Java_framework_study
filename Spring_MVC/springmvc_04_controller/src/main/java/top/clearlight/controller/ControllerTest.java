package top.clearlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/28 16:42
 */
/*代表这个类会被Spring接管, 被这个注解的类中的所有方法,如果返回值是String,并且有具体页面可以跳转, 那么就会被视图解析器解析;*/
@Controller
public class ControllerTest {

    @RequestMapping("t1")
    public String test1(Model model) {
        model.addAttribute("msg", "hello SpringMVC model!");

        return "hello";
    }

    /*此处返回的同一个页面, 但是返回了不同的内容 因此控制器与视图之间是弱耦合关系*/
    @RequestMapping("t2")
    public String test2(Model model) {
        model.addAttribute("msg", "hello test2");

        return "hello";
    }

}
