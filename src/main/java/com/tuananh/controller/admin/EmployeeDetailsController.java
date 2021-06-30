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

import com.tuananh.constant.SystemConstant;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.PageRequest;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IEmployeeService;
import com.tuananh.sort.Sorter;
import com.tuananh.utils.HttpUtil;
import com.tuananh.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-employee-detail" })
public class EmployeeDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IEmployeeService employeeService;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeModel model = new EmployeeModel();
		String view = "/views/admin/employee/detail.jsp";
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		if(req.getParameter("id") != null){
			model = employeeService.findOne(Integer.parseInt(req.getParameter("id")));
		}
		req.setAttribute(SystemConstant.MODEL, model);
		req.getRequestDispatcher(view).forward(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		EmployeeModel employee = HttpUtil.of(req.getReader()).toModel(EmployeeModel.class);
		employee = employeeService.findOne(employee.getIdDetails());
		PrintWriter out = resp.getWriter();
		out.println( 
					"							  <div class=\"row\">\r\n" + 
					"						<div class=\"col-xs-12\">\r\n" + 
					"							<div class=\"container\">\r\n" + 
					"    <div class=\"team-single\">\r\n" + 
					"        <div class=\"row\">\r\n" + 
					"            <div class=\"col-lg-4 col-md-5 xs-margin-30px-bottom\">\r\n" + 
					"                <div class=\"team-single-img\">\r\n" + 
					"                    <img src=\"https://bootdey.com/img/Content/avatar/avatar7.png\" alt=\"\">\r\n" + 
					"                </div>\r\n" + 
					"                <div class=\"bg-light-gray padding-30px-all md-padding-25px-all sm-padding-20px-all text-center\">\r\n" + 
					"                    <h4 class=\"margin-10px-bottom font-size24 md-font-size22 sm-font-size20 font-weight-600\">Class Teacher</h4>\r\n" + 
					"                    <p class=\"sm-width-95 sm-margin-auto\">We are proud of child student. We teaching great activities and best program for your kids.</p>\r\n" + 
					"                    \r\n" + 
					"                </div>\r\n" + 
					"            </div>\r\n" + 
					"\r\n" + 
					"            <div class=\"col-lg-8 col-md-7\">\r\n" + 
					"                <div class=\"team-single-text padding-50px-left sm-no-padding-left\">\r\n" + 
					"                    <div class=\"contact-info-section margin-40px-tb\">\r\n" + 
					"                        <ul class=\"list-style9 no-margin\">\r\n" + 
					"                            <li>\r\n" + 
					"\r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"col-md-5 col-5\">\r\n" + 
					"                                        <i class=\"fa fa-user text-orange\" aria-hidden=\"true\"></i>\r\n" + 
					"                                        <strong class=\"margin-10px-left text-orange\">Tên nhân viên</strong>\r\n" + 
					"                                    </div>\r\n" + 
					"                                    <div class=\"col-md-7 col-7\">\r\n" + 
					"                                        <p>" + employee.getName() +"</p>\r\n" + 
					"                                    </div>\r\n" + 
					"                                </div>\r\n" + 
					"\r\n" + 
					"                            </li>\r\n" + 
					"                            <li>\r\n" + 
					"\r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"col-md-5 col-5\">\r\n" + 
					"                                        <i class=\"fa fa-birthday-cake text-yellow\" aria-hidden=\"true\"></i>\r\n" + 
					"                                        <strong class=\"margin-10px-left text-yellow\">Ngày sinh</strong>\r\n" + 
					"                                    </div>\r\n" + 
					"                                    <div class=\"col-md-7 col-7\">\r\n" + 
					"                                        <p>"+ employee.getBirthday() +"</p>\r\n" + 
					"                                    </div>\r\n" + 
					"                                </div>\r\n" + 
					"\r\n" + 
					"                            </li>\r\n" + 
					"                            <li>\r\n" + 
					"\r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"col-md-5 col-5\">\r\n" + 
					"                                        <i class=\"fa fa-transgender text-lightred\" aria-hidden=\"true\"></i>\r\n" + 
					"                                        <strong class=\"margin-10px-left text-lightred\">Giới tính</strong>\r\n" + 
					"                                    </div>\r\n" + 
					"                                    <div class=\"col-md-7 col-7\">\r\n" + 
					"                                        <p>Nam</p>\r\n" + 
					"                                    </div>\r\n" + 
					"                                </div>\r\n" + 
					"\r\n" + 
					"                            </li>\r\n" + 
					"                            <li>\r\n" + 
					"\r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"col-md-5 col-5\">\r\n" + 
					"                                        <i class=\"fa fa-map-marker text-green\" aria-hidden=\"true\"></i>\r\n" + 
					"                                        <strong class=\"margin-10px-left text-green\">Địa chỉ</strong>\r\n" + 
					"                                    </div>\r\n" + 
					"                                    <div class=\"col-md-7 col-7\">\r\n" + 
					"                                        <p>" + "Hà Nội" + "</p>\r\n" + 
					"                                    </div>\r\n" + 
					"                                </div>\r\n" + 
					"\r\n" + 
					"                            </li>\r\n" + 
					"                            <li>\r\n" + 
					"\r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"col-md-5 col-5\">\r\n" + 
					"                                        <i class=\"fa fa-phone text-purple\" aria-hidden=\"true\"></i>\r\n" + 
					"                                        <strong class=\"margin-10px-left xs-margin-four-left text-purple\">Số điện thoại</strong>\r\n" + 
					"                                    </div>\r\n" + 
					"                                    <div class=\"col-md-7 col-7\">\r\n" + 
					"                                        <p>"+ employee.getContact() +"</p>\r\n" + 
					"                                    </div>\r\n" + 
					"                                </div>\r\n" + 
					"\r\n" + 
					"                            </li>\r\n" + 
					"                            <li>\r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"col-md-5 col-5\">\r\n" + 
					"                                        <i class=\"fa fa-envelope-o text-pink\" aria-hidden=\"true\"></i>\r\n" + 
					"                                        <strong class=\"margin-10px-left xs-margin-four-left text-pink\">Email</strong>\r\n" + 
					"                                    </div>\r\n" + 
					"                                    <div class=\"col-md-7 col-7\">\r\n" + 
					"                                        <p>"+ employee.getEmail() +"</p>\r\n" + 
					"                                    </div>\r\n" + 
					"                                </div>\r\n" + 
					"                            </li>\r\n" + 
					"                            <li>\r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"col-md-5 col-5\">\r\n" + 
					"                                        <i class=\"fa fa-info text-sky\" aria-hidden=\"true\"></i>\r\n" + 
					"                                        <strong class=\"margin-10px-left xs-margin-four-left text-sky\">Số căn cước công dân</strong>\r\n" + 
					"                                    </div>\r\n" + 
					"                                    <div class=\"col-md-7 col-7\">\r\n" + 
					"                                        <p>"+ employee.getIdentity()+"</p>\r\n" + 
					"                                    </div>\r\n" + 
					"                                </div>\r\n" + 
					"                            </li>\r\n" + 
					"                        </ul>\r\n" + 
					"                    </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"                    \r\n" + 
					"\r\n" + 
					"                </div>\r\n" + 
					"            </div>\r\n" + 
					"\r\n" + 
					"            \r\n" + 
					"        </div>\r\n" + 
					"    </div>\r\n" + 
					"</div>\r\n" + 
					"						</div>\r\n" + 
					"					</div>");
	}

}
