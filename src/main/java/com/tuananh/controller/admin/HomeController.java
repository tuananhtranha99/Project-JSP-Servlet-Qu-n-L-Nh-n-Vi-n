package com.tuananh.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuananh.model.AccountModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.service.IAccountService;
import com.tuananh.service.IEmployeeService;
import com.tuananh.utils.FormUtil;
import com.tuananh.utils.SessionUtil;

@WebServlet(urlPatterns = {"/admin-home", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	@Inject 
	private IAccountService accountService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")){
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/home");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			AccountModel model = FormUtil.toModel(AccountModel.class, req);
			model = accountService.findByUserNameAndPassword(model.getUsername(), model.getPassword());
			if(model != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", model);
				resp.sendRedirect(req.getContextPath()+"/admin-home");
			} else {
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}
	}
	
	
}
