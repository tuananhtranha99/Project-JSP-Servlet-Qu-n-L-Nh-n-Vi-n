<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="APIurl" value="/api-admin-employee"/>
<c:url var ="NewURL" value="/admin-employee"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>

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
				<div class="page-content">
				
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
  											<input type="text" class="form-control" placeholder="Search" id="txtSearch" name="txtSearch">
    										<button class="btn " type="submit" id="btnSearch" name="btnSearch"><i class="fa fa-search" aria-hidden="true"></i></button>
										</div>
										
									
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm nhân viên' href='<c:url value="/admin-employee?type=edit"/>'>
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
											<th><input type="checkbox" id="checkAll"></th>
											<th>Tên nhân viên</th>
											<th>Số điện thoại</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model.listResult}">
											<tr>
												<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
												<td>${item.name }</td>
												<td>${item.contact }</td>
												<td>
												<c:url var="editURL" value="/admin-employee">
													<c:param name="type" value="edit" />
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
								<ul class="pagination" id="pagination"></ul>
								<input type="hidden" value="" id="page" name="page">
								 <input	type="hidden" value="" id="maxPageItem" name="maxPageItem">
								 <input	type="hidden" value="" id="sortName" name="sortName">
								 <input	type="hidden" value="" id="sortBy" name="sortBy">
								 <input	type="hidden" value="list" id="type" name="type">
							</div>
						</div>
					</div>
					</div>
				</div>
		</form>
	</div>

	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#sortName').val('name');
						$('#sortBy').val('desc');
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
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
					window.location.href = "${newURL}?type=list&maxPageItem=2&page=1&message=delete_success";
				},
				error: function(error){
					window.location.href = "${newURL}?type=list&maxPageItem=2&page=1&message=error_system";
				}
			});
		}
		
		$('#btnSearch').click(function(){
			var data = {};
			var txtSearch = $('#txtSearch').val();
			data['txtSearch'] = txtSearch;
			searchEmployee(data);
		});
		
		function searchEmployee(data){
			$.ajax({
				url: '${APIurl}',
				type: 'GET',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result){
					console.log(result);
				},
				error: function(error){
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>