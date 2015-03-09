package com.hibernate.wonderland.dao;

import java.util.List;

import org.springframework.orm.hibernate.HibernateTemplate;

import com.hibernate.wonderland.persistent.Student;

/**
 * This interface provided CRUD rules.
 * Implementor must be apply all rules.
 * 
 * @author Alice
 */

public interface StudentDAO {

	//public abstract HibernateTemplate getTemplate();

	//public abstract void setTemplate(HibernateTemplate template);
	/**
	 * Save Student object to database
	 * 
	 * @param student Student type
	 * @return inserting status whether success or not
	 */
	public abstract void insertStudent(Student student);

	/**
	 * Retrieve specific Student data according to unique id
	 * 
	 * @param id primary key of Student table
	 * @return all columns of specific student data
	 */
	public Student getStudentByID(int id);

	/**
	 * Retrieve list of Students data
	 * 
	 * @return all Student records
	 */

	public List<Student> retrieveStudentCollection();

	/**
	 * Retrieve specific list Student data according to course name
	 * 
	 * @param course
	 * @return all columns of specific student data joining same course
	 */
	public List<Student> retrieveStudentByCourse(String course);

	/**
	 * Update specific Student data according to unique id
	 * 
	 * @param id primary key of Student table
	 */
	public void updateStudent(Student student);

	/**
	 * Delete specific Student according to unique id
	 * 
	 * @param id primary key of Student table
	 * @return deleting status whether success or not
	 */
	public void deleteStudent(Student student);

}
