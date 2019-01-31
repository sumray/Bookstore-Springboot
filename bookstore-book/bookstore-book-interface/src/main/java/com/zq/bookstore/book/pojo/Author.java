package com.zq.bookstore.book.pojo;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer aid;

    private String aname;

    private Boolean isfamous;

    private String introduce;

    private String image;
    
    private List<Book> bookList;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Boolean getIsfamous() {
		return isfamous;
	}

	public void setIsfamous(Boolean isfamous) {
		this.isfamous = isfamous;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
    
    
}