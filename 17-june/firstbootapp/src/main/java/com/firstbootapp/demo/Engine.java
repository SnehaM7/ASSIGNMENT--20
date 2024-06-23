package com.firstbootapp.demo;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private int capacity;
	private int power;
	private int torque;
	public Engine() {
		capacity = 1300;
		power = 100;
		torque = 250;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getTorque() {
		return torque;
	}
	public void setTorque(int torque) {
		this.torque = torque;
	}
	@Override
	public String toString() {
		return "Engine [capacity=" + capacity + ", power=" + power + ", torque=" + torque + "]";
	}
	
}
