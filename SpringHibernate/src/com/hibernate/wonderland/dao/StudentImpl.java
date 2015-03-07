package com.hibernate.wonderland.dao;

import java.util.ArrayList;
import java.util.List;



import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.wonderland.persistent.Student;

/**
 * Implementor of StudentDAO which provided CRUD rules.
 * 
 * @author Alice
 */
public class StudentImpl extends HibernateDaoSupport implements StudentDAO {

	/**
	 * Default no-argument constructor
	 */

	public StudentImpl() {
	}

	@Override
	public void insertStudent(Student student) {
		getHibernateTemplate().save(student);

	}

	@Override
	public Student getStudentByID(int id) {

		Student student = (Student) getHibernateTemplate().get(Student.class,
				id);
		return student;
	}

	@Override
	public List<Student> retrieveStudentCollection() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = getHibernateTemplate().loadAll(Student.class);
		return studentList;
	}

	/**
	 * This method query data by HQL approach
	 */
	@Override
	public List<Student> retrieveStudentByCourse(String course) {
		List<Student> studentList = new ArrayList<Student>();
		studentList = getHibernateTemplate().find(
				"From Student Where course=?", course);
		return studentList;

	}

	@Override
	public void updateStudent(Student studentparam) {
		getHibernateTemplate().update(studentparam);
	}

	@Override
	public void deleteStudent(Student studentparam) {
		getHibernateTemplate().delete(studentparam);

	}

}
