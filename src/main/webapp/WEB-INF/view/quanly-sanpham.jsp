<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
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
			max-width: 1300px;
		}
		
	</style>
	
<title>Quản lý sản phẩm</title>
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
			<div class="box">
			<form class="sbox" action="${pageContext.request.contextPath}/khachhang/searchProductAdmin" method="get">
			
			<c:url var="searchProductHome" value="/khachhang/searchProductAdmin?maThuongHieu=${txtSearch}"/>
			<form  action="${searchProductHome}">
				<input class="stext" type="atext" name="txtSearch" placeholder="Tìm kiếm nước hoa..." />
				
				<a href="${searchProduct}" class="sbutton" type="submit" href="javascript:void(0);">
					<i class="fa fa-search"></i>
				</a>
			</form>
			</form>
			</div>
<div class="cl"></div>
    <div class="logobrand" >
        <a href=""><h15 class="textlogo">QUẢN LÝ SẢN PHẨM</h15></a>
    </div>

</header>
  </div>
	 <span class="action_btntable">
	 	<c:url var="showFormAdd" value="/product/showFormAdd"/>
	                 
        <a class="btn_addProduct"  href="${showFormAdd}">Add new product</a>
        
      </span>
    <div class="table_responsive" ">
        <table>
          <thead>
            <tr>
             
              <th>Hình ảnh</th>
              <th >Tên sản phẩm</th>
             
              <th>Xuất xứ</th>
              <th>Số lượng tồn</th>
              <th>Giá thành</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items = "${sanphams}" var ="sanpham">
            	<tr>
	             
	              <td><img src="${sanpham.hinhanh}" alt=""></td>
	              <td>${sanpham.tenSanPham}</td>
	              <td>${sanpham.xuatXu}</td>
	              <td>${sanpham.soLuong}</td>
	              <td>${sanpham.giathanh}</td>
	              <td>
	                <span class="action_btntable">
	                  <c:url var="addUrl" value="/product/showFormUpdate?maSanPham=${sanpham.maSanPham}"/>
	                  <a href="${addUrl}">Edit</a>
	                  <c:url var="deleteSp" value="/product/delete?maSanPham=${sanpham.maSanPham}" />
	                  <a href="${deleteSp}">Remove</a>

	                </span>
	              </td>    
            	</tr>
            </c:forEach>
            
            
          </tbody>
        </table>
      </div>
      
      
      <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
            	<c:forEach items = "${sanpham}" var ="sanpham" >
	                <form action="add" method="post">
	                    <div class="modal-header">						
	                        <h4 class="modal-title">Add Product</h4>
	                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                    </div>
	                    <div class="modal-body">	
	                    	<div class="form-group">
	                            <label>Mã sản phẩm</label>
	                            <input name="maSanPham" type="text" value= "${sanpham.maSanPham}" class="form-control" required>
	                        </div>				
	                        <div class="form-group">
	                            <label>Tên sản phẩm</label>
	                            <input name="name" type="text" value= "${sanpham.tenSanPham}" class="form-control" required>
	                        </div>
	                        <div class="form-group">
	                            <label>Hình ảnh</label>
	                            <input name="image" type="text" value= "${sanpham.hinhanh}" class="form-control" required>
	                        </div>
	                        <div class="form-group">
	                            <label>Giới tính</label>
	                            <input name="price" type="text" value= "${sanpham.gioiTinh}" class="form-control" required>
	                        </div>
	                        <div class="form-group">
	                            <label>Xuất xứ</label>
	                            <input name="xuatXu" type="text" value= "${sanpham.gioiTinh}" class="form-control" required>
	                        </div>
	                        <div class="form-group">
	                            <label>Phong cách</label>
	                            <input name="phongCach" type="text" value= "${sanpham.gioiTinh}" class="form-control" required>
	                        </div>
	                        <div class="form-group">
	                          <label>Giá thành</label>
	                          <input name="giaThanh" type="text" value= "${sanpham.gioiTinh}" class="form-control" required>
	                      </div>
	                      <div class="form-group">
	                        <label>Số lượng</label>
	                        <input name="soLuong" type="text" value= "${sanpham.gioiTinh}" class="form-control" required>
	                    </div>
	                        <div class="form-group">
	                            <label>Thương hiệu</label>
	                            <select name="category" class="form-select" aria-label="Default select example">
	                                <c:forEach items="${thuonghieu}" var="o">
	                                    <option value="${o.maThuongHieu}">${o.tenThuongHieu}</option>
	                                </c:forEach>
	                            </select>
	                        </div>
	
	                    </div>
	                    <div class="modal-footer">
	                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
	                        <input type="submit" class="btn btn-success" value="Add">
	                    </div>
                	</form>
                </c:forEach>
            </div>
        </div>
    </div>





    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="add" method="post">
                    <div class="modal-header">						
                        <h4 class="modal-title">Add Product</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">					
                        <div class="form-group">
                            <label>Tên sản phẩm</label>
                            <input name="name" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Hình ảnh</label>
                            <input name="image" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Giới tính</label>
                            <input name="price" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Xuất xứ</label>
                            <textarea name="title" class="form-control" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Phong cách</label>
                            <textarea name="description" class="form-control" required></textarea>
                        </div>
                        <div class="form-group">
                          <label>Giá thành</label>
                          <textarea name="giaThanh" class="form-control" required></textarea>
                      </div>
                      <div class="form-group">
                        <label>Số lượng</label>
                        <textarea name="soLuong" class="form-control" required></textarea>
                    </div>
                        <div class="form-group">
                            <label>Thương hiệu</label>
                            <select name="category" class="form-select" aria-label="Default select example">
                                <c:forEach items="${listC}" var="o">
                                    <option value="${o.id}">${o.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form>
            </div>
        </div>
    </div>



    <div class="modal fade" id="myModal2" role="dialog">
      <div class="modal-dialog">
          <div class="modal-content">
              <form action="add" method="post">
                  <div class="modal-header">						
                      <h4 class="modal-title">Add Product</h4>
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  </div>
                  <div class="modal-body">					
                      <div class="form-group">
                          <label>Tên sản phẩm</label>
                          <input name="name" type="text" class="form-control" required>
                      </div>
                      <div class="form-group">
                          <label>Hình ảnh</label>
                          <input name="image" type="text" class="form-control" required>
                      </div>
                      <div class="form-group">
                          <label>Giới tính</label>
                          <input name="price" type="text" class="form-control" required>
                      </div>
                      <div class="form-group">
                          <label>Xuất xứ</label>
                          <textarea name="title" class="form-control" required></textarea>
                      </div>
                      <div class="form-group">
                          <label>Phong cách</label>
                          <textarea name="description" class="form-control" required></textarea>
                      </div>
                      <div class="form-group">
                        <label>Giá thành</label>
                        <textarea name="giaThanh" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                      <label>Số lượng</label>
                      <textarea name="soLuong" class="form-control" required></textarea>
                  </div>
                      <div class="form-group">
                          <label>Thương hiệu</label>
                          <select name="category" class="form-select" aria-label="Default select example">
                              <c:forEach items="${listC}" var="o">
                                  <option value="${o.id}">${o.name}</option>
                              </c:forEach>
                          </select>
                      </div>

                  </div>
                  <div class="modal-footer">
                      <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                      <input type="submit" class="btn btn-success" value="Add">
                  </div>
              </form>
          </div>
      </div>
  </div>
      
      
    </div>
</body>
</html>