package cn.alan.dao;

import cn.alan.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class BookRowMap implements RowMapper<Book> {
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        String bookId = resultSet.getString("bookId");
        String bookName = resultSet.getString("bookName");
        String status = resultSet.getString("status");
        Book book = new Book(bookId, bookName, status);
        return book;
    }
}
