package com.se.nuochoa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.se.nuochoa.entity.SanPham;
import com.se.nuochoa.entity.ThuongHieu;

@Repository
@EnableTransactionManagement
public class SanPhamDaoImpl implements SanPhamDao{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<SanPham> getGucci() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SanPham> theQuery = currentSession.createQuery("from SanPham where maThuongHieu=4", SanPham.class);
		List<SanPham> list= theQuery.getResultList();
		return list;
	}
	@Override
	public SanPham getSPId(String id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		SanPham sanpham = currentSession.get(SanPham.class,id);
		return sanpham;
	}
	@Override
	public List<SanPham> getVersace() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SanPham> theQuery = currentSession.createQuery("from SanPham where maThuongHieu=1", SanPham.class);
		List<SanPham> list= theQuery.getResultList();
		return list;
	}
	@Override
	public List<SanPham> getChanel() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SanPham> theQuery = currentSession.createQuery("from SanPham where maThuongHieu=2", SanPham.class);
		List<SanPham> list= theQuery.getResultList();
		return list;
	}
	@Override
	public List<SanPham> getChloe() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SanPham> theQuery = currentSession.createQuery("from SanPham where maThuongHieu=5", SanPham.class);
		List<SanPham> list= theQuery.getResultList();
		return list;
	}
	@Override
	public List<SanPham> getHermes() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SanPham> theQuery = currentSession.createQuery("from SanPham where maThuongHieu=3", SanPham.class);
		List<SanPham> list= theQuery.getResultList();
		return list;
	}
	@Override
	public List<SanPham> getCavin() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SanPham> theQuery = currentSession.createQuery("from SanPham where maThuongHieu=6", SanPham.class);
		List<SanPham> list= theQuery.getResultList();
		return list;
	}
	@Override
	public List<SanPham> getSPBanChay() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<SanPham> listSP = new ArrayList<SanPham>();
		List<String> listmasp =	currentSession.createNativeQuery("select top 12 sanPham.maSanPham from chiTietHoaDon join sanPham on chiTietHoaDon.maSanPham = sanPham.maSanPham\r\n"
				+ "group by sanPham.maSanPham\r\n"
				+ "order by sum( chiTietHoaDon.soLuong) desc").getResultList();
		for(int i = 0 ; i < listmasp.size();i++)
		{
			listSP.add(getSPId(listmasp.get(i)));
		}
		
		return listSP;
	}
	@Override
	public List<SanPham> getSPGiamGia() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
	
		List<SanPham> listsp =	currentSession.createNativeQuery("select * from sanPham where soLuong <15",SanPham.class).getResultList();
		
		
		return listsp;
	}
	@Override
	public List<SanPham> getSPAll() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<SanPham> listsp =	currentSession.createNativeQuery("select * from sanPham",SanPham.class).getResultList();
		
		
		return listsp;
	}
	
	//
	//Quan Ly San Pham
	
		
		@javax.transaction.Transactional
		public List<SanPham> getAllSanPham() {
			Session session = sessionFactory.getCurrentSession();

			try {
			String sql ="Select top 5 * From sanPham ";
			List<SanPham> list = session.createNativeQuery(sql,SanPham.class).getResultList();
			return list;
			} catch (Exception e) {
				e.printStackTrace();

			}
			
			return null;
		}

		@Override
		public void xoaSanPham(SanPham sp) {
			Session currentSession = sessionFactory.getCurrentSession();
	        // delete object with primary key
			currentSession.update(sp);
		}

		@Override
		public List<ThuongHieu> getAllThuongHieu() {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<ThuongHieu> theQuery = currentSession.createQuery("from ThuongHieu", ThuongHieu.class);
			// execute query and get result list
			List<ThuongHieu> list = theQuery.getResultList();
			return list;
		}

		@Override
		@Transactional
		public SanPham getSanPhamTheoId(String maSP) {
			 Session currentSession = sessionFactory.getCurrentSession();
	         // now retrieve/read from database using the primary key
	         SanPham theCredicCard = currentSession.get(SanPham.class, maSP);
	         return theCredicCard;
		}

//		@Override
//		public void updateSanPham(SanPham sp, String maThuongHieu) {
//			
//			
//		}

		@Override
		public SanPham getMaSanPhamCuoi() {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham order by maSanPham desc",SanPham.class);
			List<SanPham> list = theQuery.getResultList();
			
			return list.get(0);
		}

		@Override
		public boolean addSanPham(SanPham sp) {
			Session session = sessionFactory.getCurrentSession();

			try {
				
				session.save(sp); 
				
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
			
		}

		@Override
		public void updateSanPham(SanPham sp) {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(sp);
		}
		@Override
		@Transactional
		public List<SanPham> getProuductDuoi500(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh < 500000 and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuduct500Den1000(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 500000 and giaThanh <1000000 and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuduct1000Den2000(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 1000000 and giaThanh <2000000 and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuduct2000Den5000(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 2000000 and giaThanh <5000000 and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuductTren5000(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 5000000  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProductMen(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where gioiTinh = 0  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProductWoman(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where gioiTinh = 1  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct7_5ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%7.5ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct10ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%10ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct15ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%15ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct20ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%20ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct30ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%30ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct50ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%50ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct100ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%100ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct120ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%120ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct150ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%150ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct200ml(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%200ML%'  and maThuongHieu = '"+ma+"' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> searchProduct(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> thanhLy() {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where soLuong < 60  ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct7_5mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%7.5ml%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct10mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%10ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct15mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%15ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct20mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%20ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct30mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%30ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct50mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%50ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct100mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%100ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct120mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%120ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct150mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%150ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProduct200mlHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham  like '%200ML%'  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProductMenHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where gioiTinh  = 0  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProductWomanHome(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where gioiTinh  = 1  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuductDuoi500Home(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh < 500000 and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuduct500Den1000Home(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 500000 and giaThanh <1000000 and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuduct1000Den2000Home(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 1000000 and giaThanh <2000000 and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuduct2000Den5000Home(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 2000000 and giaThanh <5000000 and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> getProuductTren5000Home(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where giaThanh >= 5000000  and tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		@Override
		@Transactional
		public List<SanPham> searchProductAdmin(String ma) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SanPham> theQuery = currentSession.createQuery("from SanPham where tenSanPham like '%"+ma+"%' ", SanPham.class);
			List<SanPham> list= theQuery.getResultList();
			return list;
		}
		

}
