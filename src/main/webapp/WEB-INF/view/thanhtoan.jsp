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
	
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/thanhtoan.css">
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
</head>
<body>


<script language="javascript">

	
	
	function KiemtraName() {
		var ktra = /^([AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]*)(\s[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]*)*$/;
		var ten = document.getElementById("txtName");
		var hoten = document.getElementById("hoten");
		var kt = ten.value;
		if (!kt.match(ktra)) {
			hoten.innerHTML = "Tên viết hoa chữ cái đầu";
			return false;
		} else {
			hoten.innerHTML = "*";
			return true;
		}
	}
	function formatCash(str) {
			return str.split('').reverse().reduce((prev, next, index) => {
			return ((index % 3) ? next : (next + ',')) + prev
		})
	}
	function Soluong() {
		
		var soluong = document.getElementById("soluong");
		var tongtien = document.getElementById("tongtien");
		var donGia = document.getElementById("total");
		var tong = soLuong.value * donGia.innerHTML;
		var a = tong.toString();
		var gia= formatCash(a);
		soluong.innerHTML = soLuong.value;
		tongtien.innerHTML = gia + "VNĐ";
	}
	function KiemtraEmail() {
		var re = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		var email = document.getElementById("txtEmail");
		var emailloi = document.getElementById("email");
		var kt = email.value;
		if (!kt.match(re)) {
			emailloi.innerHTML = "Email không hợp lệ";
			return false;
		} else {
			emailloi.innerHTML = "3";
			return true;
		}
	}
	

	
</script>
<div class="container">
            <header >
                <div>
			<a href="${pageContext.request.contextPath}/khachhang/khachhangs">	<img  class="im" src="${pageContext.request.contextPath}/resources/img/logo.png" alt="" style="width:150px;height:150px;" /></a>
            <div style="color: red ;width: 150px ;float: left ; margin-top: 10px" >
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
                </ul>
                    
            </div>  
			<div class="box">
			<form class="sbox" action="/search" method="get">
			<input class="stext" type="stext" name="q" placeholder="Tìm kiếm nước hoa...">
			<a class="sbutton" type="submit" href="javascript:void(0);">
			<i class="fa fa-search"></i>
			</a>
			</form>
			<div style="float: right; margin-top: 20px; width: 80px;">
						<form:form action="${pageContext.request.contextPath}/logout"
							method="POST">
							<div class="glyphicon glyphicon-log-out"></div>
							<input style="background-color: white; border: none; margin: 5px"
								type="submit" value="Logout">
						</form:form>
					</div>
            </div>
        
                    </div>
        <div class="cl"></div>
            <div class="logobrandCalvin" >
                <a href=""><h15 class="textlogo">Thanh Toán</h15></a>
            </div>

    </header>
    <security:authentication property="principal.username" var="makhachhang"/>
    <div class="row">
        <div class="col-12 col-md-4 col-lg-6" id="form-thanhtoan">
        	<form:form modelAttribute="thongTinKhachHang" method="post"  action="${pageContext.request.contextPath}/khachhang/thanhtoan/thanhcong?id=${Thanhtoan.maSanPham }&makhachhang=${makhachhang }">
            
            <input type="hidden" name="command" value="thanhcong" />
					
					<div class="input-item">
						<form:label path="">Số lượng:</form:label>
						<form:input path="soLuong" type="text" id="soLuong" name="soluong" size="30" 
							placeholder="Nhập số lượng" onkeyup="Soluong()" value="1"/>
					</div>
					<div class="order-review">
						<table class="input-item" id="order">
							<thead>
								<tr>
									<th class="product_name" style="float: left; width: 300px">Sản phẩm</th>
									<th class="product_quantity" style="width: 200px">Số Lượng</th>
									<th class="product-total" style="width: 200px">Đơn giá</th>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td class="product_name" style="font-weight: bold;"><c:out 
											value="${Thanhtoan.tenSanPham }"></c:out></td>
									<td><strong id="soluong" class="product_quantity">x
											1</strong></td>
									<td id="total" class="product-total"><c:out
											value="${Thanhtoan.giathanh }"></c:out></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="form_tongtien">
						<div>
							<a class="title_tongtien" style="font-weight: bold;">Tổng Tiền: </a> <a id="tongtien"
								class="txt_tongtien" style="font-weight: bold;color: red"><c:out value="${Thanhtoan.giathanh}VNĐ"></c:out></a>
						</div>

					</div>
					<div style="height: 150px">
						<p>Thông tin cá nhân của bạn sẽ được sử dụng để xử lý đơn đặt
							hàng của bạn, hỗ trợ trải nghiệm của bạn trên toàn bộ trang web
							và cho các mục đích khác được mô tả trong</p>
					</div>
					
            <button id="dh" type="submit" style="background-color: black; color: while;margin-left: 180px;width: 150px;height: 50px;font-size: 20px;font-weight: bold">Đặt hàng</button>
            
					
			</form:form>
				




				<script>
					document.getElementById("dh").addEventListener("click",
							function(event) {
								
									alert("Đặt hàng thành công");
								

							});
					
					
					
				</script>
            

      
    </div>

</div>





    <hr>
    </div>
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
                    THÔNG TIN LIÊN HỆ
                </h3>
                <ul id="f1">
                    <li><a href="#">HOTLINE: 19009898<a></li> 
                        <li><a href="#">EMAIL: vuanuochoa@gmai.com<a></li> 
                        <li><a href="#">THỜI GIAN LÀM VIỆC: TỪ THỨ 2 ĐẾN THỨ 6 VÀ TỪ 8H ĐẾN 18H</a></li>
                        <li><a href="#">VĂN PHÒNG: 12 NGUYỄN VĂN BẢO, PHƯỜNG 4, QUẬN GÒ VẤP</a></li>
                </ul>
            </div>
            <div class="col-12 col-sm-6 col-lg-3">
                <h3 class="ftitle">
                    MẠNG XÃ HỘI
                </h3>
                <ul id="f1">
                     <li class="social"> <a href="#" alt="facebook"><img src="../img/fb.png" /></a></li> 
                        <li class="social"><a href="#" alt="instagram"><img src="../img/ins.png" /></a></li> 
                        <li class="social"> <a href="#" alt="twitter"><img src="../img/tw.png" /></a></li>
                        <li class="social"><a href="#" alt="youtube"><img src="../img/yt.png" /></a> </li>
                </ul>
            </div>
            <div class="col-12 col-sm-6 col-lg-3">
                <h3 class="ftitle">
                    Ý KIẾN
                </h3>
                <form id="f1">
                    <input type="email" placeholder="Email của bạn" size="30" style="margin-left: 10px;height: 20px;width: 190px;"/>
                    <i class="glyphicon glyphicon-envelope" style="font-size: 20px; float: left"></i>
                </form>
            </div>

        </div>
            <div class="finfo">
                <p>
                    © 2019 - Công ty TNHH & XNK TC. GPKD số 0158081880 do Sở KH & ĐT TP HỒ CHÍ MINH cấp ngày 19/01/2013
                </p>
            </div>
        </div>


</body>
</html>