package com.se.nuochoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.nuochoa.entity.ChiTietHoaDon;
import com.se.nuochoa.service.ChiTietHoaDonService;

@Controller
@RequestMapping("/Chitiethoadon")
public class ChiTietHoaDonController {
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@GetMapping("/list-chitiethoadon")
	public String ListChiTietHoadon(Model model) {
		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getAllChiTietHoaDon();
		model.addAttribute("chitiethoadons", chiTietHoaDons);
		return "chitiet-hoadon";
	}
	@GetMapping("/showChiTietHoaDon")
    public String showFormForAdd(Model model,@RequestParam("maHoaDon") String maHD) {
        // create model attribute to bind form data
        ChiTietHoaDon hd = chiTietHoaDonService.getHoaDonTheoMaHd(maHD);
        model.addAttribute("chitiets", hd);
        return "chitiet-hoadon";
    }
}
