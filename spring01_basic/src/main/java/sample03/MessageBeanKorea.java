package sample03;

public class MessageBeanKorea implements MessageBean{ 
	//implements -> interface 상속
	
	public MessageBeanKorea() {

	}

	@Override
	public void sayHello(String name) {
		System.out.printf("안녕, %s !!!\n", name);
		
	}
}//end class
