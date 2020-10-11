package com.kopo.hibernateGongji.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kopo.hibernateGongji.model.Gongji;

@Repository
public class GongjiDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Gongji> selectAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Gongji> gongjiList = session.createQuery("from Gongji").list();
		return gongjiList;
	}

	public Gongji selectOne(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Gongji gongji = (Gongji) session.get(Gongji.class, new Integer(id));
		return gongji;
	}

	public Gongji insert(Gongji gongji) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(gongji);
		return gongji;
	}

	public void update(Gongji gongji) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(gongji);
	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Gongji p = (Gongji) session.load(Gongji.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
}
