package com.se.nuochoa.service;

import java.time.LocalDate;
import java.util.List;

import com.se.nuochoa.entity.HoaDon;

public interface HoaDonService {
//	public int NextIdKh();
    public HoaDon getHoaDonByName(String name);
    public List<HoaDon> getHoaDons();
    public HoaDon getHoaDon(String theId);
	public List<?> listHoaDonBan(LocalDate ngayBatDau, LocalDate ngayKetThuc);
//    public void saveHoaDon(HoaDon hoaDon);
//    public void deleteHoaDon(String theId);
//    public List<HoaDon> searchHoaDons(String theSearchName);
	public double tongtienHoaDon (LocalDate ngayBatDau, LocalDate ngayKetThuc);
	
	public void ThemHoaDon(HoaDon hoaDon);
	
	public HoaDon getHDMax();
	
	public double tongtienHoaDon (String ngayBatDau, String ngayKetThuc);
	public List<?> listHoaDonBan(String ngayBatDau, String ngayKetThuc);
	
	//
	public int SoHoaDonchuaThanhToan (String ngayBatDau, String ngayKetThuc);
	public int SoHoaDondaThanhToan (String ngayBatDau, String ngayKetThuc);
	
	
	//
	public List<HoaDon> getAllHoaDon();
	public List<?> getHoaDonTheoMaHd();
}
