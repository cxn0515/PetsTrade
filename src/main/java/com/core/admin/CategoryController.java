package com.core.admin;

import com.alibaba.fastjson.JSON;
import com.core.entity.Category;
import com.core.service.CategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by chengxiaonan on 2019/5/18.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/categoryList")
    public
    @ResponseBody
    List<Map<String, Object>> categoryList() {
        List<Map<String, Object>> list = categoryService.getList();
        return list;
    }

    @RequestMapping(value = "/commit")
    public
    @ResponseBody
    String commit(HttpServletRequest request, HttpServletResponse response) {
        String inserted = request.getParameter("inserted");
        String deleted = request.getParameter("deleted");
        String updated = request.getParameter("updated");
        if (StringUtils.isNotEmpty(inserted)) {
            List<Category> insertedList = JSON.parseArray(inserted, Category.class);
            if (insertedList != null && !insertedList.isEmpty()) {
                for (int i = 0; i < insertedList.size(); i++) {
                    int flag = categoryService.insertCategory(insertedList.get(i));
                }
            }
        }
        if (StringUtils.isNotEmpty(deleted)) {
            List<Category> deletedList = JSON.parseArray(deleted, Category.class);
            if (deletedList != null && !deletedList.isEmpty()) {
                for (int i = 0; i < deletedList.size(); i++) {
                    int flag = categoryService.deleteCategory(deletedList.get(i));
                }
            }
        }

        if (StringUtils.isNotEmpty(updated)) {
            List<Category> updatedList = JSON.parseArray(updated, Category.class);
            if (updatedList != null && !updatedList.isEmpty()) {
                for (int i = 0; i < updatedList.size(); i++) {
                    int flag = categoryService.updateCategory(updatedList.get(i));
                }
            }
        }

        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(JSON.toJSONString("0"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }

        return null;
    }

    @RequestMapping("/list")
    public String list(){
        return "categoryList";
    }
}
