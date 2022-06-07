package com.se.nuochoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sanPham")
public class SanPham {
	@Id
	@Column(name = "maSanPham")
	private String maSanPham;
	@Column(name = "tenSanPham")
	private String tenSanPham;
	@Column(name = "hinhanh")
	private String hinhanh;
	@Column(name = "gioiTinh")
	private int gioiTinh;
	@Column(name="xuatXu")
	private String xuatXu;
	@Column(name="phongCach")
	private String phongCach;
	@Column(name="giathanh")
	private double giathanh;
	@Column(name="soLuong")
	private int soLuong;
	
	@ManyToOne
	@JoinColumn(name="maThuongHieu")
	private ThuongHieu thuongHieu;

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public String getPhongCach() {
		return phongCach;
	}

	public void setPhongCach(String phongCach) {
		this.phongCach = phongCach;
	}

	public double getGiathanh() {
		return giathanh;
	}

	public void setGiathanh(double giathanh) {
		this.giathanh = giathanh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public SanPham(String maSanPham, String tenSanPham, String hinhanh, int gioiTinh, String xuatXu, String phongCach,
			double giathanh, int soLuong, ThuongHieu thuongHieu) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.hinhanh = hinhanh;
		this.gioiTinh = gioiTinh;
		this.xuatXu = xuatXu;
		this.phongCach = phongCach;
		this.giathanh = giathanh;
		this.soLuong = soLuong;
		this.thuongHieu = thuongHieu;
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", hinhanh=" + hinhanh + ", gioiTinh="
				+ gioiTinh + ", xuatXu=" + xuatXu + ", phongCach=" + phongCach + ", giathanh=" + giathanh + ", soLuong="
				+ soLuong + ", thuongHieu=" + thuongHieu + "]";
	}

	
	
	
	
}
