package com.se.nuochoa.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.nuochoa.dao.HoaDonDao;
import com.se.nuochoa.entity.ChiTietHoaDon;
import com.se.nuochoa.entity.HoaDon;
import com.se.nuochoa.entity.KhachHang;
import com.se.nuochoa.service.ChiTietHoaDonService;
import com.se.nuochoa.service.HoaDonService;



@Controller
@RequestMapping("/hoadon")
public class HoaDonController {
	@Autowired
	private HoaDonService hoaDonService;
	
	@GetMapping("/list")
	public String ListHoaDon(Model model) {
		List<HoaDon> hoaDon = hoaDonService.getHoaDons();
		model.addAttribute("hoaDons", hoaDon);
		LocalDate fromDate = LocalDate.parse(("2022-04-28"));
		LocalDate toDate = LocalDate.parse( ("2022-05-05"));
		
		List<?> tk = hoaDonService.listHoaDonBan(fromDate, toDate);	
		model.addAttribute("listHoaDonBan", tk);
		
		double tongtien = hoaDonService.tongtienHoaDon(fromDate, toDate);
		model.addAttribute("tongtiens", tongtien);
		
		
		return "hoadon-thongke";
	}
	
	@GetMapping("/list-hoadon")	
	public String ListSanPham(Model model) {
		List<HoaDon> hoaDon = hoaDonService.getAllHoaDon();
		model.addAttribute("hoadons", hoaDon);
		List<?> hd = hoaDonService.getHoaDonTheoMaHd();
		model.addAttribute("tinhtongtiens", hd);
		return "quanly-hoadon";
	}
}
