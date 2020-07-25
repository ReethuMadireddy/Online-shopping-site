package com.dxc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojo.Cart;
import com.dxc.pojo.CustomerPojo;
import com.dxc.pojo.ProductPojo;

public class CustomerDao {

	private static SessionFactory sessionfactory;

	static {
		Configuration configuration = new Configuration().configure();
		sessionfactory = configuration.buildSessionFactory();
	}

	public boolean Custlogin(int cid, int cpassword) {
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from CustomerPojo");
		List<CustomerPojo> list = query.getResultList();
		for (CustomerPojo l : list) {
			l.getCid();
			l.getCpassword();
			if (cid == l.getCid() && cpassword == l.getCpassword()) {
				System.out.println("ccc");
				return true;
			}
		}
		System.out.println("ddd");
		return false;
	}

	public List<ProductPojo> SelectProduct() {
		System.out.println("ccc");
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from ProductPojo");
		System.out.println("ddd");
		return query.getResultList();
	}

	public boolean findProduct(int pid) {
		ProductPojo v = null;
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from productpojo where pid=:pid");
		query.setParameter("pid", pid);
		List<ProductPojo> v1 = query.getResultList();
		try {
			v = v1.get(0);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public boolean addCart(int cid, int pid, ProductPojo p, Cart cart, int userquantity) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query query1 = session.createQuery("from ProductPojo where pid=:pid");
		query1.setParameter("pid", pid);
		List<ProductPojo> list = query1.getResultList();
		System.out.println(list);

		ProductPojo p1 = list.get(0);
		if (p1.getPquantity() >= userquantity) {

			double discount = p1.getPcost() / p1.getPdiscount();
			double grandtotal = userquantity * p1.getPcost(); //
			double totdiscount = (userquantity * discount) * 2;
			double payamount = grandtotal - totdiscount;

			// "discount" value="${product.getDiscount() / 100}"
			// "grandTotal" value="${price * quantity}"
			// "totalDiscount" value="${grandTotal * (discount)}
			// ="payableAmount" value="${grandTotal - totalDiscount}"

			cart.setCid(cid);
			cart.setPid(p1.getPid());
			cart.setPquantity(userquantity);
			cart.setGrandtotal(grandtotal);
			cart.setTotdiscount(totdiscount);
			cart.setPayamount(payamount);

			Session session1 = sessionfactory.openSession();
			session1.beginTransaction();
			session1.save(cart);
			session1.getTransaction().commit();

			// session.close();
			// session1.close();
			return true;
		}
		return false;

	}

	public List<Cart> SelectCart(Cart cart, int cid) {

		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from Cart where cid=:cid");
		query.setParameter("cid", cid);
		List<Cart> list = query.getResultList();
		for (Cart c : list) {
			if (c.getCid() == cid) {
				return query.getResultList();
			}
		}
		return null;
	}

	public boolean PayBill(int cid, int pid, int userquantity, Cart cart) {
		// reduce quantity in product table
		// reduce bal in customer table
		// delete from cart table after bill pay
		int u = 0;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from ProductPojo where pid=:pid");
		query.setParameter("pid", pid);

		List<ProductPojo> list = query.getResultList();
		for (ProductPojo p : list) {
			u = p.getPquantity() - userquantity;
			Query query1 = session.createQuery("update ProductPojo set Pquantity=:Pquantity where pid=:pid ");
			query1.setParameter("pid", pid);
			query1.setParameter("Pquantity", u);
			query1.executeUpdate();
		}
		session.getTransaction().commit();

		Session session1 = sessionfactory.openSession();
		session1.beginTransaction();
		Query query2 = session1.createQuery("from CustomerPojo where cid=:cid");
		query2.setParameter("cid", cid);

		List<CustomerPojo> list1 = query2.getResultList();
		double bal = 0;
		for (CustomerPojo c : list1) {
			Session session3 = sessionfactory.openSession();
			session3.beginTransaction();
			Query query5 = session3.createQuery("from Cart where cid=:cid and pid=:pid");
			query5.setParameter("cid", cid);
			query5.setParameter("pid", pid);
			List<Cart> l1 = query5.getResultList();
			for (Cart c1 : l1) {
				
				if (c.getBalance() >= c1.getPayamount()) {

					bal = c.getBalance() - c1.getPayamount();
					Query query3 = session1.createQuery("update CustomerPojo set balance=:bal where cid=:cid ");
					query3.setParameter("cid", cid);
					query3.setParameter("bal", bal);
					query3.executeUpdate();
					
				//	return true;
				 
				}
				 else {
					return false;
				}
			}
			session3.getTransaction().commit();
		}
		session1.getTransaction().commit();
		
		

		Session session2 = sessionfactory.openSession();
		System.out.println("Entered session");
		session2.beginTransaction();
		Query query3 = session2.createQuery("delete from Cart where cid=:cid AND pid=:pid");
		query3.setParameter("cid", cid);
		query3.setParameter("pid", pid);
		query3.executeUpdate();
		session2.getTransaction().commit();

		return true;
	}

public boolean addMoney(CustomerPojo p,int balance,int cid)
{
	
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	Query query = session.createQuery("from CustomerPojo where cid=:cid");
	query.setParameter("cid",cid);
	
	double bal=0;
	List<CustomerPojo> list=query.getResultList();
	for(CustomerPojo c:list)
	{
	bal = c.getBalance()+balance;
	Query query1 = session.createQuery("update CustomerPojo set balance=:bal where cid=:cid ");
	query1.setParameter("cid", cid);
	query1.setParameter("bal", bal);
	query1.executeUpdate();
	}
	session.getTransaction().commit();

	return true;
}
}