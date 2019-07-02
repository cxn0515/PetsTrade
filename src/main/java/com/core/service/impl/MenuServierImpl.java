package com.core.service.impl;

import com.core.dao.MenuInfMapper;
import com.core.entity.MenuInf;
import com.core.service.MenuServier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("MenuServier")
public class MenuServierImpl implements MenuServier {
    @Resource
    private MenuInfMapper menuInfMapper;
    @Override
    public List<MenuInf> findAllMenu(Map<String,Object> paramMap) {

        // TODO Auto-generated method stub
        return menuInfMapper.findAllMenu(paramMap);
    }

}