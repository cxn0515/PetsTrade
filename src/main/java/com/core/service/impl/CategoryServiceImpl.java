package com.core.service.impl;

import com.core.dao.CategoryDao;
import com.core.entity.Category;
import com.core.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author:chengxiaonan
 * @Date:2019/7/2
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryDao categoryDao;
    @Override
    public List<Map<String,Object>> getList() {
        return categoryDao.getList();
    }

    @Override
    public int insertCategory(Category category) {
        return categoryDao.insertCategory(category);
    }

    @Override
    public int deleteCategory(Category category) {
        return categoryDao.deleteCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }
}
