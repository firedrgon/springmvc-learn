# 常用注解
* @Controller
* @RequestMapping(value="",method=RequestMethod.POST,params={},headers={})
* @RequestMapping(value="/test/*/select"),支持*的查询方式
* @PathVariable
* HiddenHttpMethodFilter,把POST请求转换为DELETE,PUT请求,加个隐藏删除_method=PUT,DELETE
* @RequestParam,绑定请求参数
* @RequestHeader,绑定请求头
* @CookieValue,绑定cookie的值
* 使用POJO作为参数
* 使用HttpServletRequest,HttpServletResponse,HttpSession作为参数
* 使用ModelAndView作为返回值，设置视图，和模型数据
* 使用Map<String,Object>，或Model把模型数据返回到视图
* @SessionAttributes注解表示把模型数据同时会放入session域中，该注解只能放在类上，可以明确属性名称，或属性类型
* @ModelAttribute修饰的方法，会被每个目标方法调用之前被SpringMVC调用,把页面传入的属性，和@ModelAttributes注释放入的属性赋值后，放入implicitModel
* SpringMVC目标方法入参：把POJO放入implicitModel，进而放入request域中（页面把参数传递给WebDataBinder 的 target 对应的属性.SpringMVC 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel）
* 视图解析器：InternalResourceViewResolver
* 国际化资源文件i18n,配置ResourceBundleMessageSource,引入jstl包，在JSP页面上使用fmt标签库
* 自定义视图：定义视图实现View，在xml定义BeanNameViewResolver,通过bean名称解析视图
* 转发，重定向：forward,redirect,
































