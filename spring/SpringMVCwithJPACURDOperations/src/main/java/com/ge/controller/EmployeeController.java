package com.ge.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ge.entity.Employee;
import com.ge.service.EmployeeService;
import com.ge.utility.LoggerUtility;

@Controller
public class EmployeeController {

	Logger logger = null;

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		logger = LoggerUtility.getLogger();
		logger.info("EmployeeController class object is created");
	}

	@RequestMapping(path = "/newemployee", method = RequestMethod.GET)
	public String newForm(Model model) {
		logger.trace("newForm method executation started from controller module");
		model.addAttribute("employee", new Employee());
		logger.trace("newForm method executation completed from controller module");
		return "RegistrationForm";
	}

	@RequestMapping(path = "/newemployee", method = RequestMethod.POST)
	public String processForm(@Valid Employee employee, BindingResult result) {
		try {
			logger.trace("processForm method executation started from controller module");
			if (result.getFieldErrorCount() > 0) {
				logger.trace("processForm method executation completed with errors from controller module");
				return "RegistrationForm";
			} else {
				employeeService.saveData(employee);
			}
			logger.trace("processForm method executation completed from controller module");
			return "SuccessForm";
		} catch (Exception e) {
			return "RegistrationForm";
		}
	}

	@RequestMapping(path = "/updateemployee", method = RequestMethod.GET)
	public String updateForm(Model model) {
		logger.trace("newForm method executation started from controller module");
		model.addAttribute("employee", new Employee());
		logger.trace("newForm method executation completed from controller module");
		return "UpdateDetailsForm";
	}

	@RequestMapping(path = "/updateemployee", method = RequestMethod.POST)
	public String updateData(@Valid Employee employee, BindingResult result) throws Exception {
		try {
			logger.trace("updateData method executation started from controller module");
			if (result.getErrorCount() > 0) {
				logger.trace("updateData method executation completed with errors from controller module");
				return "RegistrationForm";
			} else {
				employeeService.updateData(employee);
			}
			logger.trace("updateData method executation completed from controller module");
			return "UpdateForm";
		} catch (Exception e) {
			return "RegistrationForm";
		}
	}

	@RequestMapping(path = "/editemployee", method = RequestMethod.GET)
	public String editForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "EditForm";
	}

	@RequestMapping(path = "/editemployee", method = RequestMethod.POST)
	public String editData(@Valid Employee employee, Model model, Integer employeeNumber) {
		if (employeeNumber != null) {
			Employee employeeData = employeeService.searchData(employeeNumber);
			model.addAttribute("employeeData", employeeData);
		} else {
			return "EditForm";
		}
		return "UpdateEditForm";
	}

	@RequestMapping(path = { "/deleteemployee", "/searchemployee" }, method = RequestMethod.GET)
	public String deleteForm(Model model) {
		logger.trace("deleteForm method executation started from controller module");
		model.addAttribute("employee", new Employee());
		logger.trace("deleteForm method executation completed from controller module");
		return "DeleteForm";
	}

	@RequestMapping(path = "/deleteemployee", method = RequestMethod.POST)
	public String deleteData(@Valid Employee employee, BindingResult result) {
		try {
			logger.trace("deleteData method executation started from controller module");
			if (employee != null) {
				employeeService.deleteData(employee.getEmployeeNumber());
			} else {
				logger.trace("deleteData method executation completed with errors from controller module");
				return "DeleteForm";
			}
			logger.trace("deleteData method executation completed from controller module");
			return "DeleteSuccessForm";
		} catch (Exception e) {
			return "DeleteForm";
		}

	}

	@RequestMapping(path = "/searchemployee", method = RequestMethod.POST)
	public String searchData(Model model, Integer employeeNumber) {
		try {
			if (employeeNumber != null) {
				Employee employeeData = employeeService.searchData(employeeNumber);
				model.addAttribute("employeeData", employeeData);
			} else {
				logger.trace("searchData method executation completed with errors from controller module");
				return "DeleteForm";
			}
			return "SearchEmployee";
		} catch (Exception e) {
			return "DeleteForm";
		}
	}

	@RequestMapping(path = "/allemployees", method = RequestMethod.GET)
	public String retrieveData(Model model) {
		logger.trace("retrieveData method executation started from controller module");
		List<Employee> employee = employeeService.displayData();
		model.addAttribute("employee", employee);
		logger.trace("retrieveData method executation completed from controller module");
		return "EmployeeList";
	}

}
