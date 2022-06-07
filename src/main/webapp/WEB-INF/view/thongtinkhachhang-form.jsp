<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=" utf-8" />
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-1.10.2.min'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/responsive.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<c:url var="pattern" value="/resources/img/chloe.png" />

<title>Quản Lý Nước Hoa</title>
</head>
<body>
	<security:authentication property="principal.username" var="makhachhang"/>
	<div class="container">
	<div class="pt-5">  
  <div class="global-container">  
    <div class="card login-form">  
    <div class="card-body">  
        <h1 class="card-title text-center"> Thông tin khách hàng </h1>  
        <div class="card-text">
        	<c:url var="saveUrl" value="/khachhang/saveKhachHangs?makh=${makhachhang }" />  
            <form:form modelAttribute="ttkhachhang" method="POST" action="${saveUrl}">
            	 
                <div class="form-group">  
                    <label > Tên khách hàng: </label>  
                    <form:input path="tenKhachHang" type="text" class="form-control form-control-sm" id="txtten" value="${ttkh.tenKhachHang}"/>  
                </div>  
                <div class="form-group">  
                    <label > Số điện thoại: </label>  
                    <form:input path="soDienThoaikh" type="text" class="form-control form-control-sm" id="txtsdt" value="${ttkh.soDienThoaikh}"/>  
                </div>
                <div class="form-group">  
                    <label > Email: </label>  
                    <form:input path="email" type="text" class="form-control form-control-sm" id="txtemail" value="${ttkh.email}"/>  
                </div>
                <div class="form-group">  
                    <label > Địa chỉ: </label>  
                    <form:input path="diaChi" type="text" class="form-control form-control-sm" id="txtdiaChi" value="${ttkh.diaChi}"/>  
                </div>
                 
                <button type="submit" class="btn btn-primary btn-block"> Sửa thông tin </button>  
                    
            </form:form>  
        </div>  
    </div>  
</div>  
</div> 
	</div>
</body>
</html>