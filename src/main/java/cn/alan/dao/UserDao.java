package cn.alan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 扣钱的方法
    public void reduceMoney(){
        String sql = "update t_user set money = money - ? where username = ? ";
        jdbcTemplate.update(sql,100,"Luck");
        System.out.println("Luck 转出成功....");
    }

    // 加钱的方法
    public void addMoney(){
        String sql = "update t_user set money = money + ? where username = ? ";
        jdbcTemplate.update(sql,100,"Mary");
        System.out.println("转入到 Mary 成功....");
    }
}
