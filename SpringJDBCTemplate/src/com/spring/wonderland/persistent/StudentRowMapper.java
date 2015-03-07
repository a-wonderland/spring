package com.spring.wonderland.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Implement the RowMapper interface to create a custom RowMapper. Query or extract data from database
 * 
 * @author Alice
 */

public class StudentRowMapper implements RowMapper<Object>{

	/**
	 * Default constructor
	 */

	public StudentRowMapper(){
	}

	/**
	 * This method will be pass in queryForObject() method.
	 * the returned result will call custom mapRow() method to match the value into the properly.
	 * RowMapper is not supported for list query.
	 */
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("studentID"));
		student.setFirstName(rs.getString("firstName"));
		student.setLastName(rs.getString("lastName"));
		student.setCourse(rs.getString("course"));
		student.setFee(rs.getFloat("fee"));
		student.setStartDate(rs.getDate("startDate"));
		student.setEndDate(rs.getDate("endDate"));
		
		return student;
	}
	
}
