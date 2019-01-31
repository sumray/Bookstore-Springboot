package com.zq.bookstore.category.pojo;

import java.io.Serializable;

public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer cid;

    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}