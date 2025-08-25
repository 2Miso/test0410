package com.example.ezen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		Car c = new Car();
		//�����ڰ� ���� ����
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");
		Car car = context.getBean(Car.class);
		//�������� ��� ����
		
		
		System.out.println(c); //�����ڰ� ���� ȣ���� CarŸ�� ������
		System.out.println(car); //������ ȣ�����ִ� CarŸ�� ������
		//������ ����(IOC)�� ���� Spring�� �����ϴ� bean��ü ������(������ �����ڰ� ���� ȣ������ ����)
		
		System.out.println(c.getName()); //null. ���� ȣ���� ������. �����ڰ� �� ���� �� ���� ������ null.
		System.out.println(car.getName()); //"BMW" �������� ȣ������ ������. root-context.xml���� setName, setPlate�� �� �־���.
	}

}
