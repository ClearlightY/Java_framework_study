package top.clearlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/3/28 0:20
 */
/*@Controller是为了让Spring IOC容器初始化时自动扫描到;*/
@Controller
/*@RequestMapping是为了映射请求路径, 这里因为类与方法上都有映射所以访问时应该是/HelloController/hello;*/
@RequestMapping("HelloController")
public class HelloController {

    // 真实访问地址: 项目名/HelloController/hello
    // 方法中声明Model类型的参数: 为了把Action中的数据带到视图中;
    @RequestMapping("/hello")
    public String hello(Model model) {
        // 封装数据
        // 向模型中添加属性msg与值, 可以再JSP页面中取出并渲染
        model.addAttribute("msg", "hello SpringMVC Annotation");

        // 会被视图解析器处理
        // 方法返回的结果是视图的名称hello, 加上配置文件中的前后缀变成
        // WEB-INF/jsp/hello.jsp
        return "hello";
    }

}
