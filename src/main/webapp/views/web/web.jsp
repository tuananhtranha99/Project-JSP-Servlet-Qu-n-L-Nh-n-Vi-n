<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang Chủ</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="<c:url value='/template/web/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
	<div class="all ">
	    <div class="container">
	            <div class="row">
	            <div class="col-2"></div>
	            <div class="col-8">
	                <div class="bksoftware-logo">
	                    <img src="//www.zohowebstatic.com/sites/default/files/styles/product-home-page/public/people-40.png?itok=jfjecRoL" alt="Bksoftware">
	                </div>
	                <h4 class="bksoftware-header">
	                    Quản Lý Nhân Viên
	                </h4>
	                <h2>Được tạo ra để xây dựng đội ngũ làm việc vui vẻ hơn</h2>
	                <p>Hãy để chúng tôi đảm nhiệm các quy trình Nhân sự của bạn, còn bạn chăm sóc nhân viên của mình. Từ quản lý nhập môn và sự có mặt đến theo dõi thời gian và đánh giá, chúng tôi đều đã chuẩn bị sẵn sàng.</p>
	                <div class="bksoftware-button">
	                    <a class="" href='<c:url value="/dang-nhap?action=login" />'><button id="button1">  Đăng Nhập</button></a>
	                    <button>Đăng Kí</button>
	                </div>
	                <div class="bksoftware-footer">
	                    <ul>
	                        <li>
	                            <a href="">hotline</a>
	                        </li>
	                        <li>
	                            <a href="">mail</a>
	                        </li>
	                        <li>
	                            <a href="">youtube</a>
	                        </li>
	                        <li>
	                            <a href="">facebook</a>
	                        </li>
	                    </ul>
	                </div>
	            </div>
	            <div class="col-2"></div>
	        </div>
	    </div>  
	    </div>
	    
	    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>