package com.tuananh.controller.admin.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuananh.model.EmployeeModel;
import com.tuananh.service.IDepartmentService;
import com.tuananh.service.IEmployeeService;
import com.tuananh.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-employee"})
public class EmployeeAPI extends HttpServlet{
	private static final long serialVersionUID = -7167694688161642839L;
	
	@Inject
	private IEmployeeService employeeService;
	
	@Inject
	private IDepartmentService departmentService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
			List<EmployeeModel> list = employeeService.findTop3();		
			PrintWriter out = resp.getWriter();
			for (EmployeeModel o : list) {
				out.println("<tr>\r\n" + 
						"												<td><input type=\"checkbox\" value=\""+ o.getId() +"\"></td>\r\n" + 
						"												<td>"+ o.getName() +"</td>\r\n" + 
						"												<td>"+ o.getContact() +"</td>\r\n" + 
						"												<td>\r\n" + 
						"												<a class=\"btn btn-sm btn-primary btn-edit\" data-toggle=\"tooltip\"\r\n" + 
						"												  title=\"Cập nhật nhân viên\" href='#'><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i>\r\n" + 
						"												</a>\r\n" + 
						"												</td>\r\n" + 
						"											</tr>");
			}
		
	}
	
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
