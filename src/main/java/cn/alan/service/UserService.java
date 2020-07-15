package cn.alan.service;

import cn.alan.dao.UserDao;
import cn.alan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    // add user
    public int add(User user){
        return userDao.add(user);
    }

    // update user
    public int update(User user){
        return userDao.update(user);
    }

    // delete user
    public int delete(User user) {
        return userDao.delete(user);
    }

    // query a value, for example, count
    public int queryCount() {
        return userDao.queryCount();
    }

    //query a record by id
    public User queryById(String id) {
        return userDao.queryById(id);
    }

    // query records by sql
    public List<User> queryBySql(String sql) {
        return userDao.queryBySql(sql);
    }

    // batch add records
    public int[] batchAdd(List<User> list) {
        return userDao.batchAdd(list);
    }

    // batch update records
    public int[] batchUpdate(List<User> list) {
        return userDao.batchUpdate(list);
    }

    // batch delete records
    public int[] batchDelete(List<User> list) {
        return userDao.batchDelete(list);
    }
}
