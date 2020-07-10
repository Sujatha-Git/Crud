package com.demo.bo;

import java.util.ArrayList;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDAO;
import com.demo.exception.EmployeeNotFoundException;

public class EmployeeBO {
	public int insertEmployee(Employee e) {
	// business logic goes here....
	EmployeeDAO eDAO = new EmployeeDAO();
	return eDAO.insertEmployee(e);
		
	}

	public Employee getEmployee(int eid) throws EmployeeNotFoundException {
		EmployeeDAO eDAO = new EmployeeDAO();
		return eDAO.getEmployee(eid);
	}

	public ArrayList<Employee> getAllEmployees() {
		EmployeeDAO eDAO = new EmployeeDAO();
		
		return eDAO.getAllEmployees();
	}

	public int updateEmployee(int eid, String ename) {
		EmployeeDAO eDAO = new EmployeeDAO();
		return eDAO.updateEmployee(eid, ename);
	}

	public int deleteEmployee(int eid) {
		EmployeeDAO eDAO = new EmployeeDAO();
		return eDAO.deleteEmployee(eid);
	}

	
}
