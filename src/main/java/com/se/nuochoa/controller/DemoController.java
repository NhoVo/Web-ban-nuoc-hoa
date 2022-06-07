package com.se.nuochoa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.nuochoa.entity.ChiTietHoaDon;
import com.se.nuochoa.entity.HoaDon;
import com.se.nuochoa.entity.KhachHang;
import com.se.nuochoa.entity.SanPham;
import com.se.nuochoa.service.ChiTietHoaDonService;
import com.se.nuochoa.service.HoaDonService;
import com.se.nuochoa.service.KhachHangService;
import com.se.nuochoa.service.SanPhamSevice;

@Controller
@RequestMapping("/khachhang")
public class DemoController {
	@Autowired 
	private SanPhamSevice sevicesDao;
	
	@Autowired
	private KhachHangService khachhangDao;
	
	@Autowired
	private HoaDonService hdDao;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	@GetMapping("/khachhangs")
	public String showHome(Model theModel) {
//		theModel.addAttribute("test",new Sanpham("Nước hoa Gucci abc", "testNhanhieu", "TestGt", "TestXuatxu"));
//		List<Sanpham> lists = new ArrayList<Sanpham>();
//		lists = sevicesDao.getGucci();
//		lists.add(new Sanpham("Nước hoa Gucci abc-1", "testNhanhieu-1", "TestGt", "TestXuatxu"));
//		lists.add(new Sanpham("Nước hoa Gucci abc-2", "testNhanhieu-2", "TestGt", "TestXuatxu"));
//		lists.add(new Sanpham("Nước hoa Gucci abc-3", "testNhanhieu-2", "TestGt", "TestXuatxu"));
//		lists.add(new Sanpham("Nước hoa Gucci abc-4", "testNhanhieu-2", "TestGt", "TestXuatxu"));
//		List<Sanpham> list = sevicesDao.getGucci();
//		theModel.addAttribute("Gucci",list);
		List<SanPham> spBanChay = sevicesDao.getSPBanChay();
		theModel.addAttribute("spBanChay",spBanChay);
		
		List<SanPham> spGiamgia = sevicesDao.getSPGiamGia();
		theModel.addAttribute("spGiamGia",spGiamgia);
		List<SanPham> spKhac = sevicesDao.getSPAll();
		theModel.addAttribute("spKhac",spKhac);
		
		theModel.addAttribute("ttkhachhang",new KhachHang());
		
		return "indexKh";
	}
	
	@RequestMapping("/thongtinkh")
	public String showttKhachHang(Model theModel,@ModelAttribute(name = "ttkhachhang") KhachHang khachHang,@RequestParam(name = "makh",required =false) String makh)
	{
		KhachHang kh = khachhangDao.getKhachHang(makh);
		theModel.addAttribute("ttkh",kh);
		
		return "thongtinkhachhang-form";
	}
	@PostMapping("/saveKhachHangs")
	public String saveKH(Model theModel,@ModelAttribute(name = "ttkhachhang") KhachHang khachHang,@RequestParam(name = "makh",required =false) String makh)
	{
		khachHang.setMakh(makh);
		khachhangDao.UpdateKH(khachHang);
		
		
		
		
		
		
		return "indexKh";
	}
	
