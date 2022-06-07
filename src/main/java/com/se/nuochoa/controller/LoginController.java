package com.se.nuochoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.se.nuochoa.entity.SanPham;
import com.se.nuochoa.service.SanPhamSevice;

@Controller
public class LoginController {
	@Autowired 
	private SanPhamSevice sevicesDao;
	@GetMapping("/")
	public String showHomePage(Model theModel) {
		List<SanPham> spBanChay = sevicesDao.getSPBanChay();
		theModel.addAttribute("spBanChay",spBanChay);
		List<SanPham> spGiamgia = sevicesDao.getSPGiamGia();
		theModel.addAttribute("spGiamGia",spGiamgia);
		List<SanPham> spKhac = sevicesDao.getSPAll();
		theModel.addAttribute("spKhac",spKhac);
		return "home";
	}

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}

	// add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
	
//	@GetMapping("/logout")
//	public String showLogoutPage() {
//		return "fancy-login";
//	}
}
