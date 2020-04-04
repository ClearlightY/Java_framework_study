package top.clearlight.dao;

import org.apache.ibatis.annotations.Param;
import top.clearlight.pojo.Books;

import java.util.List;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/4 23:10
 */
public interface BookMapper {

    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(@Param("bookId") int id);

    // 更新一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookByName(String bookName);

    // 查询全部的书
    List<Books> queryAllBook();
}