	@GetMapping("/id")
	public String showGucci(Model theModel,@RequestParam(name = "gucciId") String theId) {
		
		SanPham sanpham = sevicesDao.getSPId(theId);
		theModel.addAttribute("SP_GUCCI",sanpham);
		return "CTSP";
	}
	@GetMapping("/gucci")
	public String Gucci(Model theModel)
	{
		List<SanPham> list = sevicesDao.getGucci();
	
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU","GUCCI");
		theModel.addAttribute("THUONGHIEU2","4");
		return "Gucci";
	}
	@GetMapping("/Versace")
	public String Versace(Model theModel)
	{
		List<SanPham> list = sevicesDao.getVersace();
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU","VERSACE");
		theModel.addAttribute("THUONGHIEU2","1");
		return "Gucci";
	}
	@GetMapping("/Hermes")
	public String Hermes(Model theModel)
	{
		List<SanPham> list = sevicesDao.getHermes();
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU","HERMES");
		theModel.addAttribute("THUONGHIEU2","3");
		return "Gucci";
	}
	@GetMapping("/Chloe")
	public String Chloe(Model theModel)
	{
		List<SanPham> list = sevicesDao.getChloe();
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU","CHLOE");
		theModel.addAttribute("THUONGHIEU2","5");
		return "Gucci";
	}
	@GetMapping("/Calvin")
	public String Calvin(Model theModel)
	{
		List<SanPham> list = sevicesDao.getCavin();
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU","CALVIN KLEIN");
		theModel.addAttribute("THUONGHIEU2","6");
		return "Gucci";
	}
	@GetMapping("/Chanel")
	public String Chanel(Model theModel)
	{
		List<SanPham> list = sevicesDao.getChanel();
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU","CHANEL");theModel.addAttribute("THUONGHIEU2","2");
		return "Gucci";
	}
	
	
	@GetMapping("/thanhtoan")
	public String Thanhtoan(Model theModel,@RequestParam(name = "gucciId") String theId)
	{
		SanPham sanpham = sevicesDao.getSPId(theId);
		theModel.addAttribute("Thanhtoan",sanpham);
		KhachHang kh = new KhachHang();
//		theModel.addAttribute("thongTinKhachHang",kh);
		ChiTietHoaDon cthd = new ChiTietHoaDon();
		theModel.addAttribute("thongTinKhachHang",cthd);
		
		return "thanhtoan";
	}
	@PostMapping("/thanhtoan/thanhcong")
	public String Thanhtoanthanhcong(Model theModel,@ModelAttribute("thongtinKhachhang") ChiTietHoaDon cthd,@RequestParam(name = "id",required = false) String spId,@RequestParam(name = "makhachhang",required = false) String makh)
	{
		//Them khach hang
//		KhachHang khkt= khachhangDao.getKhachHangBysdt(khachhang.getSoDienThoaikh());
//		if(khkt ==null)
//		{
//			KhachHang kh = khachhangDao.getKhMax();
//			int id = Integer.parseInt(kh.getMakh())+1;
//			khachhang.setMakh(String.valueOf(id));
//			khachhangDao.ThemKhachHang(khachhang);
//		}
//		else
//		{
//			khachhang.setMakh(khkt.getMakh());
//			khachhangDao.UpdateKH(khachhang);
//		}
		System.out.println(makh);
		
		sevicesDao.getSPId(spId);
		
		//Them Hoa Don
		int mamax =Integer.parseInt(hdDao.getHDMax().getMaHoaDon())+1 ;
		String mahd = String.valueOf(mamax);
		
		
		HoaDon hoadon = new HoaDon(mahd,khachhangDao.getKhachHang(makh), new Date());
		hoadon.setTrangThai(0);
		System.out.println(hoadon);
		hdDao.ThemHoaDon(hoadon);
		
		//Them CTHD
		SanPham sanPham = sevicesDao.getSPId(spId);
		
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(hoadon, sanPham,cthd.getSoLuong(),sanPham.getGiathanh());
		List<SanPham> spBanChay = sevicesDao.getSPBanChay();
		theModel.addAttribute("spBanChay",spBanChay);
		chiTietHoaDonService.ThemCTHD(chiTietHoaDon);
		List<SanPham> spGiamgia = sevicesDao.getSPGiamGia();
		theModel.addAttribute("spGiamGia",spGiamgia);
		List<SanPham> spKhac = sevicesDao.getSPAll();
		theModel.addAttribute("spKhac",spKhac);
		
		return "indexKh";
	}
	
	
	//Xu Ly Bo Loc
	@GetMapping("/productduoi500")
	public String productDuoi500(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProuductDuoi500(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		
		return "Gucci";
	}
	@GetMapping("/product500-1000")
	public String product500_1000(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProuduct500Den1000(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product1000-2000")
	public String product1000_2000(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProuduct1000Den2000(maThuongHieu);
		
		System.out.println(maThuongHieu);
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product2000-5000")
	public String product2000_5000(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProuduct2000Den5000(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/productTren5000")
	public String productTren5000(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProuductTren5000(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/productMen")
	public String productMen(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProductMen(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/productWoman")
	public String productWoman(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProductWoman(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	
	@GetMapping("/product7_5ml")
	public String product7_5ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct7_5ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product10ml")
	public String product10ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct10ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product15ml")
	public String product15ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct15ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product20ml")
	public String product20ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct20ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product30ml")
	public String product30ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct30ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product50ml")
	public String product50ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct50ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product100ml")
	public String product100ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct100ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product120ml")
	public String product120ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct120ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product150ml")
	public String product150ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct150ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@GetMapping("/product200ml")
	public String product70ml(Model theModel,@RequestParam("maThuongHieu") String maThuongHieu)
	{
		List<SanPham> list = sevicesDao.getProduct200ml(maThuongHieu);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("THUONGHIEU2",maThuongHieu);
		
		return "Gucci";
	}
	@RequestMapping("/searchProduct")
	public String searchProduct(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.searchProduct(txtSearch);
		
		theModel.addAttribute("Gucci",list);

		return "Gucci";
	}
	@RequestMapping("/thanhLy")
	public String thanhLy(Model theModel)
	{
		List<SanPham> list = sevicesDao.thanhLy();
		
		theModel.addAttribute("Gucci",list);
		
		
		return "Gucci";
	}
	@RequestMapping("/banChay")
	public String banChay(Model theModel)
	{
		List<SanPham> list = sevicesDao.getSPBanChay();
		
		theModel.addAttribute("Gucci",list);

		return "Gucci2";
	}
	
	
	//Xu ly bo loc Home
	@RequestMapping("/banChayHome")
	public String banChayHome(Model theModel)
	{
		List<SanPham> list = sevicesDao.getSPBanChay();
		
		theModel.addAttribute("Gucci",list);

		return "Gucci2";
	}
	@RequestMapping("/thanhLyHome")
	public String thanhLyHome(Model theModel)
	{
		List<SanPham> list = sevicesDao.thanhLy();
		
		theModel.addAttribute("Gucci",list);

		return "Gucci2";
	}
	@RequestMapping("/searchProductHome")
	public String searchProductHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.searchProduct(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);

		return "Gucci2";
	}
	
	
	
	//Xu ly Search Home
	
	@GetMapping("/product75mlHome")
	public String product75mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct7_5mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/product10mlHome")
	public String product10mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct10mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/product15mlHome")
	public String product15mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct15mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/product20mlHome")
	public String product20mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct20mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/product30mlHome")
	public String product30mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct30mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/product50mlHome")
	public String product50mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct50mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	
	@GetMapping("/product100mlHome")
	public String product100mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct100mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	
	@GetMapping("/product120mlHome")
	public String product120mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct120mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	
	@GetMapping("/product150mlHome")
	public String product150mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct150mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	
	@GetMapping("/product200mlHome")
	public String product200mlHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProduct200mlHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/productWomanHome")
	public String productWomanHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProductWomanHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/productMenHome")
	public String productMenHome(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProductMenHome(txtSearch);
		
		theModel.addAttribute("Gucci",list);
		
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	
	@GetMapping("/productduoi500Home")
	public String productDuoi500Home(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProuductDuoi500Home(txtSearch);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/product500-1000Home")
	public String product500_1000Home(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProuduct500Den1000Home(txtSearch);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("gtSearch",txtSearch);
	
		
		return "Gucci2";
	}
	@GetMapping("/product1000-2000Home")
	public String product1000_2000Home(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProuduct1000Den2000Home(txtSearch);
		
		
		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("gtSearch",txtSearch);
		
		return "Gucci2";
	}
	@GetMapping("/product2000-5000Home")
	public String product2000_5000Home(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProuduct2000Den5000Home(txtSearch);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/productTren5000Home")
	public String productTren5000Home(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.getProuductTren5000Home(txtSearch);

		theModel.addAttribute("Gucci",list);
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "Gucci2";
	}
	@GetMapping("/searchProductAdmin")
	public String searchProductAdmin(Model theModel,@RequestParam("txtSearch") String txtSearch)
	{
		List<SanPham> list = sevicesDao.searchProductAdmin(txtSearch);

		theModel.addAttribute("sanphams",list);
		theModel.addAttribute("gtSearch",txtSearch);
		
		
		return "quanly-sanpham";
	}
	
	
	
	
//	@GetMapping("/leaders")
//	public String showLeaders() {
//		return "leaders";
//	}
//	@GetMapping("/systems")
//	public String showSystems() {
//		return "systems";
//	}
//	@GetMapping("/access-denied")
//	public String showAccessdenied() {
//		return "access-denied";
//	}
}
