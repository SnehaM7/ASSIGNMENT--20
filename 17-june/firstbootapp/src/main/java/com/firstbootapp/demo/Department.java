package com.firstbootapp.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Department {
	private int id;
	private String name;
	private String block;
	public Department() {
		System.out.println("Object created...!");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", block=" + block + "]";
	}
	
	
}
