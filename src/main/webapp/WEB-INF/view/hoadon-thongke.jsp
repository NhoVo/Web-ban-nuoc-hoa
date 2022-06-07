<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<script>
	var contextPath = "${pageContext.request.contextPath}"
</script>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=" utf-8" />
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-1.10.2.min'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/responsive.css">
<title>Quản Lý Nước Hoa</title>
</head>

<body>
	<div class="container">
		<header style="height:550px">
			<div>
			<security:authentication property="principal.username" var="makhachhang"/>
			<c:url var="user" value="/khachhang/thongtinkh">
				<c:param name="makh" value="${makhachhang }" />
			</c:url>
			<a href="${pageContext.request.contextPath}/khachhang/khachhangs">	<img  class="im" src="${pageContext.request.contextPath}/resources/img/logo.png" alt="" style="width:150px;height:150px;" /></a>
            <div  style="float: left;">
                <ul class="snip1490" >
                				
	                  			<c:url var="showQuanLySanPham" value="/product/list-sanpham"/>
                            	<li><a href="${showQuanLySanPham}"><b>QUẢN LÝ SẢN PHẨM </b></a></li>
                            	
                            	
                                <li><a href="${pageContext.request.contextPath}/hoadon/list-hoadon"><b>QUẢN LÝ ĐƠN HÀNG </b></a></li>
                                <c:url var="showQuanLyKhachHang" value="/khachhang/list"/>
                                
                                <li><a href="${showQuanLyKhachHang}"><b>QUẢN LÝ KHÁCH HÀNG </b></a></li>
                                
                                <li><a href="${pageContext.request.contextPath}/hoadon/list"><b>THỐNG KÊ </b></a></li>                       
                        </ul>
                    
            </div>
            <div style="float: right; margin-top: 20px; width: 80px;">
							<form:form action="${pageContext.request.contextPath}/logout"
								method="POST" >
									<div class="glyphicon glyphicon-log-out"></div>
								<input style="background-color: white;border: none;margin: 5px" type="submit" value="Logout">
							</form:form>
						</div>
             
			<div class="box" style="">
			<form class="sbox" action="/search" method="get">
			<input class="stext" type="stext" name="q" placeholder="Tìm kiếm nước hoa...">
			<a class="sbutton" type="submit" href="javascript:void(0);">
			<i class="fa fa-search"></i>
			</a>
			</form>
			
			
            </div>
			</div>
<!--Menu------------------------------------------------------------------------------------------------------>

							
             <!--end menu-------------------------------------------------------------------------------------------------->
			 
   
			 
			 
</header>
		<div class="row" style="margin-top: -350px; width: 100%;">
			<div class="col-12">
				<!-- Lay ds hoa don -->


				<h4 style="font-family: 'Times New Roman', Times, serif;">Chọn
					mốc thời gian thống kê</h4>
				<p>
					Từ ngày : <input type="date" id="ngayBatDau" class=" col-3">
					<span class="text-danger" id="ktngaybatdau">*</span>
				</p>
				<p>
					Đến Ngày : <input type="date" id="ngayKetThuc" class=" col-3">
					<span class="text-danger" id="ktngayKetThuc">*</span>
				</p>
				<span class="text-danger" id="kthople"></span> <br> 
				<input type="submit"  class="btnxacnhan form-control-lg" id="btnxacnhan" value="Xác Nhận" />

			</div>
			<div class="col-12"
				style="background-color: darkgrey; margin-top: 10px;">

				<span style="font-size: 16px; font-weight: bold"> Tổng hóa
					đơn : </span> <span id="tonghd" style="font-size: 16px; font-weight: bold">
					<c:out value="${listHoaDonBan.size()}" />
				</span> <br> <span style="font-size: 16px; font-weight: bold">
					Tổng doanh thu : </span> <span id="tongDoanhThu"
					style="font-size: 16px; font-weight: bold"> <c:out
						value="${tongtiens}" />
				</span> 
				<br> 
				<span style="font-size: 16px; font-weight: bold">
					Số hóa đơn Chưa thanh toán : </span> 
					<span id="sohdctt" style="font-size: 16px; font-weight: bold"> 
					<c:out value="" /></span><br> 
				<span style="font-size: 16px; font-weight: bold">
					Số hóa đơn đã thanh toán : </span> 
					<span id="sohddtt" style="font-size: 16px; font-weight: bold"> 
					<c:out value="" /></span>



			</div>
			<div class="col-12 p-0">
				<table class="table table-striped" role="table">
				<thead>
					<tr>
						<th>Mã Hóa đơn</th>
						<th>Mã Khách Hàng</th>
						<th>ngày lập</th>
						<th>Thành tiền</th>
						<th>Trạng Thái</th>
					</tr>
					<thead/>
					<tbody  id="donHangBanTable">
					<c:forEach items="${listHoaDonBan}" var="tk" >
						<tr >

							<th><c:out value="${tk[0]}" /></th>
							<th><c:out value="${tk[1]}" /></th>
							<th><c:out value="${tk[2]}" /></th>
							<th><c:out value="${tk[3]}" /></th>
							<th><c:out value="${tk[4]}" /></th>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="<c:url value='/resources/js/thongKe.js'/>"></script>
</body>


</html>