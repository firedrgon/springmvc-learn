package com.ypvoid.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yuanping on 2017/11/30.
 */
@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {
    private final static String SUCCESS="success";

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String testRestDelete(@PathVariable("id") Integer id) {
        System.out.println("DELETE,id=" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String testRestPut(@PathVariable("id") Integer id) {
        System.out.println("PUT,id=" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRestPost(Integer id) {
        System.out.println("POST,id=" + id);
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id) {
        System.out.println("GET,id=" + id);
        return SUCCESS;
    }

    /**
     * @PathVariable 可以将URL中占位符参数绑定到控制器处理方法的入参中
     *
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathvariable(@PathVariable("id") Integer id) {
        System.out.println("id=" + id);
        return SUCCESS;
    }

    /**
     * params：表示必须有username，age，age不等于10
     * @return
     */
    @RequestMapping(value = "/testParams", method = RequestMethod.GET, params = {"username", "age!=10"})
    public String testParams() {
        return SUCCESS;
    }

    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        return SUCCESS;
    }
}
