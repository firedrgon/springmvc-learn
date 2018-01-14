##Spring AOP
* 动态代理模式(InvocationHandler)
* AspectJ,AOP框架，加入AspectJ包，aspectjrt,aspectjweaver,cglib
* 我们可以使用动态代理实现AOP，可以使用AspectJ自动代理
* 声明切面:@Aspect(切面),@Pointcut(切点),@JoinPoint(连接点),@Before(前置通知),
  @After(后置通知),@AfterReturning(后置返回通知),@AfterThrowing(后置异常通知)
* 配置AOP自动代理:<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
* execution(public * com.ypvoid..*.*(..)),public修饰符，*任意返回值，com.ypvoid包下任意类的任意方法，(..)方法的任意参数
* 环绕通知@Around需要携带参数ProceedingJoinPoint
* 使用@Order(1)指定切面的优先级
* 上面是基于注解的AOP，下面介绍基于XML的AOP
* <aop:config></aop:config>,<aop:aspect></aop:aspect>,<aop:pointcut></aop:pointcut>
* 切面，切点，通知
* JdbcTemplate，JdbcDaoSupport



















