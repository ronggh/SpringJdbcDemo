package cn.alan.test;

import cn.alan.entity.User;

import cn.alan.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //把beans.xml的类加载到容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //从容器获取目标对象
        UserService userService = (UserService) applicationContext.getBean("userService");


        // 1. test add user
        // testAdd(userService);

        // 2. test update user
//        testUpdate(userService);

        // 3. test delete user
//        testDelete(userService);

        // 4. test query one value
//        testQueryCount(userService);

        // 5. test query a record by id
//        testQueryById(userService);

        // 6. test query record by sql
//        testQueryBySql(userService);

        // 7. test batch add records
//        testBatchAdd(userService);

        // 8. test batch update records
//        testBatchUpdate(userService);

        // 9. tests batch delete records
        testBatchDelete(userService);

    }

    // test batch delete records
    private static void testBatchDelete(UserService userService) {
        List<User> list = userService.queryBySql("select * from t_book");
        List<User> list2 = new ArrayList<User>();//
        for (int index = 0; index < list.size(); index++) {
            User user2 = list.get(index);
            int id = Integer.parseInt(user2.getUserId());
            if (id % 2 == 0) {
                list2.add(user2);
            }

        }

        int[] batchResult = userService.batchDelete(list2);
        System.out.println("batch delete:" + Arrays.toString(batchResult));
    }

    // test batch update records
    private static void testBatchUpdate(UserService userService) {
        List<User> list = userService.queryBySql("select * from t_book");
        List<User> list2 = new ArrayList<User>();//

        for (int index = 0; index < list.size(); index++) {
            User user2 = list.get(index);
            int id = Integer.parseInt(user2.getUserId());
            user2.setUserName(user2.getUserName() + "-" + user2.getUserId());
            list2.add(user2);
        }

        int[] batchResult = userService.batchUpdate(list2);
        System.out.println("batch update:" + Arrays.toString(batchResult));

    }

    // test batch add records
    private static void testBatchAdd(UserService userService) {
        List<User> list = userService.queryBySql("select * from t_book");
        List<User> list2 = new ArrayList<User>();//
//        // batch add
        for (int index = 0; index < list.size(); index++) {
            User user2 = list.get(index);
            int id = Integer.parseInt(user2.getUserId());
            user2.setUserId(String.valueOf(id * 10));
            list2.add(user2);
        }
        int[] batchResult = userService.batchAdd(list2);
        System.out.println("batch add:" + Arrays.toString(batchResult));
    }


    // test query records by sql
    private static void testQueryBySql(UserService userService) {
        List<User> list = userService.queryBySql("select * from t_book");
        System.out.println(list);
    }

    // query a record by id
    private static void testQueryById(UserService userService) {
        User user = userService.queryById("1");
        System.out.println("query by id :" + user);
    }

    // test query a value
    private static void testQueryCount(UserService userService) {
        int result = userService.queryCount();
        System.out.println("count = " + result);
    }

    // delete user
    private static void testDelete(UserService userService) {
        User user = new User("5", "Java", "1");
        int result = userService.delete(user);
        System.out.println("delete result = " + result);
    }

    // test update user
    private static void testUpdate(UserService userService) {
        User user = new User("5", "HTML", "1");
        int result = userService.update(user);
        System.out.println("update result = " + result);
    }

    // test add user
    private static void testAdd(UserService userService) {
        User user = new User("5", "Python", "0");
        int result;
        result = userService.add(user);
        System.out.println("add result = " + result);
    }
}
