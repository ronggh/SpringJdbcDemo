package cn.alan.test;

import cn.alan.config.TxConfig;
import cn.alan.service.BookService;
import cn.alan.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 完全使用注解方式
 */

public class TestTrans {
    public static void main(String[] args) {
        // 1. 配置类方式：加载配置类
         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        // 2. XML配置文件方式：trans.xml的类加载到容器
         //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("trans.xml");
        //从容器获取目标对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.accoutMoney();
    }
}
