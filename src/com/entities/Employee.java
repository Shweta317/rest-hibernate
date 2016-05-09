package com.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "employee", catalog = "Enviance")
@XmlRootElement(name = "employee")
public class Employee implements java.io.Serializable {

	static final long serialVersionUID = 1L;
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String designation;
	private String team;
	private Integer salary;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String designation, String team, Integer salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.team = team;
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Employee_Id", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "First_Name", length = 20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "Last_Name", length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "Designation", length = 20)
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "Team", length = 20)
	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Column(name = "Salary")
	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
