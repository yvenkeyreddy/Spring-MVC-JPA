package com.ge.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ge.entity.Employee;
import com.ge.service.EmployeeService;

@Controller
public class EmployeeEditController {

	@Inject
	private EmployeeService employeeService;

	@RequestMapping(path = "/ueditemployee", method = RequestMethod.GET)
	public String deleteForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "EditForm";
	}

	@RequestMapping(path = "/ueditemployee", method = RequestMethod.POST)
	public String searchData(Model model, Integer employeeNumber) {
		if (employeeNumber != null) {
			Employee employeeData = employeeService.searchData(employeeNumber);
			model.addAttribute("employeeData", employeeData);
		} else {
			return "DeleteForm";
		}
		return "UpdateEditForm";
	}

	@RequestMapping(/*path = "/update",*/ method = RequestMethod.POST)
	public String updateData(@Valid Employee employee, BindingResult result) throws Exception {
		if (result.getErrorCount() > 0) {
			return "UpdateEditForm";
		} else {
			Employee employe = new Employee();
			employe.setEmployeeNumber(employee.getEmployeeNumber());
			employe.setEmployeeName(employee.getEmployeeName());
			employe.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
			employe.setEmployeeMail(employee.getEmployeeMail());
			employe.setEmployeeSalary(employee.getEmployeeSalary());
			employe.setEmployeeLocation(employee.getEmployeeLocation());
			employeeService.updateData(employe);
		}
		return "UpdateForm";
	}
}
