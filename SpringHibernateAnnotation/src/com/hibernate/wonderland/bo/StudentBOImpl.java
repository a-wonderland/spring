package com.hibernate.wonderland.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.wonderland.dao.StudentDAO;
import com.hibernate.wonderland.persistent.Student;

/**
 * Implementor of StudentDAO which provided CRUD rules.
 * 
 * @author Alice
 */
@Service("StudentBO")
public class StudentBOImpl implements StudentBO {

	@Autowired
	StudentDAO studentDAO;

	/**
	 * Default no-argument constructor
	 */

	public StudentBOImpl() {
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void insertStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudentByID(int id) {

		return studentDAO.getStudentByID(id);
	}

	@Override
	public List<Student> retrieveStudentCollection() {

		return studentDAO.retrieveStudentCollection();
	}

	@Override
	public List<Student> retrieveStudentByCourse(String course) {
		return studentDAO.retrieveStudentByCourse(course);
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);

	}

	@Override
	public void deleteStudent(Student student) {
		studentDAO.deleteStudent(student);

	}

}
