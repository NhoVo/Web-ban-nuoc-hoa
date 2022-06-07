package com.se.nuochoa.service;

import java.util.List;

import com.se.nuochoa.entity.KhachHang;

public interface KhachHangService {

	public KhachHang getKhachHangByName(String name);
	public List<KhachHang> getKhachHangs();
	public KhachHang getKhachHang(String theId);
	public void saveKhachHang(KhachHang khachHang);
	public void deleteKhachHang(String theId);

	
	KhachHang getKhachHangBysdt(String sdt);
	void ThemKhachHang(KhachHang khachhang);
	KhachHang getKhMax();
	void UpdateKH(KhachHang kh);
}
