package com.se.nuochoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.nuochoa.dao.KhachHangDao;
import com.se.nuochoa.entity.KhachHang;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	@Autowired
	private KhachHangDao khachHangDao;

	@Override
	@Transactional
	public List<KhachHang> getKhachHangs() {
		return khachHangDao.getKhachHangs();
	}

	@Override
	@Transactional
	public KhachHang getKhachHang(String theId) {
		return khachHangDao.getKhachHang(theId);
	}

	@Override
	@Transactional
	public void saveKhachHang(KhachHang khachHang) {
		khachHangDao.saveKhachHang(khachHang);
	}

	@Override
	@Transactional
	public void deleteKhachHang(String theId) {
		khachHangDao.deleteKhachHang(theId);
	}

	@Override
	@Transactional
	public KhachHang getKhachHangByName(String string) {
		return khachHangDao.getKhachHangByName(string);
	}

	@Override
	@Transactional
	public KhachHang getKhachHangBysdt(String sdt) {
		// TODO Auto-generated method stub
		return khachHangDao.getKhachHangBysdt(sdt);
	}

	@Override
	@Transactional
	public void ThemKhachHang(KhachHang khachhang) {
		// TODO Auto-generated method stub
		khachHangDao.ThemKhachHang(khachhang);
	}

	@Override
	@Transactional
	public KhachHang getKhMax() {
		// TODO Auto-generated method stub
		return khachHangDao.getKhMax();
	}

	@Override
	@Transactional
	public void UpdateKH(KhachHang kh) {
		// TODO Auto-generated method stub
		khachHangDao.UpdateKH(kh);
	}

}
