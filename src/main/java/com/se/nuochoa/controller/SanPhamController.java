package com.se.nuochoa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.nuochoa.entity.KhachHang;
import com.se.nuochoa.entity.SanPham;
import com.se.nuochoa.entity.ThuongHieu;
import com.se.nuochoa.service.KhachHangService;
import com.se.nuochoa.service.SanPhamSevice;


@Controller
@RequestMapping("/product")
public class SanPhamController {
	@Autowired
	private SanPhamSevice spService;
	
	@GetMapping("/list-vercase")	
	public String ListKhachHang(Model model) {
		List<SanPham> sanPham = spService.getAllSanPham();
		
		model.addAttribute("sanphams", sanPham);
		return "vercase";
	}
	@GetMapping("/list-sanpham")	
	public String ListSanPham(Model model) {
		List<SanPham> sanPham = spService.getAllSanPham();
		List<ThuongHieu> thuongHieu = spService.getAllThuongHieu();
		String id = (String) model.getAttribute("maSanPham");
//		List<SanPham> sp = spService.getSanPhamTheoId(id);
		model.addAttribute("thuonghieu", thuongHieu);
		model.addAttribute("sanphams", sanPham);
//		model.addAttribute("sanpham", sp);
		
		return "quanly-sanpham";
	}
	

	 @GetMapping("/delete")
	    public String deleteCreditCard(@RequestParam("maSanPham") String id, String maThuongHieu) {

	        SanPham sp = spService.getSanPhamTheoId(id);
	        sp.setSoLuong(0);
	        
	        spService.xoaSanPham(sp);
	        return "redirect:/product/list-sanpham" ;
	  }
	 	@GetMapping("/showFormUpdate")
	    public String showFormUpdate(Model theModel, @RequestParam("maSanPham") String maSanPham) {
	        // create model attribute to bind form data
	        SanPham sp = spService.getSanPhamTheoId(maSanPham);
	        
	        
	        
	        List<SanPham> sanPham = spService.getAllSanPham();
	        List<ThuongHieu> thuongHieu = spService.getAllThuongHieu();
	        
	        SanPham sanPhamId = spService.getSanPhamTheoId(maSanPham);
	        
	        theModel.addAttribute("sp",sp);
	        theModel.addAttribute("sanphams", sanPhamId);
	        theModel.addAttribute("thuonghieu", thuongHieu);
	        return "update-product-form";
	    }
	 	
	 	@PostMapping("/updateProduct")
		public String UpdateSanPham(@ModelAttribute("sp") SanPham sanPham) {
			spService.updateSanPham(sanPham);
	 		
			return "redirect:/product/list-sanpham";
		}
	 
	 @GetMapping("/showFormAdd")
	    public String showFormForAdd(Model theModel) {
	        // create model attribute to bind form data
	        SanPham sp = new SanPham();
	        List<ThuongHieu> thuongHieu = spService.getAllThuongHieu();
	        
	        theModel.addAttribute("addSanPham", sp);
	        theModel.addAttribute("thuonghieu", thuongHieu);
	        return "add-product-form";
	    }
	 
	 @PostMapping("/addSanPham")
		public String AddSanPham(@ModelAttribute("addSanPham") SanPham sanPham) {
		 	SanPham sanPhamCuoi = spService.getMaSanPhamCuoi();
		 	int id = Integer.parseInt(sanPhamCuoi.getMaSanPham())+1;
			sanPham.setMaSanPham(String.valueOf(id));

			spService.addSanPham(sanPham);
			
			return "redirect:/product/list-sanpham";
		}
	 
	 
	 
	 	
	 

}
