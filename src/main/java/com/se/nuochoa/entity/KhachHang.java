package com.se.nuochoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity // Má»i entity Ä‘á» pháº£i gáº¯n @Entity. Hibernate sáº½ dá»±a vÃ o thÃ´n tin nÃ y Ä‘á»ƒ mapping xuá»‘ng má»™t báº£ng trong database
@Table(name = "khachHang")
public class KhachHang {
	@Column(name = "maKhachHang")
	@Id // má»—i Entity Ä‘á» pháº£i cÃ³ má»™t id, id dÃ¹ng Ä‘á»ƒ Ä‘á»‹nh danh, phÃ¢n biá»‡t giá»¯a cÃ¡c báº£n ghi vá»›i nhau
	// ÄÃ£ lÃ  id thÃ¬ nÃ³ pháº£i unique. Id lÃ  Ä‘Æ°á»£c dÃ¹ng Ä‘á»ƒ lÃ m khÃ³a chÃ­nh cá»§a báº£ng
	@NotNull(message = "Mã khách hàng không được để trống")
	private String makh;
	
	@Column(name = "tenKhachHang")
	@NotNull(message = "Tên khách hàng không được để trống")
	private String tenKhachHang;
	
	// -----------------------------------Ktra rÃ ng buá»™c data Phone Number---------------------------------------
	@Column(name = "soDienThoai")
	@NotNull(message = "Không được để trống")
	@Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Sai định dạng số điện thoại Vietnam")
	private String soDienThoaikh;

	// -----------------------------------Ktra rÃ ng buá»™c data Email---------------------------------------
	@Column(name = "email")
	@NotNull(message = "Email không được trống")
	@Email(message = "Email không đúng định dạng")
	private String email;
	
	// -----------------------------------Ktra rÃ ng buá»™c data Dia chi---------------------------------------
	@Column(name = "diaChi")
	@NotNull(message = "Äá»‹a chá»‰ khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng")
	private String diaChi;

	public KhachHang() {
	}

	public KhachHang(
			@NotNull(message = "MÃ£ KhÃ¡ch hÃ ng khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng") @Pattern(regexp = "^KH(\\d{3,4})$", message = "MÃ£ khÃ¡ch hÃ ng khÃ´ng Ä‘Ãºng Ä‘á»‹nh dáº¡ng") String makh) {
		super();
		this.makh = makh;
	}

	public KhachHang(String makh, String tenKhachHang, String soDienThoaikh, String email, String diaChi) {
		this.makh = makh;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoaikh = soDienThoaikh;
		this.email = email;
		this.diaChi = diaChi;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoaikh() {
		return soDienThoaikh;
	}

	public void setSoDienThoaikh(String soDienThoaikh) {
		this.soDienThoaikh = soDienThoaikh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
