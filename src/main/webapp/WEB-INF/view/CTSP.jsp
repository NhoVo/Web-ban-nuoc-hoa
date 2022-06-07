<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/chitiet.css">
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
<script>
	function formatCash(str) {
 			return str.split('').reverse().reduce((prev, next, index) => {
 			return ((index % 3) ? next : (next + ',')) + prev
 		})
	}
       function GioiThieuBanThan(){
    	   var tongtien = document.getElementById("thanhtien");
    	   
    	   var gia = ${SP_GUCCI.giathanh};
    	   var gia1 = gia.toString()
    		
    	   tongtien.innerHTML = formatCash(gia1)+"vnđ";
        }

       window.addEventListener("load",function() { GioiThieuBanThan(); });


    </script>

	<div class="container">
		<header>
			<div>
			<security:authorize access="hasAnyRole('CUSTOMER')">
			<security:authentication property="principal.username" var="makhachhang"/>
			<c:url var="user" value="/khachhang/thongtinkh">
				<c:param name="makh" value="${makhachhang }" />
			</c:url>
			</security:authorize>
			<a href="${pageContext.request.contextPath}">	<img  class="im" src="${pageContext.request.contextPath}/resources/img/logo.png" alt="" style="width:150px;height:150px;" /></a>
            <div  style="float: left;">
                <ul class="snip1490" >
                            <li ><a href="#"><b>DANH MỤC</b><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="${pageContext.request.contextPath}/khachhang/Versace"><b>Versace</b></a></li>
                                    <li><a href="${pageContext.request.contextPath}/khachhang/Chanel"><b>Chanel</b></a></li>
                                    <li><a href="${pageContext.request.contextPath}/khachhang/Hermes"><b>Hermes</b></a></li>
                                    <li><a href="${pageContext.request.contextPath}/khachhang/gucci"><b>Gucci</b></a></li>
                                    <li><a href="${pageContext.request.contextPath}/khachhang/Chloe"><b>Chloe</b></a></li>
                                    <li><a href="${pageContext.request.contextPath}/khachhang/Calvin"><b>Calvin Klein</b></a></li>
                                </ul>
                            </li>
                             
                                <li><a href="#"><b> SẢN PHẨM BÁN CHẠY </b></a></li>
                                <li><a href="#"><b> THANH LÝ </b></a></li>                       
                        </ul>
                    
            </div>
            <security:authorize access="hasAnyRole('CUSTOMER')">
					<div style="float: right; width: 250px">
						<div style="float: left; width: 150px">

							<ul class="snip1490"">
								<li id="gly04" onClick="LogoutF();"><a href="${user}"><div
											class="glyphicon glyphicon-user"></div> Tài khoản</a></li>
							</ul>


						</div>
						<div style="float: right; margin-top: 20px; width: 80px;">
							<form:form action="${pageContext.request.contextPath}/logout"
								method="POST" >
									<div class="glyphicon glyphicon-log-out"></div>
								<input style="background-color: white;border: none;margin: 5px" type="submit" value="Logout">
							</form:form>
						</div>

					</div>

				</security:authorize>
				<div style="float: right ;width: 140px" >

					<ul class="snip1490" style="">
						<li id="gly04" onClick="LogoutF();"><a
							href="${pageContext.request.contextPath}/showMyLoginPage"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</ul>

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
			<div class="cl"></div>
			<div class="logobrandCalvin">
				<a href=""><h15 class="textlogo">
					<c:out value="${SP_GUCCI.tenSanPham }"></c:out> </h15></a>
			</div>
			
			
			
			<c:url var="thanhtoan" value="/khachhang/thanhtoan">
				<c:param name="gucciId" value="${SP_GUCCI.maSanPham }" />
				
			</c:url>
			
		</header>
		<div class="container" style="background-color: #fff;">
			<hr>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-8">
					<div class="img"
						style="border: 1px solid #eee; text-align: center;">
						<img
							src="${pageContext.request.contextPath}/resources/img/versace/1.jpg"
							alt="" width="220px" height="500px">
					</div>
				</div>
				<div class="col-12 col-sm-12 col-lg-4" id="gia">
					<div class="thongso">
						<h3>Nước Hoa Nam Versace Eros Man EDT 5ml</h3>
						<table>
							<tbody>
								<tr class="column-1">
									<th>Tên Sản Phẩm</th>
									<td><c:out value="${SP_GUCCI.tenSanPham }"></c:out></td>
								</tr>
								<tr class="column-2">
									<th>Xuất xứ</th>
									<td><c:out value="${SP_GUCCI.xuatXu }"></c:out></td>
								</tr>
								<tr class="column-1">
									<th>Nhãn Hiện</th>
									<td><c:out value="${SP_GUCCI.thuongHieu.tenTHuongHieu }"></c:out></td>
								</tr>
								<tr class="column-2">
									<th>Phong CáchCách</th>
									<td><c:out value="${SP_GUCCI.phongCach }"></c:out></td>
								</tr>
								<tr class="column-1">
									<th>Giới tính</th>
									<td>Nam</td>
								</tr>
								<tr class="column-2">
									<th>Đơn giá</th>
									<td ><label id="thanhtien"> <c:out value="${SP_GUCCI.giathanh }"></c:out></label></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div>
				
						<div class="row" id="submit-bottom" style="width: 100%;">
							
							<button type="button" class="submit submit-2" style="width: 48%;margin-left: 30px">
								<a id="icon-1"><i class="fas fa-credit-card"></i></a> <a
									href="${thanhtoan }">Đặt Hàng</a><br>
							</button>
						</div>
						
					</div>

				</div>
			</div>
		</div>
		<hr>
	</div>
	<div class="footer container">
		<div class="row">
			<div class="col-12 col-sm-6 col-lg-3">
				<h3 class="ftitle">GIỚI THIỆU</h3>
				<ul id="f1">
					<li><a href=""></a></li>
					<li><a href="">Chịu trách nhiệm nội dung:</a></li>
					<li><a href="">Võ Thành Nhớ </a></li>
					<li><a href="">Hoàng Thị Tố Thùy</a></li>
					<li><a href="">Hoàng Tiến Mạnh Đức</a></li>
					<li><a href="">Phan Nguyễn Tấn Trọng</a></li>
					<li><a href="">Đào Cao Thắng</a></li>
				</ul>
			</div>
			<div class="col-12 col-sm-6 col-lg-3">
				<h3 class="ftitle">THÔNG TIN LIÊN HỆ</h3>
				<ul id="f1">
					<li><a href="#">HOTLINE: 19009898<a></li>
					<li><a href="#">EMAIL: vuanuochoa@gmai.com<a></li>
					<li><a href="#">THỜI GIAN LÀM VIỆC: TỪ THỨ 2 ĐẾN THỨ 6 VÀ
							TỪ 8H ĐẾN 18H</a></li>
					<li><a href="#">VĂN PHÒNG: 12 NGUYỄN VĂN BẢO, PHƯỜNG 4,
							QUẬN GÒ VẤP</a></li>
				</ul>
			</div>
			<div class="col-12 col-sm-6 col-lg-3">
				<h3 class="ftitle">MẠNG XÃ HỘI</h3>
				<ul id="f1">
					<li class="social"><a href="#" alt="facebook"><img
							src="../img/fb.png" /></a></li>
					<li class="social"><a href="#" alt="instagram"><img
							src="../img/ins.png" /></a></li>
					<li class="social"><a href="#" alt="twitter"><img
							src="../img/tw.png" /></a></li>
					<li class="social"><a href="#" alt="youtube"><img
							src="../img/yt.png" /></a></li>
				</ul>
			</div>
			<div class="col-12 col-sm-6 col-lg-3">
				<h3 class="ftitle">Ý KIẾN</h3>
				<form id="f1">
					<input type="email" placeholder="Email của bạn" size="30"
						style="margin-left: 10px; height: 20px; width: 190px;" /> <i
						class="glyphicon glyphicon-envelope"
						style="font-size: 20px; float: left"></i>
				</form>
			</div>

		</div>
		<div class="finfo">
			<p>© 2019 - Công ty TNHH & XNK TC. GPKD số 0158081880 do Sở KH &
				ĐT TP HỒ CHÍ MINH cấp ngày 19/01/2013</p>
		</div>
	</div>
</body>
</html>