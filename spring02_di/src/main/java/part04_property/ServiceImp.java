package part04_property;

import java.util.Random;

public class ServiceImp implements Service { // service interface를 상속받을 class
	private String name;
	private Random ran;

	public ServiceImp() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRan(Random ran) {
		this.ran = ran;
	}

	@Override
	public void prn1() {
		System.out.printf("name : %s\n", name);
	}

	@Override
	public void prn2() {
		System.out.printf("ran:%f\n", ran.nextDouble());
	}

}// end class
