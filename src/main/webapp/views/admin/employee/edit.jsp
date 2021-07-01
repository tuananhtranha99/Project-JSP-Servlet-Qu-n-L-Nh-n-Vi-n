<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-employee"/>
<c:url var ="NewURL" value="/admin-employee-edit"/>
<html>
<head>
    <title>Chỉnh sửa nhân viên</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa nhân viên</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
						</c:if>
						 <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                                <div class="col-sm-9" style="display:flex" >
                                   
                                    <input type="text" class="form-control col-sm-9" readonly value="${model.image}"/>
                                    
                                    	<form action='<c:url value="/api-upload-file?id=${model.id}&message=update_success"></c:url>' method="post" enctype="multipart/form-data" class="col-sm-3" style="display:flex" id="myform"> 
                                    	<input type="file" name="file" multiple="multiple" />
<!--                                     	<input type="submit" value="Tải lên" /> -->
                       					</form>
                                    
                                    
                                   
                                   
                               </div>
                            </div>
							<br/>
                            <br/>
                        <form id="formSubmit">
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tên</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
                                </div>
                            </div>
							<br/>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Liên hệ</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="contact" name="contact" value="${model.contact}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Email</label>
                                <div class="col-sm-9">                                 
                                    <input type="text" class="form-control" id="email" name="email" value="${model.email}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Ngày sinh</label>
                                <div class="col-sm-9">  
                                	<c:if test="${not empty model.birthday}">
                                		<input type="date" class="form-control" id="birthday" name="birthday" value="${model.birthday}"/>
                                	</c:if>   
                                	
                                	<c:if test="${empty model.birthday}">
                                		<input type="date" class="form-control" id="birthday" name="birthday" value="1950-01-01"/>
                                	</c:if>                               
                                    
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Trạng thái</label>
                                <div class="col-sm-9">                                 
                                    <input type="text" class="form-control" id="status" name="status" value="${model.status}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Số chứng minh thư</label>
                                <div class="col-sm-9">                                 
                                    <input type="text" class="form-control" id="identity" name="identity" value="${model.identity}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Địa chỉ</label>
                                <div class="col-sm-9">                                 
                                    <input type="text" class="form-control" id="address" name="address" value="${model.address}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Phòng ban</label>
                                <div class="col-sm-9">
                                	
									<c:forEach var="item" items="${departments}">
										<label class="checkbox-inline">
									 		<input type="checkbox" value="${item.id}" ${item.check}>${item.name}
										</label>
									</c:forEach>
								</div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật thông tin" id="btnAddOrUpdate"/>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm nhân viên" id="btnAddOrUpdate"/>
                                    </c:if>
                                </div>
                            </div>
                           <input type="hidden" value="${model.id}" id="id" name="id" />
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	

	$("#btnAddOrUpdate").click(function(e){
		uploadFile();
		e.preventDefault(); // tránh submit nhầm url
		var data = {};
		var formData = $('#formSubmit').serializeArray(); // tự động lấy tất cả field có thuộc tính name
		var department = $('input[type=checkbox]:checked').map(function(_, el) {
		    return $(el).val();
		}).get();
		$.each(formData, function(i, v){
			data[""+v.name+""] = v.value;
		});
		data["departmentIdMapping"] = department;
	
		var id = $('#id').val();
		if(id == ""){
			
			addEmployee(data);
			
		} else {
			updateEmployee(data);
		}
		
	});
	
	//api để upload ảnh
	function uploadFile(){
		var form = $('#myform')[0];
        var data = new FormData(form);
		$.ajax({
			url: '/Quan_Ly_Nhan_Vien/api-upload-file?id=' + $('#id').val() ,
			type: 'POST',
			enctype : 'multipart/form-data',
			contentType : false,
			processData : false,
			data : data,
			success: function(result){
				console.log(result);
			},
			error: function(error){
				console.log(error);
			}
		});
		
	}
	
	//api thêm mới nhân viên
	function addEmployee(data){
		$.ajax({
			url: '${APIurl}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function(result){
				window.location.href = "${newURL}?type=edit&id=" + result.id+"&message=insert_success";
			},
			error: function(error){
				window.location.href = "${newURL}?type=list&maxPageItem=2&page=1&message=error_system";
			}
		});
		
	}
	
	//api cập nhật nhân viên
	function updateEmployee(data){
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function(result){
				window.location.href = "${newURL}?type=edit&id=" + result.id+"&message=update_success";
			},
			error: function(error){
				window.location.href = "${newURL}?type=list&maxPageItem=2&page=1&message=error_system";
			},
		});

	}
</script>
</body>
</html>
