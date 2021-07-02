package com.tuananh.controller.admin.api;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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
import com.tuananh.dao.IEmployeeDAO;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.PageRequest;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IEmployeeService;
import com.tuananh.sort.Sorter;


@WebServlet(value = "/admin-search")
public class SearchAPI extends HttpServlet{
	private static final long serialVersionUID = -7167694688161642839L;
	
	@Inject
	private IEmployeeService employeeService;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		EmployeeModel model = new EmployeeModel();
		String txtSearch = req.getParameter("txt");
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		List<EmployeeModel> list = employeeService.searchByName(pageble, txtSearch);
		PrintWriter out = resp.getWriter();
		for (EmployeeModel o : list) {
			out.println(
					"											<tr>\r\n" + 
					"												<td><input type=\"checkbox\" id=\"checkbox_${item.id}\" value=\"${item.id}\" class=\"checkSingle\" ></td>\r\n" + 
					"												<td >\r\n" + 
					"												<a href='<c:url value=\"/admin-employee-detail?id=${item.id}\"></c:url>' class=\"openDialog\" style=\"color: black\">\r\n" + 
					"												<img src=\" "+ o.getImage() +"\" alt=\"Avatar\" class=\"avatar \"\r\n" + 
					"														 style=\"vertical-align: middle;width: 50px;height: 50px;border-radius: 50%; float: left;  margin-right: 10px;\">\r\n" + 
					"												"+ o.getName() +"\r\n" + 
					"												</a>\r\n" + 
					"												</td>\r\n" + 
					"												<td>" + o.getContact() + "</td>\r\n" + 
					"												<td>" + o.getEmail() + "</td>\r\n" + 
					"												<td>\r\n" + 
					"												<c:url var=\"editURL\" value=\"/admin-employee-edit\">\r\n" + 
					"													<c:param name=\"id\" value=\"${item.id }\" />\r\n" + 
					"												</c:url>\r\n" + 
					"												<a class=\"btn btn-sm btn-primary btn-edit\" data-toggle=\"tooltip\"\r\n" + 
					"												  title=\"Cập nhật nhân viên\" href='${editURL}'><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i>\r\n" + 
					"												</a>\r\n" + 
					"												</td>\r\n" + 
					"											</tr>\r\n"  );
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

	

}
