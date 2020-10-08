package cn.alan.service;

import cn.alan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
// 这个用于开启事务，可以用在类上，也可以用在方法上
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {
    @Autowired
    private UserDao userDao;

    // 转账
    public void accoutMoney(){
        // Luck 少100
        userDao.reduceMoney();
        // 模拟出现异常
//        int i = 10/0;
        // Mary 多100
        userDao.addMoney();
    }
}
