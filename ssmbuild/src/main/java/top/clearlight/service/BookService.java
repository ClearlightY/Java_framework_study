package top.clearlight.service;

import top.clearlight.pojo.Books;

import java.util.List;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/5 16:32
 */
public interface BookService {
    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(int id);

    // 更新一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookByName(String bookName);

    // 查询全部的书
    List<Books> queryAllBook();
}
