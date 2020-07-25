package com.dxc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	private int sno;
	private int cid;
	private int pid;
	private int pquantity;
	private double totdiscount;
	private double grandtotal;
	private double payamount;
	
	
	
		public Cart() {
			}
		
		public Cart(int sno, int cid, int pid, int pquantity, double totdiscount, double grandtotal, double payamount) {
			super();
			this.sno = sno;
			this.cid = cid;
			this.pid = pid;
			this.pquantity = pquantity;
			this.totdiscount = totdiscount;
			this.grandtotal = grandtotal;
			this.payamount = payamount;
		}

		@Override
	public String toString() {
		return "Cart [sno=" + sno + ", cid=" + cid + ", pid=" + pid + ", pquantity=" + pquantity + ", totdiscount="
				+ totdiscount + ", grandtotal=" + grandtotal + ", payamount=" + payamount + "]";
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public double getTotdiscount() {
		return totdiscount;
	}
	public void setTotdiscount(double totdiscount) {
		this.totdiscount = totdiscount;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public double getPayamount() {
		return payamount;
	}
	public void setPayamount(double payamount) {
		this.payamount = payamount;
	}
	
	

}
