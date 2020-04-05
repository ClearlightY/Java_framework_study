package top.clearlight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.clearlight.dao.BookMapper;
import top.clearlight.pojo.Books;

import java.util.List;

/**
 * @author <a href="mail to: lxy12531@163.com" rel="nofollow">lxy</a>
 * @date 2020/4/5 16:40
 */
public class BookServiceImpl implements BookService {

    // service调用dao: 组合dao
    @Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook() ;
    }
}
