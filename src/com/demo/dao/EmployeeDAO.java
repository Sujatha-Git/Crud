package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
