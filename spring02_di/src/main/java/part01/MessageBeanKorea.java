package part01;

public class MessageBeanKorea implements MessageBean{ 
	//implements -> interface 상속
	
	public MessageBeanKorea() {
		System.out.println("MessageBeanKorea");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("안녕, %s !!!\n", name);
		
	}
}//end class
