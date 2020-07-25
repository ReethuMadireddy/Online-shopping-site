package com.dxc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojo.AdminPojo;
import com.dxc.pojo.CustomerPojo;
import com.dxc.pojo.ProductPojo;

public class AdminDao {
	
private static SessionFactory sessionfactory;
	
	static
	{
		Configuration configuration = new Configuration().configure();
		sessionfactory=configuration.buildSessionFactory();
	}
	
	/*public int admin(int id,int password)
	{
		Session session=sessionfactory.openSession();
        Query query=session.createQuery("from admin");
       List<AdminPojo> list= query.getResultList();
        if(id.equals(getId()) && password.equals(getPassword))
        {
        	return 1;
        }
        else
        {
        	return 0;
        }
        
	}*/
	public void addProduct(ProductPojo p)
	{
    Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.save(p);
	session.getTransaction().commit();
	}
	
	public List<ProductPojo> SelectProduct() 
 	{ 
		System.out.println("ccc");
		Session session=sessionfactory.openSession(); 
 		Query query=session.createQuery("from ProductPojo");
 		System.out.println("ddd");
 		return query.getResultList(); 
 	}
	
	public void addCustomer(CustomerPojo c)
	{
    Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.save(c);
	session.getTransaction().commit();
	}
	
	public boolean removeCustomer(int i) 
	 	{ 
	 		Session session=sessionfactory.openSession(); 
	 		session.beginTransaction(); 
	 		Query query=session.createQuery("delete from CustomerPojo where cid=:i"); 
	 		query.setParameter("i", i); 
	 		query.executeUpdate(); 
	 		session.getTransaction().commit(); 
	 		return true;
	 	}
	public List<CustomerPojo> SelectCustomer() 
 	{ 
		System.out.println("ccc");
		Session session=sessionfactory.openSession(); 
 		Query query=session.createQuery("from CustomerPojo");
 		System.out.println("ddd");
 		return query.getResultList(); 
 	}
	
}
