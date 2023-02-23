package part01_xml;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 로직만 구현해 놓은 클래스 : Advice
public class AdviceCommon {
	public AdviceCommon() {
		
	}
	
	public void comm1() {
		System.out.println("before");
	}
	
	public void comm2() {
		System.out.println("after");
	}
	
	public void comm3(String name) {
		System.out.println("name:" + name);
	}
	 
	public void comm4(Exception ex) { //exception을 받기 위해 
		System.out.println("comm4:" + ex);
	}
	
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
