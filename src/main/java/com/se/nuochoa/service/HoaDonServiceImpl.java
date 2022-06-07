package com.se.nuochoa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.nuochoa.dao.HoaDonDao;
import com.se.nuochoa.entity.HoaDon;

@Service
public class HoaDonServiceImpl implements HoaDonService{
	@Autowired
	private HoaDonDao hoaDonDao;
	
	@Override
	@Transactional
	public HoaDon getHoaDonByName(String name) {
		// TODO Auto-generated method stub
		return hoaDonDao.getHoaDonByName(name);
	}

	@Override
	@Transactional
	public List<HoaDon> getHoaDons() {
		// TODO Auto-generated method stub
		return hoaDonDao.getHoaDons();
	}

	@Override
	@Transactional
	public HoaDon getHoaDon(String theId) {
		// TODO Auto-generated method stub
		return hoaDonDao.getHoaDon(theId);
	}
	@Override
	@Transactional
	public List<?> listHoaDonBan(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return hoaDonDao.listHoaDonBan(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public double tongtienHoaDon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return hoaDonDao.tongtienHoaDon(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public void ThemHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		hoaDonDao.ThemHoaDon(hoaDon);
	}

	@Override
	@Transactional
	public HoaDon getHDMax() {
		// TODO Auto-generated method stub
		return hoaDonDao.getHDMax();
	}

	@Override
	@Transactional
	public List<?> listHoaDonBan(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return hoaDonDao.listHoaDonBan(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public double tongtienHoaDon(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return hoaDonDao.tongtienHoaDon(ngayBatDau, ngayKetThuc);
	}
	
	//
	@Override
	@Transactional
	public List<HoaDon> getAllHoaDon() {
		// TODO Auto-generated method stub
		return hoaDonDao.getAllHoDon();
	}

	@Override
	@Transactional
	public List<?> getHoaDonTheoMaHd() {
		// TODO Auto-generated method stub
		return hoaDonDao.getHoaDonTheoMaHd();
	}
	
	//
	@Override
	public int SoHoaDonchuaThanhToan(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return hoaDonDao.SoHoaDonchuaThanhToan(ngayBatDau, ngayKetThuc);
	}

	@Override
	public int SoHoaDondaThanhToan(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return hoaDonDao.SoHoaDondaThanhToan(ngayBatDau, ngayKetThuc);
	}







}
