<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Edit Product </title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />

    <script src="<c:url value ='/resources/js/jquery.min.js'/>"></script>
    <script src="<c:url value ='/resources/js/jquery-1.10.2.min'/>"></script>
    <script src="<c:url value ='/resources/js/bootstrap.min.js'/>"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/update-form/fontawesome.min.css" />

    
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/update-form/jquery-ui.min.css" type="text/css" />
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/update-form/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/update-form/templatemo-style.css">

</head>
<body>
	<div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
            <div class="row">
              <div class="col-12">
              
                <h2 class="tm-block-title d-inline-block">Edit Product</h2>
             
              </div>
            </div>
            <div class="row tm-edit-product-row">
              
                 
	           <div class="col-xl-6 col-lg-6 col-md-12">
	           
	               		<c:url var="updateUrl" value="/product/updateProduct" />
	             		<form:form modelAttribute="sp" method="POST" action="${updateUrl}">
	             				<div class="form-group mb-3">
				                    <form:label for="name" path="maSanPham">Mã sản phẩm </form:label>
				                    <form:input
				                      path = "maSanPham"
				                      readonly="true"
				                      type="text"
				                      class="form-control validate"/>
			                  	</div>
			                  	
	             				<div class="form-group mb-3">
				                    <form:label for="name" path="tenSanPham">Tên sản phẩm </form:label>
				                    <form:input
				                      path = "tenSanPham"
				                      id="name"
				                      name="name"

				                      type="text"
				                      class="form-control validate"/>
			                  	</div>
			                  	
			                  	<div class="form-group mb-3">
				                    <form:label for="description" path="phongCach">Phong cách</form:label>
				                    <form:textarea                    
				                      class="form-control validate tm-small"
				                      rows="5"
				                   	  path="phongCach"
				                     
				                      ></form:textarea>
		                  		</div>
		                  		
		                  		<div class="form-group mb-3">
				                    <form:label for="name" path="xuatXu">Xuất xứ </form:label>
				                    <form:input
				                      id="xuatXu"
				                      path = "xuatXu"
				                      name="name"
				                     
				                      type="text"
				                      class="form-control validate"/>
			                  	</div>
			                  	
			                  	<div class="form-group mb-3">
				                    <form:label for="name" path="giathanh">Đơn giá </form:label>
				                    <form:input
				                      path="giathanh"
				                      value="${sanphams.giathanh}"
				                      type="text"
				                      class="form-control validate"/>
			                  	</div>
			                  	
			                  	<div class="form-group mb-3">
				                    <form:label for="name" path="gioiTinh">Giới tính </form:label>
				                    <form:select
						                      path="gioiTinh"
						                      class="custom-select tm-select-accounts"
						                      name="gioiTinh">	
						                      			<form:option value="0">Nam</form:option>
						                      			<form:option value="1">Nữ</form:option>
					                    </form:select>
			                  	</div>
			                  	
			                  	<div class="form-group mb-3">
				                    <form:label for="name" path="soLuong">Số lượng tồn </form:label>
				                    <form:input
				                      id="soLuong"
				                      path="soLuong"
				                      name="name"
				                      
				                      type="text"
				                      class="form-control validate"/>
			                  	</div>
			                  	
			                  	<div class="form-group mb-3">
					                    <label for="category">Nhãn hiệu</label>
					                    
					                    <form:select
						                      path="thuongHieu.maThuongHieu"
						                      class="custom-select tm-select-accounts"
						                      name="maThuongHieu">
						                      <c:forEach items="${thuonghieu}" var ="s"> 			
						                      			<option value="${s.maThuongHieu}" >${s.tenTHuongHieu}</option>
						                      </c:forEach>
					                    </form:select>
					                    
				                 </div>
				                 </div>
				                 <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
						                <div class="tm-product-img-edit mx-auto">
						                  <form:label path="hinhanh" for="description"
						                  >Hình ảnh</form:label>
						                  
                						<form:textarea class="form-control validate tm-small"  path="hinhanh" rows="5" ></form:textarea>
                				  		</div>
                				 <div class="custom-file mt-3 mb-3">
					                  <input id="fileInput" type="file" style="display:none;" />
					                  <input
					                    type="button"
					                    class="btn btn-primary btn-block mx-auto"
					                    value="CHANGE IMAGE NOW"
					                    onclick="document.getElementById('fileInput').click();"
					                  />
					                </div>
                				  
	             		
	               
              </div>
                	<div class="col-12">
		                <button type="submit" value="Save" class="btn btn-primary btn-block text-uppercase">Update Now</button>
		             </div>
              
                 </form:form>
                  
                  
                  
             				
		              
               
            
           
            </div>
	                
	                
            
          </div>
        </div>
      </div>
    </div>
    </div>
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
    <!-- https://jqueryui.com/download/ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
    <script>
      $(function() {
        $("#expire_date").datepicker({
          defaultDate: "10/22/2020"
        });
      });
    </script>
  </body>
</body>
</html>