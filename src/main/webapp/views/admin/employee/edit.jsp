<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-employee"/>
<c:url var ="NewURL" value="/admin-employee"/>
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
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty message}">
									<div class="alert alert-${alert}">
  										${message}
									</div>
						</c:if>
                        <form id="formSubmit">
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
                                <label class="col-sm-3 control-label no-padding-right">Tên</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="image" name="image" value="${model.image}"/>
                                </div>
                            </div>
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
                                    <input type="text" class="form-control" id="birthday" name="birthday" value="${model.birthday}"/>
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
		e.preventDefault(); // tránh submit nhầm url
		var data = {};
		var formData = $('#formSubmit').serializeArray(); // tự động lấy tất cả field có thuộc tính name
		var department = $('input[type=checkbox]:checked').map(function(_, el) {
		    return $(el).val();
		}).get();
		$.each(formData, function(i, v){
			data[""+v.name+""] = v.value;
		});
		data["departmentIds"] = department;
		$.each(formData, function(i, v){
			console.log(data);
		});
		var id = $('#id').val();
		if(id == ""){
			addEmployee(data);
		} else {
			updateEmployee(data);
		}
		
	});
	
	
	function addEmployee(data){
		$.ajax({
			url: '${APIurl}',
			type: 'POST',
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
	
	function updateEmployee(data){
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
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
