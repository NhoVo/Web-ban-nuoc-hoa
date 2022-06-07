package com.se.nuochoa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDon_PK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hoaDon;
	private String sanPham;
	public String getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(String hoaDon) {
		this.hoaDon = hoaDon;
	}
	public String getSanPham() {
		return sanPham;
	}
	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}
	public ChiTietHoaDon_PK(String hoaDon, String sanPham) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
	}
	public ChiTietHoaDon_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDon == null) ? 0 : hoaDon.hashCode());
		result = prime * result + ((sanPham == null) ? 0 : sanPham.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon_PK other = (ChiTietHoaDon_PK) obj;
		if (hoaDon == null) {
			if (other.hoaDon != null)
				return false;
		} else if (!hoaDon.equals(other.hoaDon))
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon_PK [hoaDon=" + hoaDon + ", sanPham=" + sanPham + "]";
	}
	
	
}
