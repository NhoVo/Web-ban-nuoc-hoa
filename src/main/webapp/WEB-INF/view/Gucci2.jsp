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
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
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
                                <c:url var="banChay" value="/khachhang/banChay"/>
                                <li><a href="${banChay}"><b> SẢN PHẨM BÁN CHẠY </b></a></li>
                                
                                <c:url var="thanhly" value="/khachhang/thanhLy"/>
                                <li><a href="${thanhly}"><b> THANH LÝ </b></a></li>                       
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
            
            
            </div >  
			<div class="box">
			<form class="sbox" action="${pageContext.request.contextPath}/khachhang/searchProductHome" method="get">
			
			<c:url var="searchProduct" value="/khachhang/searchProduct?txtSearch=${txtSearch}"/>
			
			<form  action="${searchProduct}">
				<input class="stext" type="atext" name="txtSearch" placeholder="${txtSearch}" value="${gtSearch}"/>
				
				<a href="${searchProduct}" class="sbutton" type="submit" href="javascript:void(0);">
					<i class="fa fa-search"></i>
				</a>
			</form>
			</form>
			
			
            </div>
			
        <div class="cl"></div>
            <div class="logobrandCalvin" >
                <a href=""><h15 class="textlogo"><c:out value="${THUONGHIEU}"></c:out></h15></a>
            </div>
    </header>
    



		<div class="colorlib-product">
			<div class="bodycontainer">
				<div class="row">
					<div class="col-lg-3 col-xl-3">
						<div class="row">
							<div class="col-sm-12">
								<div class="side border mb-1">
									<h3>Brand</h3>
									<ul>
										<li><a href="${pageContext.request.contextPath}/khachhang/Versace">Versace</a></li>
										<li><a href="${pageContext.request.contextPath}/khachhang/Chanel">Channel</a></li>
										<li><a href="${pageContext.request.contextPath}/khachhang/Hermes">Hermes</a></li>
										<li><a href="${pageContext.request.contextPath}/khachhang/gucci">Gucci</a></li>
										<li><a href="${pageContext.request.contextPath}/khachhang/Chloe">Chloe</a></li>
										<li><a href="${pageContext.request.contextPath}/khachhang/Calvin">Calvin Klein</a></li>
									</ul>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="side border mb-1">
									<h3>Kích thước</h3>
									<div class="block-26 mb-2">
										<h4>ml</h4>
										<ul>
										
										
										
										
											<c:url var="product75Home" value="/khachhang/product75mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product75Home}">7.5</a></li>
											
											
		                                    <c:url var="product10" value="/khachhang/product10mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product10}">10</a></li>
											
											<c:url var="product15" value="/khachhang/product15mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product15}">15</a></li>
											
											<c:url var="product20" value="/khachhang/product20mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product20}">20</a></li>
											
											<c:url var="product30" value="/khachhang/product30mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product30}">30</a></li>
											
											<c:url var="product50" value="/khachhang/product50mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product50}">50</a></li>
											
											<c:url var="product100" value="/khachhang/product100mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product100}">100</a></li>
											
											<c:url var="product120" value="/khachhang/product120mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product120}">120</a></li>
											
											<c:url var="product150" value="/khachhang/product150mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product150}">150</a></li>
											
											<c:url var="product200" value="/khachhang/product200mlHome?txtSearch=${gtSearch}"/>
											<li><a href="${product200}">200</a></li>

										</ul>
									</div>
									<!-- <div class="block-26">
                                    <h4>Width</h4>
                               <ul>
                                  <li><a href="#">M</a></li>
                                  <li><a href="#">W</a></li>
                               </ul>
                            </div> -->
								</div>
							</div>
							<div class="col-sm-12">
								<div class="side border mb-1">
									<h3>Money</h3>
									<ul>
										<c:url var="duoi500" value="/khachhang/productduoi500Home?txtSearch=${gtSearch}"/>
                                		
										<li><a href="${duoi500}">Dưới 500.000</a></li>
										<c:url var="tu500Den1000" value="/khachhang/product500-1000Home?txtSearch=${gtSearch}"/>
										<li><a href="${tu500Den1000}">500.000 - 1.000.000</a></li>
										
										<c:url var="tu1000Den2000" value="/khachhang/product1000-2000Home?txtSearch=${gtSearch}"/>
										<li><a href="${tu1000Den2000}">1.000.000 - 2.000.000</a></li>
										
										<c:url var="tu2000Den5000" value="/khachhang/product2000-5000Home?txtSearch=${gtSearch}"/>
										<li><a href="${tu2000Den5000}">2.000.000 - 5.000.000</a></li>
										
										<c:url var="tren5000" value="/khachhang/productTren5000Home?txtSearch=${gtSearch}"/>
										<li><a href="${tren5000}">Trên 5.000.000</a></li>
									</ul>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="side border mb-1">
									<h3>Giới tính</h3>
									<ul>
										<c:url var="man" value="/khachhang/productMenHome?txtSearch=${gtSearch}"/>
										<li><a href="${man}">Man</a></li>
										<c:url var="woman" value="/khachhang/productWomanHome?txtSearch=${gtSearch}"/>
										<li><a href="${woman}">Woman</a></li>
									</ul>
								</div>
							</div>

						</div>
					</div>
					<div class="col-lg-9 col-xl-9">
						<div class="row row-pb-md">
							<c:forEach items="${Gucci}" var="gucci">
								<c:url var="ctsp" value="/khachhang/id">
									<c:param name="gucciId" value="${gucci.maSanPham }" />
								</c:url>
								
								
								<div class="col-lg-4 mb-4 text-center">
									<div class="product-entry border">
										<a href="${ctsp }"
											class="prod-img"> <img
											src="${gucci.hinhanh}" class="img-fluid"
											alt="Free html5 bootstrap 4 template">
										</a>
										<div class="desc">
											<h2>
												<a href="${ctsp }"><c:out
														value="${gucci.tenSanPham}"></c:out> </a>
											</h2>
											<span class="price"><c:out
														value="${gucci.giathanh}"></c:out></span>
										</div>
									</div>
								</div>
							</c:forEach>

							<div class="w-100"></div>



						</div>
						<div class="row">
							<div class="col-md-12 text-center">
								<div class="block-27">
									<ul>
										<li><a href="#"><i class="ion-ios-arrow-back"></i></a></li>
										<li class="active"><span>1</span></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#"><i class="ion-ios-arrow-forward"></i></a></li>
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
				<h3 class="ftitle">MENU</h3>
				<ul id="f1">
					<li><a href="#"><a>KHUYẾN MÃI</li>
					<li><a href="#">SẢN PHẨM BÁN CHẠY</a></li>
					
					<li><a href="#">THANH LÝ</a></li>
				</ul>
			</div>
			<div>
				<h3>Ý KIẾN</h3>
				<input type="email" placeholder="Email của bạn" size="30"
					style="margin: 10px 0; height: 100px; width: 300px;" />
				<button type="button" class="btn btn-default btn-sm"
					style="margin: -3px 0 0 -5px; height: 30px; display: inline-block;">
					<span class="glyphicon glyphicon-envelope"></span>
				</button>
			</div>
			<div class="social_all">

				<!-- <h3>MẠNG XÃ HỘI</h3> -->
				<div class="social">
					<a href="#" alt="facebook"><img src="../img/fb.png" /></a>
				</div>
				<div class="social">
					<a href="#" alt="instagram"><img src="../img/ins.png" /></a>
				</div>
				<div class="social">
					<a href="#" alt="twitter"><img src="../img/tw.png" /></a>
				</div>
				<div class="social">
					<a href="#" alt="youtube"><img src="../img/yt.png" /></a>
				</div>
			</div>
		</div>
		<div class="finfo">
			<p>© 2019 - Công ty TNHH & XNK TC. GPKD số 0158081880 do Sở KH &
				ĐT TP Hà Nội cấp ngày 19/01/2013</p>
		</div>
	</div>
</body>
</html>