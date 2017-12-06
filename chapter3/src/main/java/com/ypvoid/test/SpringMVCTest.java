package com.ypvoid.test;

import com.ypvoid.dao.EmployeeDao;
import com.ypvoid.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Yuanping on 2017/12/4.
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) {
        System.out.println("desc:" + desc);
        System.out.println("OriginalFilename:" + file.getOriginalFilename());
        System.out.println("Name:" + file.getName());
        return "success";
    }

    @RequestMapping("/i18n")
    public String testi18n(Locale locale) {
        String message = messageSource.getMessage("i18n.user", null, locale);
        System.out.println("message:" + message);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;

        ServletContext servletContext = session.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/files/abc.txt");
        body = new byte[inputStream.available()];
        inputStream.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return responseEntity;
    }

    @RequestMapping("/testHttpMessageConverter")
    @ResponseBody
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "helloworld!" + new Date();
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee){
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
