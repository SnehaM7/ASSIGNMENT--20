package com.example.springannotationsdemo;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
	public void run() {
		System.out.println("Bike is running....");
	}
}
