package com.tuananh.controller.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuananh.constant.SystemConstant;
import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.PageRequest;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IDepartmentService;
import com.tuananh.service.IEmployeeService;
import com.tuananh.sort.Sorter;
import com.tuananh.utils.FormUtil;
import com.tuananh.utils.HttpUtil;
import com.tuananh.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-employee-edit" })
public class EmployeeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IEmployeeService employeeService;

	@Inject
	private IDepartmentService departmentService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeModel model = FormUtil.toModel(EmployeeModel.class, req);
		String view = "/views/admin/employee/edit.jsp";
		List<DepartmentModel> allDepartment = departmentService.findAll(); // lấy ra tất cả department
		if (model.getId() != null) {
			model = employeeService.findOne(model.getId());
			List<DepartmentModel> departmentChecked = departmentService.findByEmployeeId(model.getId()); // lấy ra tất cả department mà employee này tham gia
			
			// thực hiện kiểm tra department nào mà employee có tham gia thì department đó sẽ được check để thể hiện là đã tham gia
			if (departmentChecked != null) {
				if (allDepartment.size() == departmentChecked.size()) {
					for (DepartmentModel dep : allDepartment) {
						dep.setCheck("checked");
					}
				} else {
					allDepartment.removeAll(departmentChecked);
					for (DepartmentModel dep : departmentChecked) {
						dep.setCheck("checked");

					}
					allDepartment.addAll(departmentChecked);
					Collections.sort(allDepartment);
				}
			}
			model.setDepartmentIds(departmentChecked);
		}
		
		req.setAttribute("allDepartment", allDepartment);
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);

	}

	
	
	//Ajax employee details
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}


