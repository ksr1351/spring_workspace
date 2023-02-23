package sample02;


public class HelloSpring {

	public static void main(String[] args) {
		MessageBean bean = null;
		//bean = new MessageBeanKorea();
		//display(bean, "스프링");
		
		bean = new MessageBeanEnglish();
		display(bean, "Spring");
	
	}//end main

	public static void display(MessageBean bean, String name) {
		bean.sayHello(name); 
		//MessageBeanEnglish() 인터페이스로 인해 결합도 낮춰져서 오류나지 않음
		
	} //end display()
	
}//end class
