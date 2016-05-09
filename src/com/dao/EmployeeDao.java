package com.dao;

import com.entities.Employee;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class EmployeeDao {

	public List<Employee> getEmployees() {
		List<Employee> employees = null;
		Session session = null;
		try {
			session = HibernateUtil.getSesssionFactory().openSession();
			session.beginTransaction();
			employees = session.createQuery("from Employee e ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employees;
	}

	public Employee getEmployeeById(int id) {
		Employee employee = null;
		Session session = null;
		try {
			session = HibernateUtil.getSesssionFactory().openSession();
			session.beginTransaction();
			employee = (Employee) session.createQuery("from Employee e where e.employeeId = :ID ")
					.setParameter("ID", id).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

	public List<Employee> getEmployeesByFirstName(String fName) {
		List<Employee> employees = null;
		Session session = null;
		try {
			session = HibernateUtil.getSesssionFactory().openSession();
			session.beginTransaction();
			employees = session.createQuery("from Employee e where e.firstName = :FNAME ").setParameter("FNAME", fName)
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employees;
	}
	
	public void addEmployee(Employee e) {
		Session session = null;
		try {
			session = HibernateUtil.getSesssionFactory().openSession();
			session.beginTransaction();
			session.save(e);
			session.getTransaction().commit();
		} catch (Exception ex) {
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
}
