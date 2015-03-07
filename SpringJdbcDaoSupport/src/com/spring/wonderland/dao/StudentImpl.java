package com.spring.wonderland.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.spring.wonderland.persistent.Student;
import com.spring.wonderland.persistent.StudentRowMapper;

/**
 * Implementor of StudentDAO which provided CRUD rules.
 * 
 * @author Alice
 */
public class StudentImpl extends JdbcDaoSupport implements StudentDAO {

	@Override
	public int insertStudent(Student student) {
		String sql = "INSERT INTO STUDENT "
				+ "(firstName, lastName, course, fee, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?)";

		Object[] params = new Object[] { student.getFirstName(),
				student.getLastName(), student.getCourse(), student.getFee(),
				student.getStartDate(), student.getEndDate() };

		int status = getJdbcTemplate().update(sql, params);
		return status;
	}

	// a custom RowMapper

	@Override
	public Student getStudentByID(int id) {
		String sql = "SELECT * FROM STUDENT WHERE studentID = ?";
		Student student = (Student) getJdbcTemplate().queryForObject(sql,
				new Object[] { id }, new StudentRowMapper());
		return student;
	}

	// BeanPropertyRowMapper
	/*
	 * @Override public Student getStudentByID(int id) { String sql =
	 * "SELECT * FROM STUDENT WHERE studentID = ?"; Student student = (Student)
	 * getJdbcTemplate().queryForObject(sql, new Object[] { id }, new
	 * BeanPropertyRowMapper<Student>(Student.class)); return student;
	 * 
	 * }
	 */

	@Override
	public List<Student> retrieveStudentCollection() {
		String sql = "SELECT * FROM STUDENT";
		List<Student> studentList = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Student>(Student.class));
		// getJdbcTemplate().queryForList("select id from student", Long.class);
		return studentList;

	}

	@Override
	public List<Student> retrieveStudentByCourse(String course) {
		String query = "SELECT * FROM STUDENT WHERE course = ?";
		List<Student> studentList = getJdbcTemplate().query(query,
				new Object[] { course },
				new BeanPropertyRowMapper<Student>(Student.class));
		return studentList;

	}

	@Override
	public int updateStudent(Student student) {
		String query = "UPDATE student SET firstName=?, lastName=?, course=?, fee=?, startDate=?, endDate=? where studentID=?";
		Object[] params = new Object[] {student.getFirstName(), student.getLastName(), student.getCourse(), student.getFee(), student.getStartDate(), student.getEndDate(), student.getId()};
		int status = getJdbcTemplate().update(query, params);
		return status;
	}

	@Override
	public int deleteStudent(int id) {
		String query = "DELETE FROM student WHERE studentID=?";
		int status = getJdbcTemplate().update(query, id);
		return status;

	}

}
