package com.tuananh.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuananh.model.EmployeeModel;
import com.tuananh.service.IEmployeeService;
import com.tuananh.utils.HttpUtil;

@WebServlet(urlPatterns = { "/employee-load" })
public class EmployeeLoadMoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IEmployeeService employeeService;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
			List<EmployeeModel> list = employeeService.findTop3();		
			PrintWriter out = resp.getWriter();
			for(EmployeeModel o : list) {
				out.println("<tr>\r\n" + 
						"												<td><input type=\"checkbox\" id=\"checkbox_${item.id}\" value=\"${item.id}\" class=\"checkSingle\" ></td>\r\n" + 
						"												<td >\r\n" + 
						"												<a href='<c:url value=\"/admin-employee-detail?id="+ o.getId() +"\"></c:url>' class=\"openDialog\" style=\"color: black\">\r\n" + 
						"												<img src=\""+ o.getImage() +"\" alt=\"Avatar\" class=\"avatar \"\r\n" + 
						"														 style=\"vertical-align: middle;width: 50px;height: 50px;border-radius: 50%; float: left;  margin-right: 10px;\">\r\n" + 
						"												" + o.getName() +"\r\n" + 
						"												</a>\r\n" + 
						"												</td>\r\n" + 
						"												<td>" + o.getContact() + "</td>\r\n" + 
						"												<td>" + o.getEmail() +"</td>\r\n" + 
						"												<td>\r\n" + 
						"												<c:url var=\"editURL\" value=\"/admin-employee-edit\">\r\n" + 
						"													<c:param name=\"id\" value=\"${item.id }\" />\r\n" + 
						"												</c:url>\r\n" + 
						"												<a class=\"btn btn-sm btn-primary btn-edit\" data-toggle=\"tooltip\"\r\n" + 
						"												  title=\"Cập nhật nhân viên\" href='${editURL}'><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i>\r\n" + 
						"												</a>\r\n" + 
						"												</td>\r\n" + 
						"											</tr>");
			}
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
