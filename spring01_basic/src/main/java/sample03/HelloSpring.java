package sample03;

/*
 * factory를 이용하면 결합도는 인터페이스보다 낮지만 
 * factory가 정확히 구현되어 있지 않으면 참조하는 객체에 영향이 간다. 
 */

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean bean = null;
//		bean = MessageFactory.getInstance("ko"); //직접 객체 생성 안하고 넘겨주기
//		display(bean,"스프링");

		bean = MessageFactory.getInstance("en");
		display(bean, "Spring");

		// 상단에서 참조하는 객체 내에서 직접적으로 객체 생성하는 것은 없음
		// factory에서 잘 못 구현된다면 문제 발생(factory이용하는 방법은)
	
	}

	public static void display(MessageBean bean, String name) {
		bean.sayHello(name);
	}// end display()
}
