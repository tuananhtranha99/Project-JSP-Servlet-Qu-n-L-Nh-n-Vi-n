package com.tuananh.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuananh.constant.SystemConstant;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.PageRequest;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IEmployeeService;
import com.tuananh.sort.Sorter;
import com.tuananh.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-employee"})
public class EmployeeController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Inject
	private IEmployeeService employeeService; 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeModel model = FormUtil.toModel(EmployeeModel.class, req);

		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortBy()));
		
		model.setListResult(employeeService.findAll(pageble));
		model.setTotalItem(employeeService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem()/model.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/employee/list.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	
}
