package com.zq.bookstore.book.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Array;
import com.zq.bookstore.book.mapper.AuthorMapper;
import com.zq.bookstore.book.mapper.BookMapper;
import com.zq.bookstore.book.mapper.BookServiceMapper;
import com.zq.bookstore.book.pojo.Author;
import com.zq.bookstore.book.pojo.AuthorExample;
import com.zq.bookstore.book.pojo.Book;
import com.zq.bookstore.book.pojo.BookComment;
import com.zq.bookstore.book.pojo.BookExample;
import com.zq.bookstore.book.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private BookServiceMapper bookServiceMapper;
	@Autowired
	private AuthorMapper authorMapper;
	/**
	 * 获取新书列表
	 * @param size	需要的本数，若为空，则展示全部
	 * @return
	 */
	public List<Book> getNewestBookList(int size) {
		BookExample example = new BookExample();
		example.setOrderByClause("create_time desc");
		List<Book> bookList = bookMapper.selectByExample(example);
		if (bookList.size() > size && size > 0) {
			List<Book> newBookList = bookList.subList(0, size);
			return newBookList;
		}else{
			return bookList;
		}
	}
	
	
	/**
	 * 获取独家书籍列表
	 * @param size	需要的本数，若为空，则展示全部
	 * @return
	 */
	public List<Book> getSoleBookList(int size) {
		BookExample example = new BookExample();
		example.createCriteria().andIssoleEqualTo(true);	//1为独家书籍
		example.setOrderByClause("create_time desc");
		List<Book> bookList = bookMapper.selectByExample(example);
		if (bookList.size() > size && size >0) {
			List<Book> newBookList = bookList.subList(0, size);
			return newBookList;
		}else {
			return bookList;
		}
	}
	
	
	/**
	 * 获取热门书籍列表
	 * 热门度根据评论数决定
	 * @param size	需要的本数，若为空，则展示全部
	 * @return
	 */
	public List<Book> getPopularBookList(int size){
		List<Book> bookList = bookServiceMapper.getBooksByCommentCounts();
		if (bookList.size() > size && size >0) {
			List<Book> newBookList = bookList.subList(0, size);
			return newBookList;
		}else {
			return bookList;
		}
	}
	
	
	/**
	 *  获取畅销书籍列表
	 * @param size	需要的本数，若为空，则展示全部
	 * @return
	 */
	public List<Book> getSalableBookList(int size){
		BookExample example = new BookExample();
		example.setOrderByClause("sales_count desc");
		List<Book> bookList = bookMapper.selectByExample(example);
		if (bookList.size() > size && size >0) {
			List<Book> newBookList = bookList.subList(0, size);
			return newBookList;
		}else {
			return bookList;
		}
	}


	
	/**
	 * 获取名人名著书籍列表
	 * @param size	需要的本数，若为空，则获取全部
	 * @return
	 */
	public List<Book> getFamousAuthorBookList(int size) {
		List<Book> bookList = bookServiceMapper.getFamousAuthorBookList();
		if (bookList.size() > size && size >0) {
			List<Book> newBookList = bookList.subList(0, size);
			return newBookList;
		}else {
			return bookList;
		}
	}
	
	/**
	 * 获取名人作家列表
	 * @param size	需要的作家数，若为空，则获取全部
	 * @return
	 */
	public List<Author> getAuthorList(int size){
		AuthorExample example = new AuthorExample();
		example.createCriteria().andIsfamousEqualTo(true);
		List<Author> authorList = authorMapper.selectByExample(example);
		if (authorList.isEmpty()) {
			return authorList;
		}
		//为第一个作家赋值bookList属性
		BookExample bookExample = new BookExample();
		Author firstAuthor = authorList.get(0);
		bookExample.createCriteria().andAidEqualTo(firstAuthor.getAid());
		List<Book> bookList = bookMapper.selectByExample(bookExample);
		firstAuthor.setBookList(bookList);
		
		if (authorList.size() > size && size >0) {
			List<Author> newAuthorList = authorList.subList(0, size);
			return newAuthorList;
		}else {
			return authorList;
		}		
	}


	/**
	 * 根据bid加载图书详情
	 */
	public Book loadBookDetail(String bid) {
		if (StringUtils.isEmpty(bid)) {
			return null;
		}
		
		Book book = bookMapper.selectByPrimaryKey(bid);
		Author author = authorMapper.selectByPrimaryKey(book.getAid());
		book.setAuthor(author);
		return book;
	}


	/**
	 * 通过bid获取该书的评论
	 * @param bid
	 * @return
	 */
	public PageInfo<BookComment> getBookCommentByBid(String bid) {
		PageHelper.startPage(1, 10);
		List<BookComment> bookCommentList = bookServiceMapper.getBookCommentByBid(bid);
		PageInfo<BookComment> pageInfo = new PageInfo<>(bookCommentList);
		return pageInfo;
	}
}
