package com.demo.bo;

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

	
}
