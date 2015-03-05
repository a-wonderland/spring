package com.spring.wonderland.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.spring.wonderland.common.Constant;
import com.spring.wonderland.common.HelperFunction;
import com.spring.wonderland.persistent.Student;

/**
 * Implementor of StudentDAO which provided CRUD rules.
 * 
 * @author Alice
 */
public class StudentImpl implements StudentDAO {

	private DataSource data;

	/*
	 * public void setData(DataSource data) { this.data = data; }
	 */
	@Override
	public void setDataSource(DataSource data) {
		this.data = data;

	}

	@Override
	public int insertStudent(Student student) {
		String sql = "INSERT INTO STUDENT "
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
		String sql = "SELECT * FROM STUDENT WHERE studentID = ?";

		Connection conn = null;

		try {
			conn = data.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Student student = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("course"),
						rs.getFloat("fee"), rs.getDate("startDate"),
						rs.getDate("endDate"));
			}
			rs.close();
			ps.close();

			return student;

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
	}

	@Override
	public List<Student> retrieveStudentCollection() {
		String query = "SELECT * FROM STUDENT";

		List<Student> stdList = new ArrayList<Student>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = data.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student(rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("course"),
						rs.getFloat("fee"), rs.getDate("startDate"),
						rs.getDate("endDate"));
				stdList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stdList;
	}

	@Override
	public List<Student> retrieveStudentByCourse(String course) {
		String query = "SELECT * FROM STUDENT WHERE course = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> stdList = new ArrayList<Student>();

		try {

			con = data.getConnection();

			ps = con.prepareStatement(query);
			ps.setString(1, course);
			rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student(rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("course"),
						rs.getFloat("fee"), rs.getDate("startDate"),
						rs.getDate("endDate"));
				stdList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stdList;
	}

	@Override
	public int updateStudent(Student student) {
		String query = "UPDATE student SET firstName=?, lastName=?, course=?, fee=?, startDate=?, endDate=? where studentID=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = data.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getCourse());
			ps.setFloat(4, student.getFee());
			ps.setDate(5,
					HelperFunction.convertToSqlDate(student.getStartDate()));
			ps.setDate(6, HelperFunction.convertToSqlDate(student.getEndDate()));
			ps.setInt(7, student.getId());

			int status = ps.executeUpdate();
			if (status != 0) {
				return Constant.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Constant.UNSUCCESS;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteStudent(int id) {
		String query = "DELETE FROM student WHERE studentID=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = data.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int status = ps.executeUpdate();
			if (status != 0) {
				return Constant.SUCCESS;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return Constant.UNSUCCESS;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

}
