package com.se.nuochoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.nuochoa.dao.ChiTietHoaDonDao;
import com.se.nuochoa.entity.ChiTietHoaDon;
import com.se.nuochoa.entity.HoaDon;


@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService{
	@Autowired
	private ChiTietHoaDonDao chiTietHoaDonDao;
	
	@Override
	@Transactional
	public ChiTietHoaDon getChiTietHoaDonByName(String name) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.getChiTietHoaDonByName(name);
	}

	@Override
	@Transactional
	public List<ChiTietHoaDon> getChiTietHoaDons() {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.getChiTietHoaDons();
	}

	@Override
	@Transactional
	public ChiTietHoaDon getChiTietHoaDon(String theId) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.getChiTietHoaDon(theId);
	}

	@Override
	@Transactional
	public List<ChiTietHoaDon> getDsCTHD(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.getDsCTHD(hoaDon);
	}

	@Override
	@Transactional
	public void ThemCTHD(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		chiTietHoaDonDao.ThemCTHD(chiTietHoaDon);
		
	}
	
	@Override
	@Transactional
	public List<ChiTietHoaDon> getAllChiTietHoaDon() {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.getAllChiTietHoaDon();
	}

	@Override
	@Transactional
	public ChiTietHoaDon getHoaDonTheoMaHd(String maHD) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.getHoaDonTheoMaHd(maHD);
	}

}
