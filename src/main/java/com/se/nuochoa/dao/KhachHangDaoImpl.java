package com.se.nuochoa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.se.nuochoa.entity.KhachHang;

@Repository
@EnableTransactionManagement
public class KhachHangDaoImpl implements KhachHangDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<KhachHang> getKhachHangs() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang", KhachHang.class);
		// execute query and get result list
		List<KhachHang> khachHang = theQuery.getResultList();
		return khachHang;
	}

	@Override
	public KhachHang getKhachHang(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		KhachHang khachHang = currentSession.get(KhachHang.class, id);
		return khachHang;
	}

	@Override
	public void saveKhachHang(KhachHang khachHang) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(khachHang);
	}

	// trả về id tiếp theo của khách hàng



	@Override
	public void deleteKhachHang(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		KhachHang khachhang = currentSession.get(KhachHang.class, theId);
		currentSession.delete(khachhang);
	}


	@Override
	public KhachHang getKhachHangByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<KhachHang> query = currentSession.createQuery("from KhachHang where tenKhachHang=:namekh");
		query.setParameter("namekh", name);
		KhachHang khachHang = (KhachHang) query.uniqueResult();
		return khachHang;
	}
	
	@Override
	public void ThemKhachHang(KhachHang khachhang) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(khachhang);		
	}

	@Override
	public KhachHang getKhachHangBysdt(String sdt) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
	
		Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang ", KhachHang.class);
		List<KhachHang> list= theQuery.getResultList();
		for(int i = 0 ; i <list.size();i++)
		{
			if(list.get(i).getSoDienThoaikh().equals(sdt))
			{
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public KhachHang getKhMax() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang order by maKhachHang desc",KhachHang.class);
		List<KhachHang> list = theQuery.getResultList();
		
		return list.get(0);
	}

	@Override
	public void UpdateKH(KhachHang kh) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(kh);
	}

}
