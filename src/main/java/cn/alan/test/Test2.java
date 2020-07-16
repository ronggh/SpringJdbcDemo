package cn.alan.test;

import cn.alan.config.TxConfig;
import cn.alan.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// 完全使用注解方式
public class Test2 {
    public static void main(String[] args) {
        // 把beans.xml的类加载到容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        //从容器获取目标对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.testTrans();
    }
}
