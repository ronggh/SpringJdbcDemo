package cn.alan.dao;

import cn.alan.entity.User;

import java.util.List;

public interface UserDao {
    int add(User user);
    int update(User user);
    int delete(User user);

    // 查询：返回一个值
    // 例：查询记录数
    int queryCount();

    // 查询：返回对象（一条数据）
    User queryById(String id);
    // 查询：返回对象集合（多条数据）
    List<User> queryBySql(String sql);

    // 批量操作
    int[] batchAdd(List<User> list);
    int[] batchUpdate(List<User> list);
    int[] batchDelete(List<User> list);

}
