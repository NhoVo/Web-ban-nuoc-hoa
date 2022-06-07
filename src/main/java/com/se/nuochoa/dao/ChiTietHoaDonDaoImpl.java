package com.se.nuochoa.dao;

import java.util.ArrayList;
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



@Repository
@EnableTransactionManagement
public class ChiTietHoaDonDaoImpl implements ChiTietHoaDonDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ChiTietHoaDon getChiTietHoaDonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<ChiTietHoaDon> getChiTietHoaDons() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ChiTietHoaDon> theQuery = currentSession.createQuery("from chiTietHoaDon", ChiTietHoaDon.class);
		// execute query and get result list
		List<ChiTietHoaDon> chiTietHoaDons = theQuery.getResultList();
		return chiTietHoaDons;
	}

	@Override
	public ChiTietHoaDon getChiTietHoaDon(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		ChiTietHoaDon chiTietHoaDon = currentSession.get(ChiTietHoaDon.class, theId);
		return chiTietHoaDon;
	}
	@Override
	public List<ChiTietHoaDon> getDsCTHD(HoaDon hoaDon) {
		List<ChiTietHoaDon> result = new ArrayList<ChiTietHoaDon>();

		Session session = sessionFactory.getCurrentSession();

		Transaction tran = session.beginTransaction();

		try {
			result = session.createNativeQuery("select * from CTHoaDon where maHoaDon = :x", ChiTietHoaDon.class)
				.setParameter("x", hoaDon.getMaHoaDon())
				.getResultList();
			
			tran.commit();

		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}

		return result;
	}
	@Override
	public void ThemCTHD(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(chiTietHoaDon);
		
	}
	
	@Override
	@Transactional
	public List<ChiTietHoaDon> getAllChiTietHoaDon() {
		Session session = sessionFactory.getCurrentSession();
		Query<ChiTietHoaDon> theQuery = session.createQuery("from ChiTietHoaDon",ChiTietHoaDon.class);
		List<ChiTietHoaDon> list = theQuery.getResultList();
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	@Transactional
	public ChiTietHoaDon getHoaDonTheoMaHd(String maHD) {
		Session session = sessionFactory.getCurrentSession();
        // now retrieve/read from database using the primary key
//        ChiTietHoaDon theCredicCard = currentSession.get(ChiTietHoaDon.class, maHD);
		Query<ChiTietHoaDon> theQuery = session.createQuery("from ChiTietHoaDon",ChiTietHoaDon.class);
		List<ChiTietHoaDon> list = theQuery.getResultList();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getHoaDon().getMaHoaDon().equals(maHD)) {
				return list.get(i);
			}
		}
        return null;	
	}

}
