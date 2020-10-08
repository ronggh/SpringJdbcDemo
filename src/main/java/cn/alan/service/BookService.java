package cn.alan.service;

import cn.alan.dao.BookDao;
import cn.alan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    /**
     * 1. add a book to db
     * @param book
     * @return
     */
    public int add(Book book){
        return bookDao.add(book);
    }

    /**
     *  2. update book
     * @param book
     * @return
     */
    public int update(Book book){
        return bookDao.update(book);
    }

    /**
     * 3. delete book
     * @param book
     * @return
     */
    public int delete(Book book) {
        return bookDao.delete(book);
    }

    /**
     * 4. query a value, for example, count
     * @return
     */
    public int queryCount() {
        return bookDao.queryCount();
    }


    /**
     * 5. query one record
     * @param id
     * @return
     */
    public Book queryOne(String id) {
        return bookDao.queryOne(id);
    }

    /**
     * 6. query records
     * @param sql
     * @return
     */
    public List<Book> queryBooks(String sql) {
        return bookDao.queryBooks(sql);
    }

    /**
     * 7. batch add records
     * @param list
     * @return
     */
    public int[] batchAdd(List<Book> list) {
        return bookDao.batchAdd(list);
    }

    /**
     * 8. batch update records
     * @param list
     * @return
     */
    public int[] batchUpdate(List<Book> list) {
        return bookDao.batchUpdate(list);
    }


    /**
     * 9. batch delete records
     * @param list
     * @return
     */
    public int[] batchDelete(List<Book> list) {
        return bookDao.batchDelete(list);
    }

}
