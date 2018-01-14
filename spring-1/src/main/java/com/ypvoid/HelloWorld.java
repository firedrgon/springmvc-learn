package com.ypvoid;

/**
 * Created by Yuanping on 2017/12/10.
 */
public class HelloWorld {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloWorld() {
        System.out.println("Hello Wolrd Constructed");
    }
}
