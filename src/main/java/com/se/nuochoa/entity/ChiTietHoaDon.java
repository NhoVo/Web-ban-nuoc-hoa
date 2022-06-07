package com.se.nuochoa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@IdClass(ChiTietHoaDon_PK.class)
@Table(name ="chiTietHoaDon")
public class ChiTietHoaDon{
	
	@Id
	@ManyToOne
	@JoinColumn(name="maHoaDon")
	private HoaDon hoaDon;
	
	@Id
	@ManyToOne
	@JoinColumn(name="maSanPham")
	private SanPham sanPham;
	@Column(name = "soLuong")
	private int soLuong;
	@Column(name = "donGia")
	private double donGia;
	
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong, double donGia) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double tinhThanhTien() {
		return soLuong * donGia;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", donGia="
				+ donGia + "]";
	}
	public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
	}

	
}
