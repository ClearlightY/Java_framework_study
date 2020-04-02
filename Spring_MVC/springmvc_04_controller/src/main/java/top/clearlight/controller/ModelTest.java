package top.clearlight.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/2 17:48
 */
@Controller
public class ModelTest {

    @RequestMapping("/m1/t1")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());

        return "hello";
    }

    @RequestMapping("/m1/t2")
    public String test2(Model model) {
        // 转发
        model.addAttribute("msg", "forward one");
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/m1/t3")
    public String test3(Model model) {
        // 转发形式第二种
        model.addAttribute("msg", "forward two");
        return "/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/m1/t4")
    public String test4(Model model) {
        // 重定向
        model.addAttribute("msg", "forward one");
        return "redirect:/index.jsp";
    }
}
