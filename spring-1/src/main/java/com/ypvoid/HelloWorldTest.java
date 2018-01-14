package com.ypvoid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yuanping on 2017/12/10.
 */
public class HelloWorldTest {
    public static void main(String[] args) {
//        HelloWorld hw = new HelloWorld();
//        hw.setName("zhangsan");
//        System.out.println(hw.getName());

        //创建Spring的IOC容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");

        //从Spring IOC容器中获取对象
//        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        //通过ApplicationContext的class获取Bean,这样的话在IOC容器里只能有一个类型的Bean
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        //调用方法
        System.out.println(helloWorld.getName());
    }
}
