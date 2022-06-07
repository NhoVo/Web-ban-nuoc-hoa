package com.se.nuochoa.dao;

import java.util.List;

import com.se.nuochoa.entity.ChiTietHoaDon;
import com.se.nuochoa.entity.HoaDon;



public interface ChiTietHoaDonDao {
    public ChiTietHoaDon getChiTietHoaDonByName(String name);
    public List<ChiTietHoaDon> getChiTietHoaDons();
    public ChiTietHoaDon getChiTietHoaDon(String theId);
    public List<ChiTietHoaDon> getDsCTHD(HoaDon hoaDon);
    
    public void ThemCTHD(ChiTietHoaDon chiTietHoaDon);
    
    public List<ChiTietHoaDon> getAllChiTietHoaDon();
	public ChiTietHoaDon getHoaDonTheoMaHd(String maHD);
}
