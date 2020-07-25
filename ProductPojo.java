package com.dxc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductPojo {

	@Id
	private int pid;
	private String pname;
	private int pcost;
	private int pquantity;
	private double pdiscount;

	public ProductPojo() {
	}

	public ProductPojo(int pid, String pname, int pcost, int pquantity, double pdiscount) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pquantity = pquantity;
		this.pdiscount = pdiscount;
	}

	public double getPdiscount() {
		return pdiscount;
	}

	public void setPdiscount(double pdiscount) {
		this.pdiscount = pdiscount;
	}

	@Override
	public String toString() {
		return "ProductPojo [pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", pquantity=" + pquantity
				+ ", pdiscount=" + pdiscount + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

}
