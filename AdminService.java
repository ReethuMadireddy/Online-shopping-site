package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDao;
import com.dxc.pojo.AdminPojo;
import com.dxc.pojo.CustomerPojo;
import com.dxc.pojo.ProductPojo;

public class AdminService {
	
	AdminDao dao=new AdminDao();
	
	/*public int admin(int id,int password)
	{
		return dao.admin(id,password);
	}*/
	public void addProduct(ProductPojo p)
	{
		dao.addProduct(p);
	}
	public List<ProductPojo> SelectProduct() 
 	{ 
 		return dao.SelectProduct(); 
 	} 
	public void addCustomer(CustomerPojo c)
	{
		 dao.addCustomer(c);
	}
	public boolean removeCustomer(int cid) 
	 	{ 
	 		return dao.removeCustomer(cid); 
	 	}
	public List<CustomerPojo> SelectCustomer() 
 	{ 
 		return dao.SelectCustomer(); 
 	}


}
