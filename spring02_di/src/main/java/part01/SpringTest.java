package part01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * IoC(Inversion of Control 제어의 역전)
 * 객체생성이나 메소드 호출을 개발자가 직접하는 것이 아니라, 스프링 프레임워크에게 제어권을 넘기는 기능이다.
 * 대부분은 프레임워크에서 IoC를 적용하고 있다.
 * 
 * 
 * DI(Dependency Injection 의존성 주입)
 * 1. 객체를 직접 생성하지 않고 외부에서 생성된 객체를 주입받아 이용하는 기능이다.
 * 2. DI는 컨테이너를 통해 서로 강하게 결합되어 있는 두 클래스를 분리하고 두 객체간의 관계를 결정해 줌으로써 
 * 	  결합도를 낮추고 유연성 확보를 하기 위해서다.
 */

public class SpringTest {

	public static void main(String[] args) {

		// ApplicationContext(container) : Bean의 라이프 사이클을 관리해주는 컨테이너이다.
		// di에서 생성한 bean(객체)가 넘어옴 /ApplicationContext에서 bean의 cycle을 관리 해줌
		// messagebeankorea를 직접 호출하지 않아도 해당 파일에 구현된 값이 출력됨
		String path = "part01/di.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);

		//결합도를 낮추기 위해서 interface 상속받아서 구현
		MessageBean bean = (MessageBean)context.getBean("mb");
		// display(bean,"스프링");
		display(bean, "Spring");
		
	}// end main()

	public static void display(MessageBean bean, String name) {
		bean.sayHello(name);
	}//end display()
	
}// end class
