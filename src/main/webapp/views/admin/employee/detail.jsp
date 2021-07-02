<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="APIurl" value="/api-admin-employee"/>
<c:url var ="NewURL" value="/admin-employee"/>
<html>
<head>
    <title>Chi tiết nhân viên</title>
    <link href="<c:url value='/template/admin/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
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

        							  <div class="row">
         						<div class="col-xs-12">
        							<div class="container">
             <div class="team-single">
                 <div class="row">
                    <div class="col-lg-4 col-md-5 xs-margin-30px-bottom">
                        <div class="team-single-img">
                           <img src="${model.image}" alt="Ảnh đại diện" width="100%" height="100%">
                        </div>
                        
                    </div> 

                    <div class="col-lg-8 col-md-7"> 
                        <div class="team-single-text padding-50px-left sm-no-padding-left"> 
                             <h4 class="font-size38 sm-font-size32 xs-font-size30">${model.name }</h4> 
                             <p class="no-margin-bottom"></p> 
                             <div class="contact-info-section margin-40px-tb"> 
                                 <ul class="list-style9 no-margin"> 
                                     <li> 

                                         <div class="row"> 
                                             <div class="col-md-5 col-5"> 
                                                 <i class="fa fa-user text-orange" aria-hidden="true"></i> 
                                                 <strong class="margin-10px-left text-orange">Trạng thái</strong> 
                                            </div> 
                                            <div class="col-md-7 col-7"> 
                                                 <p>${model.status }</p> 
                                             </div> 
                                        </div> 

                                    </li> 
                                     <li> 

                                         <div class="row"> 
                                             <div class="col-md-5 col-5"> 
                                                 <i class="fa fa-birthday-cake text-yellow" aria-hidden="true"></i> 
                                                 <strong class="margin-10px-left text-yellow">Ngày sinh</strong> 
                                             </div> 
                                            <div class="col-md-7 col-7"> 
                                                <p>${model.birthday }</p> 
                                            </div> 
                                        </div> 

                                    </li> 
                                     <li> 

                                        <div class="row"> 
                                             <div class="col-md-5 col-5"> 
                                                 <i class="fa fa-transgender text-lightred" aria-hidden="true"></i> 
                                                 <strong class="margin-10px-left text-lightred">Giới tính</strong> 
                                             </div> 
                                             <div class="col-md-7 col-7"> 
                                                <c:if test="${model.gender == false }">
                                                	<p>Nam</p> 
                                                </c:if>
                                                
                                                 <c:if test="${model.gender == true }">
                                                	<p>Nữ</p> 
                                                </c:if>
                                            </div> 
                                        </div> 

                                   </li> 
                                   <li> 

                                        <div class="row"> 
                                             <div class="col-md-5 col-5"> 
                                                <i class="fa fa-map-marker text-green" aria-hidden="true"></i> 
                                                <strong class="margin-10px-left text-green">Địa chỉ</strong> 
                                             </div> 
                                            <div class="col-md-7 col-7"> 
                                                 <p>${model.address}</p> 
                                            </div> 
                                         </div> 
                                     </li> 
                                     <li> 

                                         <div class="row"> 
                                             <div class="col-md-5 col-5"> 
                                                 <i class="fa fa-phone text-purple" aria-hidden="true"></i> 
                                                 <strong class="margin-10px-left xs-margin-four-left text-purple">Số điện thoại</strong> 
                                             </div> 
                                             <div class="col-md-7 col-7"> 
                                                 <p>${model.contact }</p> 
                                             </div> 
                                         </div> 

                                     </li> 
                                     <li>
                                         <div class="row"> 
                                             <div class="col-md-5 col-5"> 
                                                 <i class="fa fa-envelope-o text-pink" aria-hidden="true"></i> 
                                                 <strong class="margin-10px-left xs-margin-four-left text-pink">Email</strong> 
                                             </div> 
                                             <div class="col-md-7 col-7"> 
                                                 <p>${model.email }</p> 
                                             </div> 
                                         </div> 
                                     </li> 
                                     <li> 
                                         <div class="row"> 
                                             <div class="col-md-5 col-5"> 
                                                 <i class="fa fa-info text-sky" aria-hidden="true"></i>
                                                 <strong class="margin-10px-left xs-margin-four-left text-sky">Số căn cước công dân</strong> 
                                             </div> 
                                             <div class="col-md-7 col-7"> 
                                                 <p>${model.identity }</p> 
                                             </div>
                                         </div> 
                                     </li> 
                                 </ul> 
                             </div> 




                         </div> 
                     </div>


                 </div> 
             </div> 
         </div> 
         						</div> 
         					</div> 

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
</body>
</html>
