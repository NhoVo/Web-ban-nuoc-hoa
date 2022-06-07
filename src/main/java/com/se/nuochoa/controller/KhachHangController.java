package com.se.nuochoa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.nuochoa.entity.KhachHang;
import com.se.nuochoa.service.KhachHangService;

@Controller
@RequestMapping("/khachhang") // Trang Ä‘Æ°á»£c báº¯t Ä‘áº§u báº±ng /khachhang
public class KhachHangController {
	
	// Tá»± Ä‘á»™ng nhÃºng cÃ¡c Bean 
	// NÃ³ sáº½ tÃ¬m kiáº¿m bean cÃ³ tÃªn lÃ  KhachHangDao trong container cá»§a nÃ³ ,sau Ä‘Ã³ nhÃºng (hoáº·c tiÃªm) vÃ o lá»›p KhachHangServiceImpl. 
	// ÄÃ¢y chÃ­nh lÃ  cÆ¡ cháº¿ DI (dependency injection). 
	@Autowired
	private KhachHangService khachHangService;

	// Cáº¥u hÃ¬nh rÃ ng buá»™c cÃ¡c tham sá»‘ yÃªu cáº§u (nghÄ©a lÃ  dá»¯ liá»‡u biá»ƒu máº«u hoáº·c truy váº¥n) vá»›i má»™t Ä‘á»‘i tÆ°á»£ng mÃ´ hÃ¬nh
	// Chuyá»ƒn Ä‘á»•i cÃ¡c giÃ¡ trá»‹ yÃªu cáº§u dá»±a trÃªn chuá»—i (cháº³ng háº¡n nhÆ° tham sá»‘ yÃªu cáº§u, biáº¿n Ä‘Æ°á»ng dáº«n, tiÃªu Ä‘á», cookie vÃ  cÃ¡c giÃ¡ trá»‹ khÃ¡c) thÃ nh loáº¡i Ä‘Ã­ch cá»§a Ä‘á»‘i sá»‘ phÆ°Æ¡ng thá»©c bá»™ Ä‘iá»u khiá»ƒn
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// Cáº¥u hÃ¬nh trang hiá»ƒn thá»‹ list Khachhang
	@GetMapping("/list")
	public String ListKhachHang(Model model) {
		List<KhachHang> khachHang = khachHangService.getKhachHangs();
		model.addAttribute("khachhangs", khachHang);
		return "khachhang-list";
	}

	// Cáº¥u hÃ¬nh trang save Khachhang
	// Cáº¥u hÃ¬nh annotation @Valid @ModelAttribute rÃ ng buá»™c dá»¯ liá»‡u khi Save
	@PostMapping("/saveKhachHang")
	public String saveKhachHang(@Valid @ModelAttribute("khachhang") KhachHang khachHang, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "khachhang-form";	
		} else {
			khachHangService.saveKhachHang(khachHang);
			return "redirect:/khachhang/list";
		}
	}

	// Cáº¥u hÃ¬nh trang update Khachhang
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("khachhangId") String theId, Model theModel) {
		KhachHang khachHang = khachHangService.getKhachHang(theId);
		theModel.addAttribute("khachhang", khachHang);
		return "khachhang-form";
	}

	// Cáº¥u hÃ¬nh trang add Khachhang
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		KhachHang khachHang = new KhachHang();
		theModel.addAttribute("khachhang", khachHang);
		return "khachhang-form";
	}

	// Cáº¥u hÃ¬nh trang delete Khachhang
	@GetMapping("/delete")
	public String deleteKhachHang(@RequestParam("khachhangId") String theId) {
		khachHangService.deleteKhachHang(theId);
		return "redirect:/khachhang/list";
	}

}
