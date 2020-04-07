package top.clearlight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.clearlight.pojo.Books;
import top.clearlight.service.BookService;

import java.util.List;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/6 14:39
 */
@Controller
@RequestMapping("/book")
public class BookController {

    // controller 调用 service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部的数据, 并且返回到一个数据展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        System.out.println("The first");
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        System.out.println("hello jack");
        System.out.println(list);
        return "allBook";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "addBook";
    }

}
