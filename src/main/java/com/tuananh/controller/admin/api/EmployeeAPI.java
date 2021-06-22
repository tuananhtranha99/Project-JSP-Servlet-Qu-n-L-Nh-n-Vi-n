package com.tuananh.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuananh.model.EmployeeModel;
import com.tuananh.service.IEmployeeService;
import com.tuananh.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-employee"})
public class EmployeeAPI extends HttpServlet{
	private static final long serialVersionUID = -7167694688161642839L;
	
	@Inject
	private IEmployeeService employeeService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		EmployeeModel employee = HttpUtil.of(req.getReader()).toModel(EmployeeModel.class);
		employee = employeeService.save(employee);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), employee);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		EmployeeModel updateEmployee = HttpUtil.of(req.getReader()).toModel(EmployeeModel.class);
		updateEmployee = employeeService.update(updateEmployee);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), updateEmployee);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		EmployeeModel employee = HttpUtil.of(req.getReader()).toModel(EmployeeModel.class);
		employeeService.delete(employee.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
	

	

}
