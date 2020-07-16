package cn.alan.service;

import cn.alan.dao.UserDao;
import cn.alan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// 这个用于开启事务，可以用在类上，也可以用在方法上
//@Transactional
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

    // 测试的一个事务方法
    @Transactional
    public void testTrans(){
        userDao.change1();
        // 模拟出现异常
//        int i = 1 / 0;
        userDao.change2();
    }
}
