package com.ypvoid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yuanping on 2017/12/13.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) applicationContext.getBean("arithmeticCalculator");
        System.out.println(arithmeticCalculator.getClass().getName());
        int add = arithmeticCalculator.add(21, 43);
        System.out.println("add=" + add);

        arithmeticCalculator.div(3, 0);
    }
}





































