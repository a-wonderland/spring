package com.spring.wonderland.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.spring.wonderland.common.HelperFunction;
import com.spring.wonderland.persistent.Student;

/**
 * Implementor of StudentDAO which provided CRUD rules.
 * 
 * @author Alice
 */
public class StudentImpl implements StudentDAO {
	
	private DataSource data;

	public void setData(DataSource data) {
		this.data = data;
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "INSERT INTO student "
				+ "(firstName, lastName, course, fee, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		int status = 0;
		try {
			conn = data.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getCourse());
			ps.setFloat(4, student.getFee());
			ps.setDate(5,
					HelperFunction.convertToSqlDate(student.getStartDate()));
			ps.setDate(6, HelperFunction.convertToSqlDate(student.getEndDate()));

			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return status;
	}

	@Override
	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> retrieveStudentCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> retrieveStudentByCourse(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
