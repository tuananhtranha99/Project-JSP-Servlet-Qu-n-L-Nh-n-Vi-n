package com.tuananh.controller.admin.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.PageRequest;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IDepartmentService;
import com.tuananh.service.IEmployeeService;
import com.tuananh.sort.Sorter;


@WebServlet(value = "/admin-search-department")
public class DepartmentSearchAPI extends HttpServlet{
	private static final long serialVersionUID = -7167694688161642839L;
	
	@Inject
	private IDepartmentService departmentService;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		DepartmentModel model = new DepartmentModel();
		String txtSearch = req.getParameter("txt");
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		List<DepartmentModel> list = departmentService.searchByName(pageble, txtSearch);
		PrintWriter out = resp.getWriter();
		for (DepartmentModel o : list) {
			out.println(
					"											<tr>\r\n" + 
					"												<td><input type=\"checkbox\" id=\"checkbox_${item.id}\" value=\""+ o.getId() +"\" class=\"checkSingle\"></td>\r\n" + 
					"												<td>\r\n" + 
					"												\r\n" + 
					"												\r\n" + 
					"												" + o.getName() +"\r\n" + 
					"												\r\n" + 
					"												</td>\r\n" + 
					"												<td>" + o.getDescription() +"</td>\r\n" + 
					"												<td>\r\n" + 
					"												<c:url var=\"editURL\" value=\"/admin-department-edit\">\r\n" + 
					"													<c:param name=\"id\" value=\"${item.id }\" />\r\n" + 
					"												</c:url>\r\n" + 
					"												<a class=\"btn btn-sm btn-primary btn-edit\" data-toggle=\"tooltip\"\r\n" + 
					"												  title=\"Cập nhật phòng ban\" href='/Quan_Ly_Nhan_Vien/admin-department-edit?id="+o.getId()+"'><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i>\r\n" + 
					"												</a>\r\n" + 
					"												</td>\r\n" + 
					"											</tr>"  );
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

	

}
