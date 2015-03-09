package com.hibernate.wonderland.persistent;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Serializable class.
 * 
 * @author Alice
 */
@Entity
@Table(name ="student")
public class Student implements Serializable{

	/**
	 * Explicitly declare a serialVersionUID
	 */
	private static final long serialVersionUID = -6659100867121902258L;

	/**
	 * Default constructor
	 */

	public Student() {
	}

	private int id;
	private String firstName;
	private String lastName;
	private String course;
	private float fee;
	private Date startDate;
	private Date endDate;

	@Id
	@GeneratedValue
	@Column (name = "studentID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column (name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column (name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column (name = "course")
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Column (name = "fee")
	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	@Column (name = "startDate")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column (name = "endDate")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Student class explicit constructor
	 */
	public Student(String firstName, String lastName, String course, float fee,
			Date startDate, Date endDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.fee = fee;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", course=" + course + ", fee=" + fee
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	
	

}
