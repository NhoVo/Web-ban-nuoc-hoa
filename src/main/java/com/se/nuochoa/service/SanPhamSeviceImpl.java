package com.se.nuochoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.nuochoa.dao.SanPhamDao;
import com.se.nuochoa.entity.SanPham;
import com.se.nuochoa.entity.ThuongHieu;
@Service
public class SanPhamSeviceImpl implements SanPhamSevice{
	@Autowired
	SanPhamDao dao;
	@Override
	@Transactional
	public List<SanPham> getGucci() {
		// TODO Auto-generated method stub
		return dao.getGucci();
	}

	@Override
	@Transactional
	public SanPham getSPId(String id) {
		// TODO Auto-generated method stub
		return dao.getSPId(id);
	}

	@Override
	@Transactional
	public List<SanPham> getVersace() {
		// TODO Auto-generated method stub
		return dao.getVersace();
	}

	@Override
	@Transactional
	public List<SanPham> getChanel() {
		// TODO Auto-generated method stub
		return dao.getChanel();
	}

	@Override
	@Transactional
	public List<SanPham> getChloe() {
		// TODO Auto-generated method stub
		return dao.getChloe();
	}

	@Override
	@Transactional
	public List<SanPham> getHermes() {
		// TODO Auto-generated method stub
		return dao.getHermes();
	}

	@Override
	@Transactional
	public List<SanPham> getCavin() {
		// TODO Auto-generated method stub
		return dao.getCavin();
	}

	@Override
	@Transactional
	public List<SanPham> getSPBanChay() {
		// TODO Auto-generated method stub
		return dao.getSPBanChay();
	}

	@Override
	@Transactional
	public List<SanPham> getSPGiamGia() {
		// TODO Auto-generated method stub
		return dao.getSPGiamGia();
	}

	@Override
	@Transactional
	public List<SanPham> getSPAll() {
		// TODO Auto-generated method stub
		return dao.getSPAll();
	}
	//Quan Ly San Pham
		@Override
		@Transactional
		public List<SanPham> getAllSanPham() {
			// TODO Auto-generated method stub
			return dao.getAllSanPham();
		}
		@Override
		@Transactional
		public void xoaSanPham(SanPham maSanPham) {
			dao.xoaSanPham(maSanPham);
			
		}
		@Override
		@Transactional
		public List<ThuongHieu> getAllThuongHieu() {
			// TODO Auto-generated method stub
			return dao.getAllThuongHieu();
		}
		@Override
		@Transactional
		public SanPham getSanPhamTheoId(String id) {
			// TODO Auto-generated method stub
			return dao.getSanPhamTheoId(id);
		}
		@Override
		@Transactional
		public boolean addSanPham(SanPham sp) {
			return dao.addSanPham(sp);
			
		}
		@Override
		@Transactional
		public SanPham getMaSanPhamCuoi() {
			return dao.getMaSanPhamCuoi();
		}
		@Override
		@Transactional
		public void updateSanPham(SanPham sp) {
			dao.updateSanPham(sp);
		}

		@Override
		public List<SanPham> getProuductDuoi500(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuductDuoi500(ma);
		}

		@Override
		@Transactional
		public List<SanPham> getProuduct500Den1000(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuduct500Den1000(ma);
		}

		@Override
		public List<SanPham> getProuduct1000Den2000(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuduct1000Den2000(ma);
		}

		@Override
		public List<SanPham> getProuduct2000Den5000(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuduct2000Den5000(ma);
		}

		@Override
		public List<SanPham> getProuductTren5000(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuductTren5000(ma);
		}

		@Override
		public List<SanPham> getProductMen(String ma) {
			// TODO Auto-generated method stub
			return dao.getProductMen(ma);
		}

		@Override
		public List<SanPham> getProductWoman(String ma) {
			// TODO Auto-generated method stub
			return dao.getProductWoman(ma);
		}

		@Override
		public List<SanPham> getProduct7_5ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct7_5ml(ma);
		}

		@Override
		public List<SanPham> getProduct10ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct10ml(ma);
		}

		@Override
		public List<SanPham> getProduct15ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct15ml(ma);
		}

		@Override
		public List<SanPham> getProduct20ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct20ml(ma);
		}

		@Override
		public List<SanPham> getProduct30ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct30ml(ma);
		}

		@Override
		public List<SanPham> getProduct50ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct50ml(ma);
		}

		@Override
		public List<SanPham> getProduct100ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct100ml(ma);
		}

		@Override
		public List<SanPham> getProduct120ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct120ml(ma);
		}

		@Override
		public List<SanPham> getProduct150ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct150ml(ma);
		}

		@Override
		public List<SanPham> getProduct200ml(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct200ml(ma);
		}
		@Override
		public List<SanPham> searchProduct(String ma) {
			// TODO Auto-generated method stub
			return dao.searchProduct(ma);
		}

		@Override
		public List<SanPham> thanhLy() {
			// TODO Auto-generated method stub
			return dao.thanhLy();
		}

		@Override
		
		public List<SanPham> getProduct7_5mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct7_5mlHome(ma);
		}
		@Override
		public List<SanPham> getProduct10mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct10mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct15mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct15mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct20mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct20mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct30mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct30mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct50mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct50mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct100mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct100mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct120mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct120mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct150mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct150mlHome(ma);
		}

		@Override
		public List<SanPham> getProduct200mlHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProduct200mlHome(ma);
		}

		@Override
		public List<SanPham> getProductMenHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProductMenHome(ma);
		}

		@Override
		public List<SanPham> getProductWomanHome(String ma) {
			// TODO Auto-generated method stub
			return dao.getProductWomanHome(ma);
		}

		@Override
		public List<SanPham> getProuductDuoi500Home(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuductDuoi500Home(ma);
		}

		@Override
		public List<SanPham> getProuduct500Den1000Home(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuduct500Den1000Home(ma);
		}

		@Override
		public List<SanPham> getProuduct1000Den2000Home(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuduct1000Den2000Home(ma);
		}

		@Override
		public List<SanPham> getProuduct2000Den5000Home(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuduct2000Den5000Home(ma);
		}

		@Override
		public List<SanPham> getProuductTren5000Home(String ma) {
			// TODO Auto-generated method stub
			return dao.getProuductTren5000Home(ma);
		}
		@Override
		public List<SanPham> searchProductAdmin(String ma) {
			// TODO Auto-generated method stub
			return dao.searchProductAdmin(ma);
		}
		

}
