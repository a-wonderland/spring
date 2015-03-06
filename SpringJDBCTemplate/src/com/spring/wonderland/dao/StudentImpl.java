package com.spring.wonderland.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.wonderland.persistent.Student;
import com.spring.wonderland.persistent.StudentRowMapper;

/**
 * Implementor of StudentDAO which provided CRUD rules.
 * 
 * @author Alice
 */
public class StudentImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public int insertStudent(Student student) {
		String sql = "INSERT INTO STUDENT "
				+ "(firstName, lastName, course, fee, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?)";

		Object[] params = new Object[] { student.getFirstName(),
				student.getLastName(), student.getCourse(), student.getFee(),
				student.getStartDate(), student.getEndDate() };

		int status = jdbcTemplate.update(sql, params);
		return status;
	}

	//  a custom RowMapper
	@Override
	public Student getStudentByID(int id) {
		String sql = "SELECT * FROM STUDENT WHERE studentID = ?";
		Student student = (Student) getJdbcTemplate().queryForObject(sql, new Object[] { id }, new StudentRowMapper());
		return student;
	}

	/* BeanPropertyRowMapper
	 * @Override
	public Student getStudentByID(int id) {
		String sql = "SELECT * FROM STUDENT WHERE studentID = ?";
		return null;

	}*/
	
	@Override
	public List<Student> retrieveStudentCollection() {
		String query = "SELECT * FROM STUDENT";
		return null;

	}

	@Override
	public List<Student> retrieveStudentByCourse(String course) {
		String query = "SELECT * FROM STUDENT WHERE course = ?";
		return null;

	}

	@Override
	public int updateStudent(Student student) {
		String query = "UPDATE student SET firstName=?, lastName=?, course=?, fee=?, startDate=?, endDate=? where studentID=?";

		return 0;
	}

	@Override
	public int deleteStudent(int id) {
		String query = "DELETE FROM student WHERE studentID=?";

		return 0;

	}



}
