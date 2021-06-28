<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="APIurl" value="/api-admin-department"/>
<c:url var ="NewURL" value="/admin-department"/>
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
									
										
<!-- 										<div class="input-group mb-3 pull-left" style="display: flex"> -->
<!--   											<input type="text" class="form-control" placeholder="Search" id="txtSearch" name="txtSearch"> -->
<!--     										<button class="btn " id="btnSearch" name="btnSearch"><i class="fa fa-search" aria-hidden="true"></i></button> -->
<!-- 										</div> -->
										
									
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm phòng ban' href='<c:url value="/admin-department-edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa phòng ban'>
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
											<th><input type="checkbox" id="checkedAll" name="checkedAll"></th>
											<th>Tên Phòng Ban</th>
											<th>Mô tả</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody id="content">
										<c:forEach var="item" items="${model.listResult}">
											<tr>
												<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}" class="checkSingle"></td>
												<td>
												
												
												${item.name }
												
												</td>
												<td>${item.description}</td>
												<td>
												<c:url var="editURL" value="/admin-department-edit">
													<c:param name="id" value="${item.id }" />
												</c:url>
												<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
												  title="Cập nhật phòng ban" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
												</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<button class="btn btn-primary" onclick="loadMore()">Xem thêm</button>
								
							</div>
						</div>
					</div>
					</div>
				</div>
		</form>
	</div>

	<script type="text/javascript">


		function loadMore(){
			$.ajax({
				url: '${APIurl}',
				type: 'GET',
				contentType: 'text/html;charset=UTF-8',
				success: function(result){
// 					console.log(result);
					var content = document.getElementById('content');
					content.innerHTML += result;
				},
				error: function(error){
					console.log(error);
				}
			});
		}
		
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
		
// 		$('#btnSearch').click(function(){
// 			var data = {};
// 			var txtSearch = $('#txtSearch').val();
// 			data['txtSearch'] = txtSearch;
// 			searchEmployee(data);
// 		});
		
// 		function searchEmployee(data){
			
// 		}

		$(document).ready(function() {
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
		});
	</script>
</body>
</html>