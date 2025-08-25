package com.example.ezen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		Car c = new Car();
		//개발자가 직접 제어
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");
		Car car = context.getBean(Car.class);
		//스프링이 대신 제어
		
		
		System.out.println(c); //개발자가 직접 호출한 Car타입 생성자
		System.out.println(car); //서버가 호출해주는 Car타입 생성자
		//제어의 역전(IOC)을 통해 Spring이 관리하는 bean객체 꺼내기(생성자 개발자가 직접 호출하지 않음)
		
		System.out.println(c.getName()); //null. 직접 호출한 생성자. 개발자가 값 넣은 적 없기 때문에 null.
		System.out.println(car.getName()); //"BMW" 스프링이 호출해준 생성자. root-context.xml에서 setName, setPlate로 값 넣었음.
	}

}
