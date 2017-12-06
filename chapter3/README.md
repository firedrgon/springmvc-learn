###总结
* SpringMVC表单标签的使用(<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>)
* jstl标签的使用(<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>)
* 页面${pageContext.request.contextPath}
* SpringMVC处理静态资源<mvc:default-servlet-handler/>
* ModelAttributes的使用
* 数据绑定的流程：数据转换，数据格式化，数据校验(ModelAttributeMethodProcessor创建WebDataBinder)
* 自定义转换器:实现Converter<String,T>接口，在application.xml配置转换器ConvertServiceFactoryBean
  在<mvc:annotation-driven conversion-service=""></mvc:annotation-driven>添加conversionService
* <mvc:annotation-driven/>:自动注册RequestMappingHandlerMapping,RequestMappingHandlerAdapter,ExceptionHandlerExceptionResolver三个bean
* @InitBinder标识的方法，可以对WebDataBinder对象进行初始化。WebDataBinder是DataBinder的子类，用于完成由表单字段到JavaBean属性的绑定
* @InitBinder方法不能有返回值，它必须声明为void
* @InitBinder方法的参数通常是WebDataBinder
* 数据的格式化:@NumberFormat(pattern=""),@DateTimeFormat(pattern="")
* BindingResult数据转换和绑定的错误结果
* 数据校验：JSR303标准，hibernate validator
 1.使用JSR 303验证标准
 2.加入hibernate validator验证框架的jar包
 3.在SpringMVC配置文件中加入<mvc:annotation-driven/>
 4.需要在Bean的属性上添加对应的注解
 5.在目标方法bean类型的前面添加@Valid注解
* <form:error path=""/>数据校验错误提示信息
* SpringMVC处理JSON（jackson包，@ResponseBody），使用HttpMessageConverter
* 使用两种方式入参和返回值1)@requestBody,@ResponseBody.2)RequestEntity,ResponseEntity
* 国际化:1.在页面上显示国际化语言。2.在代码获取多语言信息。3.通过超链接改变Locale
* 通过超链接改变语言:添加SessionLocaleResolver Bean,添加LocaleChangeInterceptor拦截器

###学习笔记
* 文件上传，添加Bean:CommonsMultipartResolver和commons-io,commons-fileupload包
* MultipartFile,multipart/form-data
* 拦截器的配置:实现HandlerInterceptor接口，在application.xml配置拦截器

























