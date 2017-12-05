###总结
* SpringMVC表单标签的使用(<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>)
* jstl标签的使用(<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>)
* 页面${pageContext.request.contextPath}
* SpringMVC处理静态资源<mvc:default-servlet-handler/>
* ModelAttributes的使用
* 数据绑定的流程：数据转换，数据格式化，数据校验(ModelAttributeMethodProcessor创建WebDataBinder)
* 自定义转换器:实现Converter<String,T>接口，在application.xml配置转换器ConvertServiceFactoryBean
  在<mvc:annotation-driven conversion-service=""></mvc:annotation-driven>添加conversionService
*






