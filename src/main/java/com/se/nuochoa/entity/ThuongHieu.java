package com.se.nuochoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="thuongHieu")
public class ThuongHieu {
	@Id
	@Column(name = "maThuongHieu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maThuongHieu;
	
	@Column(name = "tenTHuongHieu")
	private String tenTHuongHieu;

	public String getMaThuongHieu() {
		return maThuongHieu;
	}

	public void setMaThuongHieu(String maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}

	public String getTenTHuongHieu() {
		return tenTHuongHieu;
	}

	public void setTenTHuongHieu(String tenTHuongHieu) {
		this.tenTHuongHieu = tenTHuongHieu;
	}

	public ThuongHieu(String maThuongHieu, String tenTHuongHieu) {
		super();
		this.maThuongHieu = maThuongHieu;
		this.tenTHuongHieu = tenTHuongHieu;
	}

	public ThuongHieu(String maThuongHieu) {
		super();
		this.maThuongHieu = maThuongHieu;
	}

	public ThuongHieu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ThuongHieu [maThuongHieu=" + maThuongHieu + ", tenTHuongHieu=" + tenTHuongHieu + "]";
	}
	
}
