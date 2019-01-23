package com.zq.bookstore.category.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.bookstore.category.pojo.Category;
import com.zq.bookstore.category.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Override
	public List<Category> getCategoryList() {
		List<Category> list = new ArrayList<Category>();
		Category c = new Category();
		c.setCid(1);
		c.setCname("计算机科学");
		list.add(c);
		return list;
	}
}
