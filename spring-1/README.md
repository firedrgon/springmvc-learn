##总结
* ClassPathXmlApplicationContext加载Spring IOC容器
* IOC(控制反转),DI(依赖注入)
  `IOC:其思想是反转资源获取的方式。传统的资源查找方式要求组件向容器发起请求查找资源
  .作为回应，容器适时的返回资源.而应用了IOC之后，则是容器主动将资源推送给它所管理的组件，
  组件所要做的仅是选择一种合适的方式来接受资源。这种行为也被称为查找的被动形式。
  DI--IOC的另一种表述方式：即组件以一些预先定义好的方式(例如：setter方法)接受来自如容器的资源
  注入。相对应IOC而言，这种表述更直接`
* 依赖注入的两种方式:属性方式(setter)，构造器方式(constructor-arg:value,type,index,ref)
* 集合属性(list,set,map,properties,value,ref)
* 自动装配：在<bean>的autowire定义装配的类型ByType,ByName
  `可以使用autowire属性指定自动装配的方式，
  byName：根据bean的名字和当前bean的setter风格的属性名进行，自动装配，若有匹配的，则进行自动装配，若没有匹配，则不装配
  byType:根据bean的类型和当前bean的属性的类型进行自动装配`
* Bean之间的关系
  `bean配置继承，使用bean的parent属性指定继承那个bean的配置
   抽象bean,bean的abstract属性为true的bean，这样的bean不能被IOC容器实例化，只用来被继承配置，若某一个bean的class属性没有指定，则该bean必须是一个abstract bean
   要求再配置Bean时，必须有一个关联的car，换句话说bean必须依赖于另一个bean，使用depends-on属性`
* Bean的作用域
 `使用bean的scope属性来配置bean的作用域
  singleton:默认值，容器初始时创建bean实例，在整个容器的生命周期中只创建一个bean,单例的
  prototype：原型的，容器初始化是不创建bean的实例，而在每次请求是都创建一个新的bean实例，并返回
  request:
  session:`
* Spring使用外部属性配置文件
  `<context:property-placeholder location="classpath:db.properties"/>`
* Spring表达式语言SpEl
  `使用方式#{},字面值:#{'BeiJing'}
   使用SpEl引用类的静态属性：#{T(java.lang.Math).PI * 80}
   使用SpEl引用其他的Bean:#{car}
   使用SpEl引用其他类的属性:#{address.city}
   使用SpEl条件判断：#{car.price > 1000 ? 1: 0}`
* Spring中的Bean的生命周期
  `bean的初始化方法属性:init-method(容器启动执行的方法),bean的销毁方法属性：destroy-method(容器关闭执行的方法)
   bean的后置处理器:实现BeanPostProcessor接口。。
   Spring IOC容器对Bean的生命周期进行管理的过程:
   通过构造器或工厂方法创建Bean实例，
   为Bean的属性设置值和对其他Bean的引用
   将Bean实例传递给Bean后置处理器的PostProcessorBeforeInitialization
   调用Bean的初始化方法
   将Bean实例传递给Bean后置处理器的PostProcessorAfterInitailization
   Bean可以使用了
   当容器关闭时，调用Bean的销毁方法`
* 通过静态工厂方法来配置bean，通过实例工厂方法创建bean(factory-bean,factory-method,constructor-arg)
* 通过FactoryBean配置Bean，实现FactoryBean接口
* 通过注解配置bean：
   <context:component-scan base-package="com.ypvoid" use-default-filters="true">
   		<!--<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"></context:exclude-filter>-->
   		<context:include-filter type="annotation" expression="org.springframework.stereotype.Component"></context:include-filter>
   	</context:component-scan>
   @Component,基本注解，标识了一个受Spring管理的类，@Repository,持久层类，@Service服务层类，@Controller控制层的类
* @Autowired,@Qualifier,@Resource
* 泛型依赖注入:http://blog.csdn.net/u010837612/article/details/45582043
* Spring AOP
































