package com.ypvoid.test;

import com.ypvoid.dao.EmployeeDao;
import com.ypvoid.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
        String [] vals = new String[10];
        System.out.println(vals[i]);
        return "success";
    }

    @RequestMapping(value="/testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver(){
        System.out.println("testDefaultHandlerExceptionResolver...");
        return "success";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "测试")
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") Integer i) {
        if (i == 13) {
            throw new UserNameNotMatchPasswordException();
        }
        System.out.println("testResponseStatusExceptionResolver...");
        return "success";
    }

    /**
     * 在@ExceptionHandler方法的入参中可以加入Exception类型的参数，该参数即对应发生的异常对象
     * @ExceptionHandler方法的入参中不能传入Map,如希望把异常信息传导页面上，需要使用ModelAndView作为返回值
     * @ExceptionHandler方法标记的异常有优先级的问题
     *
     * @ControllerAdvice：如果在当前Handler中找不到@ExceptionHandler方法来处理当前方法出现的异常，则将去@ControllerAdvice
     * 标记的类中查找@ExceptionHandler标记的方法来处理异常
     * @param ex
     * @return
     */
//    @ExceptionHandler(value = {ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception ex) {
//        System.out.println("出异常了:" + ex);
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception", ex);
//        return mv;
//    }

    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
        System.out.println("result: " + (10 / i));
        return "success";
    }

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
