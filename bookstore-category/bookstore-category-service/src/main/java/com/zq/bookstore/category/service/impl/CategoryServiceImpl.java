package com.zq.bookstore.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.zq.bookstore.category.mapper.CategoryMapper;
import com.zq.bookstore.category.pojo.Category;
import com.zq.bookstore.category.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 获取所有分类集合
	 */
	@Override
	public List<Category> getCategoryList() {
		return categoryMapper.selectByExample(null);
	}

	
	/**
	 * 通过cid获取所有的分类
	 */
	public Category findCategory(Integer cid) {
		Category category = categoryMapper.selectByPrimaryKey(cid);
		return category;
	}
}
