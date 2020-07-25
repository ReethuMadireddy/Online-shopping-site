package com.dxc.service;

import java.util.List;

import com.dxc.dao.CustomerDao;
import com.dxc.pojo.Cart;
import com.dxc.pojo.CustomerPojo;
import com.dxc.pojo.ProductPojo;

public class CustomerService {

	CustomerDao cdao= new CustomerDao();
	public boolean Custlogin(int cid,int cpassword)
	{
		return cdao.Custlogin(cid ,cpassword);
	}
	public List<ProductPojo> SelectProduct() 
 	{ 
 		return cdao.SelectProduct(); 
 	}
	public boolean findProduct(int pid)
	{
		return cdao.findProduct(pid);
	}
	public boolean addCart(int cid,int pid,ProductPojo p,Cart cart,int userquantity )
	{
		return cdao.addCart(cid, pid, p, cart, userquantity);
	}
	
	public List<Cart> SelectCart(int cid,Cart cart) 
 	{ 
 		return cdao.SelectCart(cart,cid); 
 	}
	public boolean PayBill(int cid,int pid,int userquantity,Cart cart)
	{
		return cdao.PayBill(cid,pid,userquantity,cart);
	}
	public boolean addMoney(CustomerPojo p, int b, int cid)
	{
		return cdao.addMoney(p,b,cid);
	}
}
