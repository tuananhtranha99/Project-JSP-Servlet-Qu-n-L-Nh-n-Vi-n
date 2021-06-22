//package com.tuananh.controller.admin.api;
//
//import java.io.IOException;
//
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tuananh.model.NewsModel;
//import com.tuananh.service.INewsService;
//import com.tuananh.utils.HttpUtil;
//
//@WebServlet(urlPatterns = { "/api-admin-news" })
//public class NewsAPI extends HttpServlet {
//	private static final long serialVersionUID = -586112762741561087L;
//	@Inject
//	private INewsService newsService;
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////		client gửi data tiếng việt lên thì cần set utf8 để server hiểu được
//		req.setCharacterEncoding("UTF-8");
//
////		server trả kết quả về cho client là kiểu json
//		resp.setContentType("application/json");
//
//		// convert từ dạng json sang dạng object để chuẩn bị lưu xuống database
//		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
//
//		// Lưu xuống database và trả về object vừa lưu
//		newsModel = newsService.save(newsModel);
//
//		// convert từ dạng object sang dạng json để trả về cho client
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(resp.getOutputStream(), newsModel);
//	}
//
//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		
//		NewsModel updateNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
//		updateNews = newsService.update(updateNews);
//		mapper.writeValue(resp.getOutputStream(), updateNews);
//	}
//
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
//		newsService.delete(newsModel.getIds());
//		mapper.writeValue(resp.getOutputStream(), "{}");
//	}
//}
