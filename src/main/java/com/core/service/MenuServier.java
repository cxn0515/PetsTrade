package com.core.service;

import com.core.entity.MenuInf;

import java.util.List;
import java.util.Map;

/**
 * @Author:chengxiaonan
 * @Date:2019/6/26
 */
public interface MenuServier {
    List<MenuInf> findAllMenu(Map<String,Object> paramMap);
}
