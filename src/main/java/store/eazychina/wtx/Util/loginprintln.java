package store.eazychina.wtx.Util;

//@Component
//@Aspect
public class loginprintln {
//	@Pointcut("execution(public * store.eazychina.wtx.service..*.login(..))")
	public void myMethod(){
		
	}
//	@Before("myMethod()")
	public void before(){
		System.out.println("用户登录之前");
	}
//	@After("myMethod()")
	public void after(){
		System.out.println("用户登录之后");
		
	}
}
