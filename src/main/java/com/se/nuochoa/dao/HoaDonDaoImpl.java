package com.se.nuochoa.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.se.nuochoa.entity.ChiTietHoaDon;
import com.se.nuochoa.entity.HoaDon;
import com.se.nuochoa.entity.KhachHang;



@Repository
@EnableTransactionManagement
public class HoaDonDaoImpl implements HoaDonDao {
	@Autowired
	SessionFactory sessionFactory;

//	@Override
//	public int NextIdKh() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public HoaDon getHoaDonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<HoaDon> getHoaDons() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<HoaDon> theQuery = currentSession.createQuery("from HoaDon", HoaDon.class);
		// execute query and get result list
		List<HoaDon> hoaDon = theQuery.getResultList();
		return hoaDon;
	}

	@Override
	public HoaDon getHoaDon(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		HoaDon hoaDon = currentSession.get(HoaDon.class, theId);
		return hoaDon;

	}
	@Transactional
	@Override
	public List<?> listHoaDonBan(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
	
		try {
			String sql ="select hd.maHoaDon,maKhachHang,ngayLap,sum(soLuong*donGia) as Tongtien from hoaDon as hd INNER JOIN chiTietHoaDon as cthd on hd.maHoaDon=cthd.maHoaDon \r\n"
					+ "where ngayLap between '"+ngayBatDau+"' and '"+ngayKetThuc+"'\r\n"
					+ "group by hd.maHoaDon,maKhachHang,ngayLap";
			List<?> list = session.createNativeQuery(sql)
					.getResultList();		
			return list;
		} catch (Exception e) {
			// TODO: handle exception
	
		}
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	@Transactional
	public double tongtienHoaDon (LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		double sum=0;
		try {
		
			String sql ="select sum(soLuong * donGia) from chiTietHoaDon where maHoaDon in (select maHoaDon from hoaDon\r\n"
					+ "where ngayLap  between '"+ngayBatDau+"' and '"+ ngayKetThuc +"')";
			sum = (double) session.createNativeQuery(sql).getSingleResult();


			return sum;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		// TODO Auto-generated method stub
		return sum;
	}
	@Override
	public void ThemHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(hoaDon);
		
	}
	@Override
	public HoaDon getHDMax() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query<HoaDon> theQuery = session.createQuery("from HoaDon order by maHoaDon desc",HoaDon.class);
		List<HoaDon> list = theQuery.getResultList();		
		return list.get(0);
	}
	@Override
	public double tongtienHoaDon(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		double sum=0;
		try {
		
			String sql ="select sum(soLuong * donGia) from chiTietHoaDon where maHoaDon in (select maHoaDon from hoaDon\r\n"
					+ "where ngayLap  between '"+ngayBatDau+"' and '"+ ngayKetThuc +"')";
			sum = (double) session.createNativeQuery(sql).getSingleResult();


			return sum;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		// TODO Auto-generated method stub
		return sum;
	}
	@Override
	public List<?> listHoaDonBan(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			String sql ="select hd.maHoaDon,maKhachHang,ngayLap,sum(soLuong*donGia),trangThai as Tongtien from hoaDon as hd INNER JOIN chiTietHoaDon as cthd on hd.maHoaDon=cthd.maHoaDon \r\n"
					+ "where ngayLap between '"+ngayBatDau+"' and '"+ngayKetThuc+"'\r\n"
					+ "group by hd.maHoaDon,maKhachHang,ngayLap,trangThai";
			List<?> list = session.createNativeQuery(sql)
					.getResultList();		
			return list;
		} catch (Exception e) {
			// TODO: handle exception
	
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	//
	@Override
	@Transactional
	public List<HoaDon> getAllHoDon() {
		Session currentSession = sessionFactory.getCurrentSession();
//		From KhachHang kh join HoaDon hd on kh.maKhachHang = hd.maKhachHang
		Query<HoaDon> theQuery = currentSession.createQuery("from HoaDon", HoaDon.class);
		// execute query and get result list
		List<HoaDon> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<?> getHoaDonTheoMaHd() {
//		Session session = sessionFactory.getCurrentSession();
//		try {
//			String sql ="select * from HoaDon as hd INNER JOIN ChiTietHoaDon as cthd on hd.maHoaDon=cthd.maHoaDon";
//			List<?> list = session.createNativeQuery(sql).getResultList();
//			System.out.println(list);
//			return list;
//		} catch (Exception e) {
//			// TODO: handle exception
//	
//		}
//		// TODO Auto-generated method stub
//		return null;
		Session session = sessionFactory.getCurrentSession();
		
		try {
			String sql ="select sum(soLuong*donGia) as Tongtien from hoaDon as hd INNER JOIN chiTietHoaDon as cthd on hd.maHoaDon=cthd.maHoaDon \r\n"
					+ "group by hd.maHoaDon,maKhachHang,ngayLap";
			List<?> list = session.createNativeQuery(sql)
					.getResultList();		
			return list;
		} catch (Exception e) {
			// TODO: handle exception
	
		}
		// TODO Auto-generated method stub
		return null;


	}
	//
	@Override
	@Transactional
	public int SoHoaDonchuaThanhToan (String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		int sum=0;
		try {
		
			String sql ="select count(*) from hoaDon where trangThai=0 and ngayLap  between '"+ngayBatDau+"' and '"+ngayKetThuc+"'";
			sum = (int) session.createNativeQuery(sql).getSingleResult();
			return sum;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		// TODO Auto-generated method stub
		return sum;
	}
	@Override
	@Transactional
	public int SoHoaDondaThanhToan (String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		int sum=0;
		try {
		
			String sql ="select count(*) from hoaDon where trangThai=1 and ngayLap  between '"+ngayBatDau+"' and '"+ngayKetThuc+"'";
			sum = (int) session.createNativeQuery(sql).getSingleResult();
			return sum;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		// TODO Auto-generated method stub
		return sum;
	}
	



	
}
