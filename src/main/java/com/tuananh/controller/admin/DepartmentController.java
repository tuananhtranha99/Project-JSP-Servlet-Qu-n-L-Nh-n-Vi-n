package com.tuananh.controller.admin;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuananh.constant.SystemConstant;
import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.PageRequest;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IDepartmentService;
import com.tuananh.service.IEmployeeService;
import com.tuananh.sort.Sorter;
import com.tuananh.utils.FormUtil;
import com.tuananh.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-department" })
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Inject
	private IDepartmentService departmentService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DepartmentModel model = new DepartmentModel();
		String view = "/views/admin/department/list.jsp";
		String sort = req.getParameter("sort");
		String sortLoadMore = "";
		if(sort == null || sort.equals("nameAtoZ")) {
			model.setSortBy("asc");
			sortLoadMore = "nameAtoZ";
		} else if(sort.equals("nameZtoA")) {
			model.setSortBy("desc");
			sortLoadMore = "nameZtoA";
		}
		model.setSortName("name");
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		model.setListResult(departmentService.findTop7(pageble));
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		req.setAttribute("sortLoadMore", sortLoadMore);
		req.getRequestDispatcher(view).forward(req, resp);
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
