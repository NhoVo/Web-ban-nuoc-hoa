<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
    	<meta charset="UTF-8">
<meta  http-equiv="Content-Type" content="text/html; charset="utf-8" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
 	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
     <script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
     <script src="<c:url value='/resources/js/jquery-1.10.2.min'/>"></script>
     <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
 	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/styless.css" rel="stylesheet" />

 	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
 	<link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
    integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">  
    
        <c:url var="pattern" value="/resources/img/chloe.png" />      
 
    <title> Quản Lý Nước Hoa </title>
    
	
    </head>

    <body>        
        <div class="container">
        <header style="height:550px">
			<div>
			
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
                                
                                <c:url var="banChay" value="/khachhang/banChayHome"/>
                                <li><a href="${banChay}"><b> SẢN PHẨM BÁN CHẠY </b></a></li>
                                <c:url var="thanhLy" value="/khachhang/thanhLyHome"/>
                                <li><a href="${thanhLy}"><b> THANH LÝ </b></a></li>                      
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
			<div class="box">
			<form class="sbox" action="${pageContext.request.contextPath}/khachhang/searchProductHome" method="get">
			
			<c:url var="searchProduct" value="/khachhang/searchProduct?maThuongHieu=${txtSearch}"/>
			<form  action="${searchProduct}">
				<input class="stext" type="atext" name="txtSearch" placeholder="Tìm kiếm nước hoa..." />
				
				<a href="${searchProduct}" class="sbutton" type="submit" href="javascript:void(0);">
					<i class="fa fa-search"></i>
				</a>
			</form>
			</form>
			</div>
            <!--Menu------------------------------------------------------------------------------------------------------>

							
             <!--end menu-------------------------------------------------------------------------------------------------->
			 <div class="cl"> </div>
			 <div class="slidershow middle">

				<div class="slides">
				<input type="radio" name="r" id="r1" checked>
				<input type="radio" name="r" id="r2">
				<input type="radio" name="r" id="r3">
				
				<div class="slide s1">
				<img src="${pageContext.request.contextPath}/resources/img/VERSACE-PERFUME.PNG"  alt="" style="width:1080px;height:350px;" />
				</div>
				<div class="slide">
				<img src="${pageContext.request.contextPath}/resources/img/chloe.png" alt="" style="width:1080px;;height:350px;" />
				</div>
				<div class="slide">
				<img src="${pageContext.request.contextPath}/resources/img/nuochoa.jpg" alt="" style="width:1080px;;height:350px;" />
				</div>
        
				</div>
				<div class= "m-auto">
				<div class="auto-bt1"></div>
				<div class="auto-bt2"></div>
				<div class="auto-bt3"></div>
				
				</div>

				<div class="navigation">
				<label for="r1" class="bar"></label>
				<label for="r2" class="bar"></label>
				<label for="r3" class="bar"></label>
				
				</div>
    </div>
			 
			 
    </header>
  
     
    <div class="row">
        <div class="container padding">
            <div style=" margin-top: 15px; padding-bottom: 10px; padding-top: 10px; overflow: hidden; display: block; border-bottom: 1px solid #f3f3f3; border: 1px solid #f3f3f3; border-right: 1px solid #f3f3f3 !important;">
                <h6 style="color: black; display: block; width: 100%; margin-top: 0; float: left; margin-bottom: 0;font-size: 15px; font-weight: 600; font-family: inherit; line-height: 1.2;">SẢN PHẨM NỔI BẬT</h6>
            </div>
            <div class="row padding">          
                <c:forEach items="${spBanChay}" var="spBanChay">
							<c:url var="ctsp" value="/khachhang/id">
								<c:param name="gucciId" value="${spBanChay.maSanPham }" />
							</c:url>
							<div class="col-lg-2 mb-4 text-center">
									<div class="product-entry border">
										<a href="${ctsp }"
											class="prod-img"> <img
											src="${spBanChay.hinhanh }"
											alt="Free html5 bootstrap 4 template" style="width: 150px;height: 150px">
										</a>
										<div class="desc">
											<h2>
												<a href="${ctsp }"><c:out
														value="${spBanChay.tenSanPham}"></c:out> </a>
											</h2>
											<span class="price"><c:out
														value="${spBanChay.giathanh}"></c:out></span>
										</div>
									</div>
								</div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container padding">
            <div style=" margin-top: 15px; padding-bottom: 10px; padding-top: 10px; overflow: hidden; display: block; border-bottom: 1px solid #f3f3f3; border: 1px solid #f3f3f3; border-right: 1px solid #f3f3f3 !important;">
                <h6 style="color: black; display: block; width: 100%; margin-top: 0; float: left; margin-bottom: 0;font-size: 15px; font-weight: 600; font-family: inherit; line-height: 1.2;">SẢN PHẨM KHÁC</h6>
            </div>
            <div class="row padding">
                <c:forEach items="${spKhac}" var="spKhac">
							<c:url var="ctsp" value="/khachhang/id">
								<c:param name="gucciId" value="${spKhac.maSanPham }" />
							</c:url>
							<div class="col-lg-2 mb-4 text-center">
								<a href="${ctsp }" class="prod-img"> <img
									src="${spKhac.hinhanh }"
									class="img-fluid" alt="Free html5 bootstrap 4 template">
								</a>
								<div class="desc">
									<h2>
										<a href="${ctsp}"><c:out value="${spKhac.tenSanPham }"></c:out>
										</a>
									</h2>
									<span class="price"><c:out
														value="${spKhac.giathanh}"></c:out></span>
								</div>
							</div>
							
						</c:forEach>
                
            </div>
        </div>
    </div>
    <br>
    </div>
    <hr>
         
    <!--footer---------------------------------------------------------------------------------------->
     <div class="footer container">
        <div class="row">
            <div class="col-12 col-sm-6 col-lg-3">
                <h3 class="ftitle">
                GIỚI THIỆU
                </h3>
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
                <h3 class="ftitle">
                    MENU
                </h3>
                <ul id="f1">
                    <li><a href="#"><a>KHUYẾN MÃI</li> 
                        <li><a href="#"><a>SẢN PHẨM MỚI</li> 
                        <li><a href="#">SẢN PHẨM BÁN CHẠY</a></li>
                        <li><a href="#">THANH LÝ</a></li>
                </ul>
            </div>
            <div>
                <h3>Ý KIẾN</h3>
                <input type="email" placeholder="Email của bạn" size="30" style="margin: 10px 0;height: 100px;width: 300px;"/>
                <button type="button" class="btn btn-default btn-sm" style="margin:-3px 0 0 -5px; height:30px; display:inline-block;">
                    <span class="glyphicon glyphicon-envelope"></span>
                </button>
            </div>
            <div class="social_all">

                    <!-- <h3>MẠNG XÃ HỘI</h3> -->
                    <div class="social">
                        <a href="#" alt="facebook"><img src="${pageContext.request.contextPath}/resources/img/fb.png" /></a>
                    </div>
                    <div class="social">
                        <a href="#" alt="instagram"><img src="${pageContext.request.contextPath}/resources/img/ins.png" /></a>
                    </div>
                    <div class="social">
                        <a href="#" alt="twitter"><img src="${pageContext.request.contextPath}/resources/img/tw.png" /></a>      
                    </div>
                    <div class="social">
                        <a href="#" alt="youtube"><img src="${pageContext.request.contextPath}/resources/img/yt.png" /></a>    
            </div>
        </div>
        </div>
            <div class="finfo">
                <p>
                    © 2019 - Công ty TNHH & XNK TC. GPKD số 0158081880 do Sở KH & ĐT TP Hà Nội cấp ngày 19/01/2013
                </p>
            </div>
        </div>
        
        
     
    </body>
</html>