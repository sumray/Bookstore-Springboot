package com.zq.bookstore.order.pojo;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int oid;
	private String oname;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	
	
}
