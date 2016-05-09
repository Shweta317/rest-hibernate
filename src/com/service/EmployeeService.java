package com.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.EmployeeDao;
import com.entities.Employee;

@Path("/employee")
public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	@GET
	@Path("/getEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {	
		return employeeDao.getEmployees();
	}
	
	@GET
	@Path("/getEmployeeById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id")int id) {	
		return employeeDao.getEmployeeById(id);
	}
	
	@GET
	@Path("/getEmployeesByFirstName/{fName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeesByFirstName(@PathParam("fName")String fName) {
		return employeeDao.getEmployeesByFirstName(fName);
	}
	
	@POST
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addEmployee(Employee e) {
		employeeDao.addEmployee(e);
	}
}
