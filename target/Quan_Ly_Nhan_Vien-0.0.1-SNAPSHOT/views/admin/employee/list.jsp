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
				<div class="page-content" style="margin-bottom: 50px">
				
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
											<tr>
												<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}" class="checkSingle" ></td>
												<td >
												<a href="/Quan_Ly_Nhan_Vien/controller/admin/employee-detail?id=${item.id}" class="openDialog" >
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
								<button class="btn btn-primary" id="loadMore">Xem thêm</button>
								
 								<div id="dialog-modal" title="Thông tin chi tiết" style="display:none"> 
<!-- 							  <div class="row"> -->
<!-- 						<div class="col-xs-12"> -->
<!-- 							<div class="container"> -->
<!--     <div class="team-single"> -->
<!--         <div class="row"> -->
<!--             <div class="col-lg-4 col-md-5 xs-margin-30px-bottom"> -->
<!--                 <div class="team-single-img"> -->
<!--                     <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt=""> -->
<!--                 </div> -->
<!--                 <div class="bg-light-gray padding-30px-all md-padding-25px-all sm-padding-20px-all text-center"> -->
<!--                     <h4 class="margin-10px-bottom font-size24 md-font-size22 sm-font-size20 font-weight-600">Class Teacher</h4> -->
<!--                     <p class="sm-width-95 sm-margin-auto">We are proud of child student. We teaching great activities and best program for your kids.</p> -->
                    
<!--                 </div> -->
<!--             </div> -->

<!--             <div class="col-lg-8 col-md-7"> -->
<!--                 <div class="team-single-text padding-50px-left sm-no-padding-left"> -->
<!--                     <h4 class="font-size38 sm-font-size32 xs-font-size30">Buckle Giarza</h4> -->
<!--                     <p class="no-margin-bottom"></p> -->
<!--                     <div class="contact-info-section margin-40px-tb"> -->
<!--                         <ul class="list-style9 no-margin"> -->
<!--                             <li> -->

<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-5 col-5"> -->
<!--                                         <i class="fa fa-user text-orange" aria-hidden="true"></i> -->
<!--                                         <strong class="margin-10px-left text-orange">Tên nhân viên</strong> -->
<!--                                     </div> -->
<!--                                     <div class="col-md-7 col-7"> -->
<!--                                         <p>Master's Degrees</p> -->
<!--                                     </div> -->
<!--                                 </div> -->

<!--                             </li> -->
<!--                             <li> -->

<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-5 col-5"> -->
<!--                                         <i class="fa fa-birthday-cake text-yellow" aria-hidden="true"></i> -->
<!--                                         <strong class="margin-10px-left text-yellow">Ngày sinh</strong> -->
<!--                                     </div> -->
<!--                                     <div class="col-md-7 col-7"> -->
<!--                                         <p>4 Year in Education</p> -->
<!--                                     </div> -->
<!--                                 </div> -->

<!--                             </li> -->
<!--                             <li> -->

<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-5 col-5"> -->
<!--                                         <i class="fa fa-transgender text-lightred" aria-hidden="true"></i> -->
<!--                                         <strong class="margin-10px-left text-lightred">Giới tính</strong> -->
<!--                                     </div> -->
<!--                                     <div class="col-md-7 col-7"> -->
<!--                                         <p>Design Category</p> -->
<!--                                     </div> -->
<!--                                 </div> -->

<!--                             </li> -->
<!--                             <li> -->

<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-5 col-5"> -->
<!--                                         <i class="fa fa-map-marker text-green" aria-hidden="true"></i> -->
<!--                                         <strong class="margin-10px-left text-green">Địa chỉ</strong> -->
<!--                                     </div> -->
<!--                                     <div class="col-md-7 col-7"> -->
<!--                                         <p>Regina ST, London, SK.</p> -->
<!--                                     </div> -->
<!--                                 </div> -->

<!--                             </li> -->
<!--                             <li> -->

<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-5 col-5"> -->
<!--                                         <i class="fa fa-phone text-purple" aria-hidden="true"></i> -->
<!--                                         <strong class="margin-10px-left xs-margin-four-left text-purple">Số điện thoại</strong> -->
<!--                                     </div> -->
<!--                                     <div class="col-md-7 col-7"> -->
<!--                                         <p>(+44) 123 456 789</p> -->
<!--                                     </div> -->
<!--                                 </div> -->

<!--                             </li> -->
<!--                             <li> -->
<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-5 col-5"> -->
<!--                                         <i class="fa fa-envelope-o text-pink" aria-hidden="true"></i> -->
<!--                                         <strong class="margin-10px-left xs-margin-four-left text-pink">Email</strong> -->
<!--                                     </div> -->
<!--                                     <div class="col-md-7 col-7"> -->
<!--                                         <p><a href="javascript:void(0)">addyour@emailhere</a></p> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <div class="row"> -->
<!--                                     <div class="col-md-5 col-5"> -->
<!--                                         <i class="fa fa-info text-sky" aria-hidden="true"></i> -->
<!--                                         <strong class="margin-10px-left xs-margin-four-left text-sky">Số căn cước công dân</strong> -->
<!--                                     </div> -->
<!--                                     <div class="col-md-7 col-7"> -->
<!--                                         <p><a href="javascript:void(0)">addyour@emailhere</a></p> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                     </div> -->


                    

<!--                 </div> -->
<!--             </div> -->

            
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
							  
							</div>
								
							</div>
						</div>
					</div>


				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript">
	
	
	
		
		
		
// 		$('#btnSearch').click(function(){
// 			var data = {};
// 			var txtSearch = $('#txtSearch').val();
// 			data['txtSearch'] = txtSearch;
// 			searchEmployee(data);
// 		});
		
// 		function searchEmployee(data){
			
// 		}


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
			
			
		

				$("body").on('click', '#loadMore' ,function(){ 
					$.ajax({
						url: '/Quan_Ly_Nhan_Vien/employee-load',
						type: 'POST',
						contentType: 'text/html;charset=UTF-8',
						success: function(result){
//								console.log(result);
							var content = $('#content');
							content.html(result);
						},
						error: function(error){
							console.log(error);
						}
					});
					
				});	
		
		
		function showDetailsEmployee(idDetails){
		    
			   var data = {};
			   data['idDetails'] = idDetails;
			   $.ajax({
					url: '/Quan_Ly_Nhan_Vien/employee-edit',
					type: 'POST',
					contentType: 'text/html;charset=UTF-8',
					data: JSON.stringify(data),
					cache: false,
					success: function(result){
						var content = $('#dialog-modal');
						content.html(result);
					},
					error: function(error){
						
					}
				});
		       $( "#dialog-modal" ).dialog({
		          height: 600,
		          width: 1200,
		          modal: true,
		        });
		       $( "#dialog-modal" ).show();
		  
	};
		
		/////////////////////////////////////////
		
	</script>
	

</body>
</html>