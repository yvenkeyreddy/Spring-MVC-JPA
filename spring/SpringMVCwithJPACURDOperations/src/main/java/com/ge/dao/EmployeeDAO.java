package com.ge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ge.entity.Employee;
import com.ge.utility.LoggerUtility;

@Repository
public class EmployeeDAO {

	Logger logger = null;

	@PersistenceContext
	private EntityManager entityManager;

	public EmployeeDAO() {
		logger = LoggerUtility.getLogger();
		logger.info("EmployeeDAO class object is created");
	}

	public void saveEmployee(Employee employee) {
		try {
			if (employee != null) {
				logger.trace("saveEmployee method executation started from DAO module");
				entityManager.persist(employee);
				logger.trace("saveEmployee method executation completed from DAO module");
			} else {
				logger.trace("saveEmployee method throws Exception due to object is null");
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("saveEmployee method throws Exception");
		}
	}

	public void updateEmployee(Employee employee) {
		try {
			if (employee != null) {
				logger.trace("updateEmployee method executation started from DAO module");
				Employee update = entityManager.find(Employee.class, employee.getEmployeeNumber());
				update.setEmployeeName(employee.getEmployeeName());
				update.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
				update.setEmployeeMail(employee.getEmployeeMail());
				update.setEmployeeSalary(employee.getEmployeeSalary());
				update.setEmployeeLocation(employee.getEmployeeLocation());
				logger.trace("updateEmployee method executation completed from DAO module");
			}
			logger.trace("updateEmployee method throws Exception due to object is null");
			throw new Exception();
		} catch (Exception e) {
			logger.error("updateEmployee method throws Exception");
		}
	}

	public void deleteEmployee(Integer employeeNumber) {
		try {
			if (employeeNumber != null) {
				logger.trace("deleteEmployee method executation started from DAO module");
				Employee delete = entityManager.find(Employee.class, employeeNumber);
				if (delete != null) {
					entityManager.remove(delete);
				}
				logger.trace("deleteEmployee method executation completed from DAO module");
			}
			logger.trace("deleteEmployee method throws Exception due to object is null");
			throw new Exception();
		} catch (Exception e) {
			logger.error("deleteEmployee method throws Exception");
		}
	}

	public Employee searchEmployee(Integer employeeNumber) {
		Employee employeeList = entityManager.find(Employee.class, employeeNumber);
		return employeeList;
	}

	public Employee editEmployee(Integer employeeNumber) {
		Employee employee = entityManager.find(Employee.class, employeeNumber);
		return employee;
	}

	public List<Employee> displayEmployees() {
		List<Employee> list = null;
		try {
			logger.trace("displayEmployees method executation started from DAO module");
			// String query = "select e from Employee e";
			TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findAll", Employee.class);
			list = typedQuery.getResultList();
			logger.trace("displayEmployees method executation completed from DAO module");
		} catch (Exception e) {
			logger.error("displayEmployees method throws Exception");
			e.printStackTrace();
		}
		return list;
	}
}
