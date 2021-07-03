<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="APIurl" value="/api-admin-employee"/>
<c:url var ="NewURL" value="/admin-employee"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách nhân viên</title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css' />"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
	<link href="<c:url value='/template/admin/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>

<body class="no-skin">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<%@ include file="/common/admin/menu.jsp"%>
		<div class="main-content">
		<form action="<c:url value='/admin-employee'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content" style="margin-bottom: 50px" id="page-content">
				
				<div class="row">
							<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
							</c:if>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
									
										
										<div class="input-group mb-3 pull-left" style="display: flex">
  											<input oninput="searchByName(this)" type="text" class="form-control" placeholder="Nhập tên nhân viên" id="txtSearch" name="txtSearch">

										</div>
										
										<input type="hidden" name="sort" value="">
										<div class="pull-right tableTools-container">
											<c:if test="${sortLoadMore == 'nameZtoA' }">
												<select id="sort" >
												  <option value="nameAtoZ" >Theo thứ tự tên từ A - Z</option>
												  <option value="nameZtoA" selected>Theo thứ tự tên từ Z - A</option>
											</select>
											</c:if>
											<c:if test="${sortLoadMore == 'nameAtoZ' }">
												<select id="sort" >
												  <option value="nameAtoZ" selected>Theo thứ tự tên từ A - Z</option>
												  <option value="nameZtoA" >Theo thứ tự tên từ Z - A</option>
											</select>
											</c:if>
											<div class="dt-buttons btn-overlap btn-group">
												<a 
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm nhân viên' href='<c:url value="/admin-employee-edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button" 
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa nhân viên'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th><input type="checkbox" id="checkedAll" name="checkedAll" ></th>
											<th>Tên nhân viên</th>
											<th>Số điện thoại</th>
											<th>Email</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody id="content">
										<c:forEach var="item" items="${model.listResult}">
											<tr class="employee">
												<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}" class="checkSingle" ></td>
												<td >
												<a href='<c:url value="/admin-employee-detail?id=${item.id}"></c:url>' class="openDialog" style="color: black">
												<img src="${item.image}" alt="Avatar" class="avatar "
														 style="vertical-align: middle;width: 50px;height: 50px;border-radius: 50%; float: left;  margin-right: 10px;">
												${item.name }
												</a>
												</td>
												<td>${item.contact }</td>
												<td>${item.email }</td>
												<td>
												<c:url var="editURL" value="/admin-employee-edit">
													<c:param name="id" value="${item.id }" />
												</c:url>
												<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
												  title="Cập nhật nhân viên" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
												</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>

								
							</div>
						</div>
					</div>


				</div>
			</div>
		</form>
		<input type="hidden" id="sortLoadMore" value="${sortLoadMore}"/>
	</div>
		<%@ include file="/common/admin/footer.jsp"%>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>

	
	
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
	<script type="text/javascript">
	
	
	
		
		
	


		  $("#checkedAll").change(function(){
		    if(this.checked){
		      $(".checkSingle").each(function(){
		        this.checked=true;
		      })              
		    }else{
		      $(".checkSingle").each(function(){
		        this.checked=false;
		      })              
		    }
		  });
		
		  $(".checkSingle").click(function () {
		    if ($(this).is(":checked")){
		      var isAllChecked = 0;
		      $(".checkSingle").each(function(){
		        if(!this.checked)
		           isAllChecked = 1;
		      })              
		      if(isAllChecked == 0){ $("#checkedAll").prop("checked", true); }     
		    }else {
		      $("#checkedAll").prop("checked", false);
		    }
		  });
		  
		  $('#btnDelete').click(function(){
				var data = {};
				var ids = $('tbody input[type=checkbox]:checked').map(function(){
					return $(this).val();
				}).get();
				data['ids'] = ids;
				deleteEmployee(data);
			});
			
			function deleteEmployee(data){
				$.ajax({
					url: '${APIurl}',
					type: 'DELETE',
					contentType: 'application/json',
					data: JSON.stringify(data),
					success: function(result){
						window.location.href = "${newURL}?message=delete_success";
					},
					error: function(error){
						window.location.href = "${newURL}?message=error_system";
					}
				});
			}
			
			function searchByName(param){
				var txtSearch = param.value;
				$.ajax({
					url: '/Quan_Ly_Nhan_Vien/admin-search-employee',
					type: 'GET',
					data: {
						txt: txtSearch
					},
					success: function(result){
						var row = document.getElementById("content");
						row.innerHTML = result;
					},
					error: function(error){
						
					}
				});
			}
			
			
			
			$(window).scroll(function() {
				   if($(window).scrollTop() + $(window).height() >= $(document).height() ) {
				       loadMore();
				   }
				});
			
			
			
		
			
			
			function loadMore(){ 
					var amount = document.getElementsByClassName("employee").length;
					$.ajax({
						url: '/Quan_Ly_Nhan_Vien/employee-load',
						type: 'GET',
						data:{
							sort: $('#sortLoadMore').val(),
							offset: amount
						},
						success: function(result){
							var row = document.getElementById("content");
							row.innerHTML += result;
						},
						error: function(error){
							
						}
					});
			}
			$('select').on('change', function() {
				var sort = this.value;
				$('input[name=sort]').val(sort);
				$('#formSubmit').submit();
				});

					
		
		
		
		/////////////////////////////////////////
		
	</script>
	
	
</body>
</html>