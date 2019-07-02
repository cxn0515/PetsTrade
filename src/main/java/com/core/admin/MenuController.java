package com.core.admin;

import com.core.entity.MenuInf;
import com.core.service.MenuServier;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/MC")
public class MenuController {
    @Autowired
    @Qualifier("MenuServier")
    private MenuServier menuServier;

    @RequestMapping("/findAllMenu")
    // 查询所有菜单
    public @ResponseBody
    List<MenuInf> findAllMenu(MenuInf menu) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",menu.getId());
        List<MenuInf> list = menuServier.findAllMenu(paramMap);
        List<MenuInf> parentList = new ArrayList<>();
        if(list!=null){
            for (MenuInf menuInf : list){
                String parent = menuInf.getParent();
                if(StringUtils.isEmpty(parent)){
                    menuInf.setChildren(getChildList(list,menuInf.getPid()));
                    parentList.add(menuInf);
                }
            }

        }
        //子item state必须为空
        return parentList;

    }

    private List<MenuInf> getChildList(List<MenuInf> list, String pid) {
        List<MenuInf> childList =new ArrayList<>();
        for (MenuInf menuInf : list){
            String parent = menuInf.getParent();
            if(!StringUtils.isEmpty(parent) && parent.equals(pid)){
                childList.add(menuInf);
            }
        }
        return childList;
    }
}