package com.se.nuochoa.service;

import java.util.List;

import com.se.nuochoa.entity.SanPham;
import com.se.nuochoa.entity.ThuongHieu;

public interface SanPhamSevice {
	List<SanPham> getGucci();
	SanPham getSPId(String id);
	List<SanPham> getVersace();
	List<SanPham> getChanel();
	List<SanPham> getChloe();
	List<SanPham> getHermes();
	List<SanPham> getCavin();
	List<SanPham> getSPBanChay();
	List<SanPham> getSPGiamGia();
	List<SanPham> getSPAll();
	
	//
	
	//Quan Ly San Pham
		public List<SanPham> getAllSanPham();
		public void xoaSanPham(SanPham maSanPham); 
		public List<ThuongHieu> getAllThuongHieu();
		public SanPham getSanPhamTheoId(String id);
		
		public boolean addSanPham(SanPham sp);
		
		public SanPham getMaSanPhamCuoi();
		public void updateSanPham(SanPham sp);
		
		//Xu ly bo loc
				public List<SanPham> getProuductDuoi500(String ma);
				public List<SanPham> getProuduct500Den1000(String ma);
				public List<SanPham> getProuduct1000Den2000(String ma);
				public List<SanPham> getProuduct2000Den5000(String ma);
				public List<SanPham> getProuductTren5000(String ma);
				public List<SanPham> getProductMen(String ma);
				public List<SanPham> getProductWoman(String ma);
				
				public List<SanPham> getProduct7_5ml(String ma);
				public List<SanPham> getProduct10ml(String ma);
				public List<SanPham> getProduct15ml(String ma);
				public List<SanPham> getProduct20ml(String ma);
				public List<SanPham> getProduct30ml(String ma);
				public List<SanPham> getProduct50ml(String ma);
				public List<SanPham> getProduct100ml(String ma);
				public List<SanPham> getProduct120ml(String ma);
				public List<SanPham> getProduct150ml(String ma);
				public List<SanPham> getProduct200ml(String ma);
				public List<SanPham> searchProduct(String ma);
				public List<SanPham> thanhLy();
				
				//Xu ly bo loc Home
				public List<SanPham> getProduct7_5mlHome(String ma);
				public List<SanPham> getProduct10mlHome(String ma);
				public List<SanPham> getProduct15mlHome(String ma);
				public List<SanPham> getProduct20mlHome(String ma);
				public List<SanPham> getProduct30mlHome(String ma);
				public List<SanPham> getProduct50mlHome(String ma);
				public List<SanPham> getProduct100mlHome(String ma);
				public List<SanPham> getProduct120mlHome(String ma);
				public List<SanPham> getProduct150mlHome(String ma);
				public List<SanPham> getProduct200mlHome(String ma);
				public List<SanPham> getProductMenHome(String ma);
				public List<SanPham> getProductWomanHome(String ma);
				
				public List<SanPham> getProuductDuoi500Home(String ma);
				public List<SanPham> getProuduct500Den1000Home(String ma);
				public List<SanPham> getProuduct1000Den2000Home(String ma);
				public List<SanPham> getProuduct2000Den5000Home(String ma);
				public List<SanPham> getProuductTren5000Home(String ma);
				public List<SanPham> searchProductAdmin(String ma);
		
		
		
}
