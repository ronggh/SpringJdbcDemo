package cn.alan.dao;

import cn.alan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository("bookDao")
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 1. add a book to db
     *
     * @param book
     * @return
     */
    public int add(Book book) {
        String sql = "insert into t_book (bookId,bookName,status) values(?,?,?)";
        Object[] params = {book.getBookId(), book.getBookName(), book.getStatus()};
        return jdbcTemplate.update(sql, params);
    }


    /**
     * 2. update a record
     *
     * @param book
     * @return
     */
    public int update(Book book) {
        String sql = "update t_book set bookName = ?,status = ? where bookId = ?";
        Object[] params = {book.getBookName(), book.getStatus(), book.getBookId()};
        return jdbcTemplate.update(sql, params);
    }

    /**
     * 3. delete a record
     * @param book
     * @return
     */
    public int delete(Book book) {
        String sql = "delete from t_book where bookId = ? ";
        Object[] params = {book.getBookId()};
        return jdbcTemplate.update(sql, params);
    }


    /**
     * 4. query a value
     * @return
     */
    public int queryCount() {
        String sql = "select count(*) from t_book ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }


    /**
     * 5. query one record
     * @param id
     * @return
     */
    public Book queryOne(String id) {
        String sql = "select * from t_book where bookId = ?";
        Object[] args = {id};
        Book book = jdbcTemplate.queryForObject(sql, new BookRowMap(), args);
        return book;
    }

    /**
     * 6. query records
     * @param sql
     * @return
     */
    public List<Book> queryBooks(String sql) {
        List<Book> list = jdbcTemplate.query(sql, new BookRowMap());
        return list;
    }

    //

    /**
     * 7. batch add records
     * @param list
     * @return
     */
    public int[] batchAdd(List<Book> list) {
        String sql = "insert into t_book (bookId,bookName,status) values(?,?,?)";
        List<Object[]> args = new ArrayList<Object[]>();

        if (list != null && list.size() > 0) {
            for (int index = 0; index < list.size(); index++) {
                Book book = list.get(index);
                Object[] obj = {book.getBookId(), book.getBookName(), book.getStatus()};
                args.add(obj);
            }
        }

        return jdbcTemplate.batchUpdate(sql, args);

    }


    /**
     *  8. batch update records
     * @param list
     * @return
     */
    public int[] batchUpdate(List<Book> list) {
        String sql = "update t_book set bookName=?,status=? where bookId=?";
        List<Object[]> args = new ArrayList<Object[]>();

        if (list != null && list.size() > 0) {
            for (int index = 0; index < list.size(); index++) {
                Book book = list.get(index);
                Object[] obj = {book.getBookName(), book.getStatus(), book.getBookId()};
                args.add(obj);
            }
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }


    /**
     * 9. batch delete records
     * @param list
     * @return
     */
    public int[] batchDelete(List<Book> list) {
        String sql = "delete from t_book where bookId=?";
        List<Object[]> args = new ArrayList<Object[]>();
        if (list != null && list.size() > 0) {
            for (int index = 0; index < list.size(); index++) {
                Book book = list.get(index);
                Object[] obj = {book.getBookId()};
                args.add(obj);
            }
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
}

