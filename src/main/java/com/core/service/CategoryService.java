package com.core.service;

import com.core.entity.Category;

import java.util.List;
import java.util.Map;

/**
 * @Author:chengxiaonan
 * @Date:2019/7/2
 */
public interface CategoryService {
    List<Map<String,Object>> getList();

    int insertCategory(Category category);

    int deleteCategory(Category category);

    int updateCategory(Category category);
}
