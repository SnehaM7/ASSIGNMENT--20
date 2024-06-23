package com.firstbootapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstbootappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstbootappApplication.class, args);
		System.out.println("Hello world");
//		Department dept = context.getBean(Department.class);
//		dept.setId(101);
//		dept.setName("Sales");
//		dept.setBlock("A");
//		System.out.println(dept);
//		Department dept1 = context.getBean(Department.class);
//		dept1.setId(102);
//		dept1.setName("IT");
//		dept1.setBlock("B");
//		System.out.println(dept1);
		Car c = context.getBean(Car.class);
		c.setBrand("Maruti suzuki");
		c.setName("swift");
		c.run();
	}

}
