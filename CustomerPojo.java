package com.dxc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerPojo {
	
	@Id
	private int cid;
	private int cpassword;
	private double balance;
	
	
	
	
		@Override
	public String toString() {
		return "CustomerPojo [cid=" + cid + ", cpassword=" + cpassword + ", balance=" + balance + "]";
	}


		public CustomerPojo() {
		
	}
		

		public CustomerPojo(int cid, int cpassword, double balance) {
			super();
			this.cid = cid;
			this.cpassword = cpassword;
			this.balance = balance;
		}


		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public int getCpassword() {
			return cpassword;
		}

		public void setCpassword(int cpassword) {
			this.cpassword = cpassword;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		}
