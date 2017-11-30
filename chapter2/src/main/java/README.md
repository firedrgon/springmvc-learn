# 常用注解
* @Controller
* @RequestMapping(value="",method=RequestMethod.POST,params={},headers={})
* @RequestMapping(value="/test/*/select"),支持*的查询方式
* @PathVariable
* HiddenHttpMethodFilter,把POST请求转换为DELETE,PUT请求,加个隐藏删除_method=PUT,DELETE
