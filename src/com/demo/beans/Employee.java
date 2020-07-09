package com.demo.beans;

public class Employee {

	int id;
	String name;
	int did;
	int salary;
	int mid;
	public Employee(int id, String name, int did, int salary, int mid) {
		super();
		this.id = id;
		this.name = name;
		this.did = did;
		this.salary = salary;
		this.mid = mid;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", did=" + did + ", salary=" + salary + ", mid=" + mid + "]";
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
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
}
