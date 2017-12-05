package com.ypvoid.converters;

import com.ypvoid.entities.Department;
import com.ypvoid.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Yuanping on 2017/12/4.
 * 转换器
 */
@Component
public class EmployeeConverter implements Converter<String ,Employee>
{
    @Override
    public Employee convert(String source) {
        if(source != null){
            String [] vals = source.split("-");
            //GG-gg@atguigu.com-0-105
            if(vals != null && vals.length == 4){
                String lastName = vals[0];
                String email = vals[1];
                Integer gender = Integer.parseInt(vals[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(vals[3]));

                Employee employee = new Employee(null, lastName, email, gender, department);
                System.out.println(source + "--convert--" + employee);
                return employee;
            }
        }
        return null;
    }
}
