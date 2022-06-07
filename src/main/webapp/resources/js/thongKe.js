$(document).ready(function(e) {
	function tongDonHangTable() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/hoadon/list-load`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {
			 var table = document.getElementById("donHangBanTable")
			 var trangthai=null;
			 var tonghd=data.length;
			 document.getElementById("tonghd").innerHTML=tonghd
			var items = data.map((e) => {
				if(e[4]==0)
				{
					trangthai="Chưa thanh toán"
				}
				else
				{
					trangthai="đã thanh toán"
				}
				return `
					<tr>
										<td>${e[0]}</td>
										<td>${e[1]}</td>
										<td>${new Date(e[2]).toLocaleDateString()}</td>
										<td>${formatCurrency(e[3])}</td>
										<td>${trangthai}</td>
									</tr>
					`
			})
			table.innerHTML = items.join(""); 
		},
		error: function(e) {
			console.log(e);
		},
	});
}
function formatCurrency(number) {
    // if (isNaN(number)) return number;
    return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
    }).format(number);
}

function XuLiTrenGiaoDien() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/bao-cao-doanh-thu-load`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {

			document.getElementById("tongDoanhThu").innerHTML = formatCurrency(data);
			
		},
		error: function(e) {
			console.log(e);
		},
	});
	
}
function hoadonchuathanhtoan() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/hoa-don-chua-thanh-toan`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {

			document.getElementById("sohdctt").innerHTML = data;
			
		},
		error: function(e) {
			console.log(e);
		},
	});
	
}
function hoadondathanhtoan() {
	var ngayBatDau = document.getElementById("ngayBatDau").value;
	var ngayKetThuc = document.getElementById("ngayKetThuc").value;
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/quan-ly/hoa-don-da-thanh-toan`,
		dataType: "json",
		data: {
			ngayBatDau,
			ngayKetThuc,
		},
		timeout: 100000,

		success: function(data) {

			document.getElementById("sohddtt").innerHTML = data;
			
		},
		error: function(e) {
			console.log(e);
		},
	});
	
}
	   function  KiemtraNBD() {

        var nkh = new Date($("#ngayBatDau").val());
        var today = new Date();
        if (nkh > today) {
$("#ktngaybatdau").html("Ngày bắt đầu không lớn hơn ngày hiện tại");
            return true;
        } else {
            $("#ktngaybatdau").html("*");
            return false;
        }

    }
    	   function  KiemtraNKT() {

        var nkh = new Date($("#ngayKetThuc").val());
        var today = new Date();
        if (nkh <= today) {
				 $("#ktngayKetThuc").html("*");
	            return false;

        } else {
	        $("#ktngayKetThuc").html("không lớn hơn ngày hiện tại");
            return true;
        }

    }
      	   function  KiemtraNgay() {

        var nkt = new Date($("#ngayKetThuc").val());
        var nbd = new Date($("#ngayBatDau").val());
        if (nbd > nkt) {
            $("#kthople").html("Ngày không hợp lệ");
            return true;
        } else {
            $("#kthople").html("");
            return false;
        }

    }
	 $("#btnxacnhan").click(function() { 
		
		if(KiemtraNBD()==false && KiemtraNKT()==false &&KiemtraNgay()==false)
		{
			XuLiTrenGiaoDien()
			tongDonHangTable()
			hoadonchuathanhtoan()
			hoadondathanhtoan()
		}

	 });

  });
