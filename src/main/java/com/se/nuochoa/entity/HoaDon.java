package com.se.nuochoa.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name ="HoaDon")
public class HoaDon {
	@Id
	@Column(name = "maHoaDon")

	private String maHoaDon;
	
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	@Column(name="ngaylap")
	private Date ngayLap;
	private int trangThai;
	
	
	
	public String getTrangThai() {
		if(trangThai==1) {
			return "Đã thanh toán";
			}
			else {
			return "Chưa thanh toán";
			}
		
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public HoaDon(KhachHang khachHang, Date ngayLap) {
		super();
		this.khachHang = khachHang;
		this.ngayLap = ngayLap;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public HoaDon(String maHoaDon, KhachHang khachHang, Date ngayLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.ngayLap = ngayLap;
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", khachHang=" + khachHang + ", ngayLap=" + ngayLap + "]";
	}
	
	
}
