package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.model.GuestUser;

@Component
public class GuestUserDAOImpl implements GuestUserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addGuestUser(GuestUser guest) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(guest);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public GuestUser findGuestUser(int id) 
	{
		Session session = sessionFactory.openSession();
		GuestUser guest = session.get(GuestUser.class,id);
		return guest;
	}

	@Override
	public List<GuestUser> findAllGuestUser() 
	{
		Session session = sessionFactory.openSession();
		List<GuestUser> guestlist = session.createQuery("select g from GuestUser g").list();
		return guestlist;
	}

	@Override
	public boolean updateGuestUser(GuestUser guest) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(guest);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteGuestUser(int id) 
	{
		Session session = sessionFactory.openSession();
		GuestUser guest=session.find(GuestUser.class,id);
		session.getTransaction().begin();
		session.delete(guest);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public boolean checkGuestUser(String userName, String password) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select a from Admin a where userName=:uname and password=:pass");
		query.setParameter("uname",userName);
		query.setParameter("pass",password);
		List list=query.list();
//		if(list.size()>0)
//		{
//			return false;
//		}
		return true;
	}
}
