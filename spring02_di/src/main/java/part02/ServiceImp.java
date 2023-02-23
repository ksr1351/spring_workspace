package part02;

import java.util.Random;

public class ServiceImp implements Service {
	private String name;
	private int age;
	private Random ran;

	public ServiceImp() {

	}//권장사항

	public ServiceImp(String name) {
		this.name = name; // 인자값을 가진 생성자
	}
	
	public ServiceImp(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public ServiceImp(Random ran) {
		this.ran = ran;
	}
	
	@Override
	public void prn1() {
		System.out.printf("name: %s\n", name);

	}

	@Override
	public void prn2() {
		System.out.printf("name: %s, age: %d\n", name, age);
	}

	@Override
	public void prn3() {
		System.out.printf("ran : %f\n", ran.nextDouble()); //ran은 객체, 실수로 출력위해 double
	}

}// end class
