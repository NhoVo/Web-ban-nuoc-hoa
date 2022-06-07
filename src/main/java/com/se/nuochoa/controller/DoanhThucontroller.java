package com.se.nuochoa.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.se.nuochoa.entity.HoaDon;
import com.se.nuochoa.service.HoaDonService;

@Controller
public class DoanhThucontroller {
	@Autowired
	private HoaDonService hoaDonService;
	private String ngayBatDau,ngayKetThuc;
	
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/hoadon/list-load", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody List<?> reloadTongDonHangTable(HttpServletRequest req) {
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		List<?> listDonHangBan = hoaDonService.listHoaDonBan(ngayBatDau,ngayKetThuc);
				
		return listDonHangBan;
	}
	@RequestMapping("/hoadon/list")
	public String ListHoaDon(Model model) {	
		return "hoadon-thongke";
}
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/bao-cao-doanh-thu-load", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody double tongtien(HttpServletRequest req) {
		
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		 
		double tongtien = hoaDonService.tongtienHoaDon(ngayBatDau, ngayKetThuc);				
		return tongtien;
	}
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/hoa-don-chua-thanh-toan", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody int hoadonchuathanhtoan(HttpServletRequest req) {
		
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		 
		int HDCTT = hoaDonService.SoHoaDonchuaThanhToan(ngayBatDau, ngayKetThuc);				
		return HDCTT;
	}
	@JsonIgnore
	@JsonManagedReference
	@JsonBackReference
	@RequestMapping(value = "/quan-ly/hoa-don-da-thanh-toan", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	public @ResponseBody int hoadondathanhtoan(HttpServletRequest req) {
		
		ngayBatDau = req.getParameter("ngayBatDau");
		ngayKetThuc = req.getParameter("ngayKetThuc");
		 
		int HDDTT = hoaDonService.SoHoaDondaThanhToan(ngayBatDau, ngayKetThuc);				
		return HDDTT;
	}

}



