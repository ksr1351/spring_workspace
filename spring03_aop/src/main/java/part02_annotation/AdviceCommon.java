package part02_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//공통 로직만 구현해 놓은 클래스 : Advice

@Aspect
public class AdviceCommon {
	public AdviceCommon() {
		
	}
	
	@Before(value="execution(* part02_annotation.ServiceImp.prn1(..))") //before도 annotation패키지임 꼭 선언해줘야함
	public void comm1() {
		System.out.println("before");
	}
	
	@After(value="execution(* part02_annotation.ServiceImp.prn2(..))")
	public void comm2() {
		System.out.println("after");
	}
	@AfterReturning(value="execution(* part02_annotation.ServiceImp.prn3(..))", returning = "name")
	public void comm3(String name) {
		System.out.println("name:" + name);
	}
	 
	@AfterThrowing(value="execution(* part02_annotation.ServiceImp.prn4(..))", throwing = "ex")
	public void comm4(Exception ex) { //exception을 받기 위해 
		System.out.println("comm4:" + ex);
	}
	
	@Around(value="execution(* part02_annotation.ServiceImp.prn5(..))")
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("comm5 start"); //공통로직 먼저 실행
			try {
				point.proceed();//이 구문을 만나면 핵심로직 실행
			} catch (Throwable e) {
				e.printStackTrace();
			}
		System.out.println("comm5 end"); //핵심로직 이후에 공통로직 또 실행
	}
}
