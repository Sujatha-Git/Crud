package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.demo.beans.Employee;
import com.demo.exception.EmployeeNotFoundException;

public class EmployeeDAO {

	public int insertEmployee(Employee e) {
		int result =0;
		Connection con = DBConnection.getConnection();
		String insertQuery = "insert into employee values(?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(insertQuery);
			st.setInt(1, e.getId());
			st.setString(2, e.getName());
			st.setInt(3, e.getDid());
			st.setInt(4, e.getSalary());
			st.setInt(5, e.getMid());
			result = st.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
		
	}

	public Employee getEmployee(int eid) throws EmployeeNotFoundException  {
		Employee e = new Employee();
		Connection con = DBConnection.getConnection();
		String query = "select * from employee where id=?";
		boolean eFound = false;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,eid);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				eFound = true;
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(4));
				e.setDid(rs.getInt(3));
				e.setMid(rs.getInt(5));
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		if(!eFound)
			throw new EmployeeNotFoundException("EMPLOYEE NOT FOUND");
		return e;
	}

	public ArrayList<Employee> getAllEmployees() {
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection con = DBConnection.getConnection();
		String query = "select * from employee";
		try {
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDid(rs.getInt(3));
				e.setSalary(rs.getInt(4));
				e.setMid(rs.getInt(5));
				empList.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	public int updateEmployee(int eid, String ename) {
		Connection con = DBConnection.getConnection();
		String query = "update employee set name = ? where id = ?";
		int result = 0;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, ename);
			st.setInt(2, eid);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int deleteEmployee(int eid) {
		Connection con = DBConnection.getConnection();
		String query = "delete from employee where id = ?";
		int result =0;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, eid);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
