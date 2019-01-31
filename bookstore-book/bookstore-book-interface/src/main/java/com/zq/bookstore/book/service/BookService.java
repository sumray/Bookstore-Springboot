package com.zq.bookstore.book.service;

import java.util.List;

import com.zq.bookstore.book.pojo.Author;
import com.zq.bookstore.book.pojo.Book;
import com.zq.bookstore.book.pojo.BookComment;

public interface BookService {
	/**
	 * 获取新书列表
	 * @param size	需要的本数，若为空，则获取全部
	 * @return
	 */
	List<Book> getNewestBookList(int size);
	
	/**
	 * 获取独家书籍列表
	 * @param size	需要的本数，若为空，则获取全部
	 * @return
	 */
	List<Book> getSoleBookList(int size);

	
	/**
	 * 获取热门书籍列表
	 * 热门度根据评论数决定
	 * @param size	需要的本数，若为空，则获取全部
	 * @return
	 */
	List<Book> getPopularBookList(int size);
	
	
	/**
	 * 获取畅销书籍列表
	 * @param size	需要的本数，若为空，则获取全部
	 * @return
	 */
	List<Book> getSalableBookList(int size);
	
	
	/**
	 * 获取名人名著书籍列表
	 * @param size	需要的本数，若为空，则获取全部
	 * @return
	 */
	List<Book> getFamousAuthorBookList(int size);
	
	
	/**
	 * 获取名人作家列表
	 * @param size	需要的作家数，若为空，则获取全部
	 * @return
	 */
	List<Author> getAuthorList(int size);
	
	/**
	 * 通过bid查询出图书详情
	 * @param bid
	 * @return
	 */
	Book loadBookDetail(String bid);
	
	
	/**
	 * 通过bid获取该书的评论
	 * @param bid
	 * @return
	 */
	List<BookComment> getBookCommentByBid(String bid);
}
