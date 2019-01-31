package com.zq.bookstore.book.mapper;

import java.util.List;

import com.zq.bookstore.book.pojo.Book;
import com.zq.bookstore.book.pojo.BookComment;

/**
 * Book业务mapper（多表操作）
 * @author Administrator
 *
 */
public interface BookServiceMapper {
	/**
	 * 通过评论数获取图书列表
	 * @return
	 */
	List<Book> getBooksByCommentCounts();
	
	
	/**
	 * 获取名人名著书籍列表
	 * @return
	 */
	List<Book> getFamousAuthorBookList();
	
	
	/**
	 * 获取该书的评论
	 * @return
	 */
	List<BookComment> getBookCommentByBid(String bid);
}
