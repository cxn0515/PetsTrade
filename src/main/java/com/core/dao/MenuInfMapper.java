package com.core.dao;

import com.core.entity.MenuInf;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuInfMapper {
    //查询孩子菜单
    public List<MenuInf> findAllMenu(Map<String,Object> paramMap);
}