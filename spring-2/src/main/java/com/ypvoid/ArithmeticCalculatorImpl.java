package com.ypvoid;

import org.springframework.stereotype.Service;

/**
 * Created by Yuanping on 2017/12/13.
 */
@Service("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int a, int b) {
        System.out.println("a + b = " + (a + b));
        return a + b;
    }

    @Override
    public int muti(int a, int b) {
        System.out.println("a * b = " + (a * b));
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("a/b=" + a / b);
        return a / b;
    }
}






























