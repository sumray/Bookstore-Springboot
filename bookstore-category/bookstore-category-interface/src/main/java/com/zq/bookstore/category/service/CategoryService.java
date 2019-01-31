package com.zq.bookstore.category.service;

import java.util.List;

import com.zq.bookstore.category.pojo.Category;

public interface CategoryService {
	/**
	 * 获取所有的分类列表
	 * @return
	 */
	List<Category> getCategoryList();

	/**
	 * 通过cid获取指定的分类
	 * @param cid
	 * @return
	 */
	Category findCategory(Integer cid);
}
