package com.ge.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.EmployeeDAO;
import com.ge.entity.Employee;
import com.ge.utility.LoggerUtility;

@Service
public class EmployeeService {

	Logger logger = null;
	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeService() {
		logger = LoggerUtility.getLogger();
		logger.info("EmployeeService class object created");
	}

	@Transactional(value = TxType.REQUIRED)
	public void saveData(Employee employee) {
		try {
			if (employee != null) {
				logger.trace("saveData method executation started from services module");
				employeeDAO.saveEmployee(employee);
				logger.trace("saveData method executation completed from services module");
			} else {
				logger.trace("saveData method throws Exception due to object is null");
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("saveData method throws Exception" + e.toString());
		}
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateData(Employee employee) {
		try {
			if (employee != null) {
				logger.trace("updateData method executation started from services module");
				employeeDAO.updateEmployee(employee);
				logger.trace("updateData method executation completed from services module");
			} else {
				logger.trace("updateData method throws Exception due to object is null");
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("updateData method throws Exception" + e.toString());
		}
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void deleteData(Integer employeeNumber) {
		try {
			if (employeeNumber != null) {
				logger.trace("deleteData method executation started from services module");
				if (employeeNumber != null) {
					employeeDAO.deleteEmployee(employeeNumber);
				}
				logger.trace("deleteData method executation completed from services module");
			} else {
				logger.trace("deleteData method throws Exception due to employeeNumber is null");
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("deleteData method throws Exception" + e.toString());
		}

	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public Employee searchData(Integer employeeNumber) {
		Employee searchEmployee = null;
		try {
			logger.trace("searchData method executation started from services module");
			if (employeeNumber != null) {
				searchEmployee = employeeDAO.searchEmployee(employeeNumber);
				logger.trace("searchData method executation completed from services module");
				return searchEmployee;
			} else {
				logger.trace("deleteData method throws Exception due to employeeNumber is null");
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("deleteData method throws Exception" + e.toString());
		}
		return searchEmployee;
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public Employee editData(Integer employeeNumber) {
		Employee editEmployee = null;
		if (employeeNumber != null) {
			editEmployee = employeeDAO.editEmployee(employeeNumber);
			return editEmployee;
		}
		return editEmployee;
	}

	@Transactional(value = TxType.REQUIRED)
	public List<Employee> displayData() {
		List<Employee> employees = null;
		try {
			logger.trace("displayData method executation started from services module");
			employees = employeeDAO.displayEmployees();
			logger.trace("displayData method executation completed from services module");
			return employees;
		} catch (Exception e) {
			logger.error("displayData method throws Exception" + e.toString());
		}
		return employees;
	}
}
