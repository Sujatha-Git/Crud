/**
 * @author Prabhakar
 */
package com.demo.main;

import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.bo.EmployeeBO;
import com.demo.exception.EmployeeNotFoundException;
/*
 * Integrate Log4j
 * Integrate JUnit
 * Add JDBC Transactions
 * Convert To Maven Project
 * Git Push
 * 
 */
public class App {

	public static void main(String[] args) {
		System.out.println("What you want to do? ");
		System.out.println("1) Insert Employee");
		System.out.println("2) Get Employee");
		System.out.println("3) Update Employee Name");
		System.out.println("4) Delete Employee");
		System.out.println("5) Get all employees");
		Scanner sc= new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(input);
		switch(input) {
		case 1:
			insertEmployee(); break;
		case 2:
			getEmployee(); break;
		case 3:
			updateEmployee(); break;
		case 4:
			deleteEmployee(); break;
		case 5:
			getAllEmployees(); break;
		default:
			System.out.println("Invalid Option Selected.. Please select(1/2/3/4)");
		}

	}

	private static void getAllEmployees() {
		System.out.println("ALL EMPLOYEES LIST:");		
	}

	private static void deleteEmployee() {
		System.out.println("*DELETE EMPLOYEE STARTED***");
		
	}

	private static void updateEmployee() {
		System.out.println("*UPDATE EMPLOYEE STARTED***");	
	}

	private static void getEmployee() {
		System.out.println("*GET EMPLOYEE STARTED***");	
		System.out.println("Employee ID of which you want get details");
		Scanner sc = new Scanner(System.in);
		int eid = sc.nextInt();
		EmployeeBO eBO = new EmployeeBO();
		Employee e=null;
		try {
			e = eBO.getEmployee(eid);
			System.out.println(e);
		} catch (EmployeeNotFoundException e1) {
			System.err.println("Exception occured");
			System.out.println(e1);
		}
	}

	private static void insertEmployee() {
		System.out.println("*INSERT EMPLOYEE STARTED***");	
		Scanner sc= new Scanner(System.in);
		System.out.println("Employee ID:");
		int eid = sc.nextInt();
		System.out.println("Employee Name:");
		sc.nextLine();
		String ename= sc.nextLine();
		System.out.println("Employee Dept Id:");
		int did = sc.nextInt();
		System.out.println("Salary:");
		int salary = sc.nextInt();
		System.out.println("Manager ID:");
		int mid = sc.nextInt();
		Employee e = new Employee(eid, ename, did, salary, mid);
		EmployeeBO eBO = new EmployeeBO();
		int result = eBO.insertEmployee(e);
		if(result>0) 
			System.out.println(result+" records inserted");
		else
			System.out.println("no records inserted");
	}

}
