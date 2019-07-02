package com.core.dao;

import com.core.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:chengxiaonan
 * @Date:2019/7/2
 */
@Repository
public interface CategoryDao {
    List<Map<String,Object>> getList();

    int insertCategory(Category category);

    int deleteCategory(Category category);

    int updateCategory(Category category);
}
