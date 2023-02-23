package part03_exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StopWatchAdvice {
	public StopWatchAdvice() {
		
	}
	
	@Around(value="execution(* part03_exam.ServiceImp.prn(..))")
	public void process(ProceedingJoinPoint point) {
		long start = System.currentTimeMillis();
		
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		long end = System.currentTimeMillis();//end에서 start를 빼면 serviceimp 의 prn처리시간이 출력됨
		
		String time = String.format("%s__메서드 실행시간:%d\n", point.getSignature().getName(),(end-start));
		System.out.println(time);
	}
}
