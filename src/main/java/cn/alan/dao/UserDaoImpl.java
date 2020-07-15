package cn.alan.dao;

import cn.alan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // 1. add a user to db
    public int add(User user) {
        String sql = "insert into t_book (bookId,bookName,status) values(?,?,?)";
        Object[] params = {user.getUserId(), user.getUserName(), user.getStatus()};
        return jdbcTemplate.update(sql, params);
    }

    // 2. update a record
    public int update(User user) {
        String sql = "update t_book set bookName=?,status=? where bookId=?";
        Object[] params = {user.getUserName(), user.getStatus(), user.getUserId()};
        return jdbcTemplate.update(sql, params);
    }


    // 3. delete a record
    public int delete(User user) {
        String sql = "delete from t_book where bookId=?";
        Object[] params = {user.getUserId()};
        return jdbcTemplate.update(sql, params);
    }

    // query a value
    public int queryCount() {
        String sql = "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    // query a record by id
    public User queryById(String id) {
        String sql = "select * from t_book where bookId = ?";
        Object[] args = {id};
        User user = jdbcTemplate.queryForObject(sql, new UserRowMap(), args);
        return user;
    }

    // query a records by sql
    public List<User> queryBySql(String sql) {
        List<User> list = jdbcTemplate.query(sql, new UserRowMap());
        return list;
    }

    // batch add records
    public int[] batchAdd(List<User> list) {
        String sql = "insert into t_book (bookId,bookName,status) values(?,?,?)";
        List<Object[]> args = new ArrayList<Object[]>();

        if (list != null && list.size() > 0) {
            for (int index = 0; index < list.size(); index++) {
                User user = list.get(index);
                Object[] obj = {user.getUserId(), user.getUserName(), user.getStatus()};
                args.add(obj);
            }
        }

        return jdbcTemplate.batchUpdate(sql, args);

    }

    // batch update records
    public int[] batchUpdate(List<User> list) {
        String sql = "update t_book set bookName=?,status=? where bookId=?";
        List<Object[]> args = new ArrayList<Object[]>();

        if (list != null && list.size() > 0) {
            for (int index = 0; index < list.size(); index++) {
                User user = list.get(index);
                Object[] obj = { user.getUserName(), user.getStatus(),user.getUserId()};
                args.add(obj);
            }
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    // batch delete records
    public int[] batchDelete(List<User> list) {
        String sql = "delete from t_book where bookId=?";
        List<Object[]> args = new ArrayList<Object[]>();
        if (list != null && list.size() > 0) {
            for (int index = 0; index < list.size(); index++) {
                User user = list.get(index);
                Object[] obj = { user.getUserId()};
                args.add(obj);
            }
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
}

class UserRowMap implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String bookId = resultSet.getString("bookId");
        String bookName = resultSet.getString("bookName");
        String status = resultSet.getString("status");
        User user = new User(bookId, bookName, status);
        return user;
    }
}
