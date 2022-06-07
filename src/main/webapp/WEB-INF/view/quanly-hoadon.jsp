<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en"></html>
<head>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta http-equiv="Content-Type" content="text/html; charset=" utf-8" />
 	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
     <script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
     <script src="<c:url value='/resources/js/jquery-1.10.2.min'/>"></script>
     <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
 	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
 	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
 	<link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
    integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous"> 
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style3.css">
	
	<style>
		.table_responsive{
			max-width: 1100px;
		}
	</style>
	
	<title>Quản lý hoa đơn</title>
	
	
</head>
<body>
  <div class="container">
		<header style="height:10px">
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
<div class="cl"></div>
    <div class="logobrand" >
        <a href=""><h15 class="textlogo">QUẢN LÝ HÓA ĐƠN</h15></a>
    </div>
</header>
  </div>
    <div class="table_responsive">
        <table>
          <thead>
            <tr>
              <th>Mã hóa đơn</th>
              <th>Tên khách hàng</th>
              <th>Số điện thoại</th>
              <th>Thời gian</th>
              <th>Tổng tiền</th>
              <th>Tình trạng</th>
              <th>Hoạt động</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items = "${hoadons}" var ="hoadon" varStatus="index">
            <tr>
              <td>${hoadon.maHoaDon}</td>
              <td>${hoadon.khachHang.tenKhachHang}</td>
              <td>${hoadon.khachHang.soDienThoaikh}</td>
              <td>${hoadon.ngayLap}</td>
              <td>${tinhtongtiens[index.index]}VNĐ</td>
              <td>${hoadon.trangThai}</td>
              <td>
                <span class="action_btntable">
                  <c:url var="showChiTietHoaDon" value="/Chitiethoadon/showChiTietHoaDon?maHoaDon=${hoadon.maHoaDon}"/>
                    <a class="btn_chitiet"  href="${showChiTietHoaDon}">Chi Tiết</a>
                  
                </span>
              </td>
            </tr>
            </c:forEach>
 
          </tbody>
        </table>
      </div>
   
</body>