package com.zq.bookstore.portal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.zq.bookstore.book.pojo.Author;
import com.zq.bookstore.book.pojo.Book;
import com.zq.bookstore.book.pojo.BookComment;
import com.zq.bookstore.book.service.BookService;
import com.zq.bookstore.category.pojo.Category;
import com.zq.bookstore.category.service.CategoryService;

@Controller
public class PortalController {
	@Reference
	private CategoryService categoryService;
	@Reference
	private BookService bookService;
	
	/**
	 * 访问主页
	 * @return
	 */
	@RequestMapping(value = {"/", "index"})
	public String visitIndexPage(Model model) {
		//分类
		List<Category> categoryList = categoryService.getCategoryList();
		//新书上架
		List<Book> newestBookList = bookService.getNewestBookList(10);
		//独家书籍
		List<Book> soleBookList = bookService.getSoleBookList(8);
		//热门书籍
		List<Book> popularBookList = bookService.getPopularBookList(8);
		//畅销书籍
		List<Book> salableBookList = bookService.getSalableBookList(10);
		//名人名著
		List<Book> famousAuthorBookList = bookService.getFamousAuthorBookList(8);
		//名人作家
		List<Author> authorList = bookService.getAuthorList(5);
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("newestBookList", newestBookList);
		model.addAttribute("soleBookList", soleBookList);
		model.addAttribute("popularBookList", popularBookList);
		model.addAttribute("salableBookList", salableBookList);
		model.addAttribute("famousAuthorBookList", famousAuthorBookList);
		//若作者集合不为空，则加载到首页
		if (!authorList.isEmpty()) {
			model.addAttribute("firstAuthor", authorList.get(0));
			if (authorList.size() > 1) {
				model.addAttribute("authorList", authorList.subList(1, 5));
			}
		}
		return "index";
	}
	
	
	/**
	 * 加载图书详情页面
	 * @return
	 */
	@RequestMapping("/loadBookDetail/{bid}")
	public String loadBookDetail(@PathVariable String bid,Model model) {
		//加载图书详情
		Book book = bookService.loadBookDetail(bid);
		Category bookCategory = categoryService.findCategory(book.getCid());
		book.setCategory(bookCategory);
		
		//加载图书评论
		PageInfo<BookComment> bookCommentPageInfo = bookService.getBookCommentByBid(bid);
		model.addAttribute("book", book);
		model.addAttribute("bookCommentPageInfo", bookCommentPageInfo);
		return "book/detail";
	}
}
