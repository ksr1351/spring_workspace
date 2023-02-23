package part02_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //이 파일은 환경설정한 파일로 사용하겠다는 뜻
@EnableAspectJAutoProxy //클래스를 이용해서 환경설정을 잡으려면 해당 annotation같이 설정해줘야함
public class Config {
	
	//<bean id = "svc" class = "part02_annotation.ServiceImp"/>
	@Bean //xml에서 선언해둔 bean을 사용하려면 해당 annotation 이용
	public ServiceImp svc() {
		return new ServiceImp();
	}
	
	//<bean id = "common" class = "part02_annotation.AdviceCommon"/>
	@Bean
	public AdviceCommon common() {
		return new AdviceCommon();
	}
	
	//<bean id = "pn" class = "part02_annotation.ServiceImp"/>
	@Bean(name = "pn") //bean의 이름을 별도의 이름으로 쓸 때 / point를 이용하지 않고 bean id를 바꿈
	public ServiceImp point() {
		return new ServiceImp();
	}
	
}
