package com.core.entity;

import java.util.List;

/**
 * @Author:chengxiaonan
 * @Date:2019/6/26
 */
public class MenuInf {
    private String id;
    private String text;
    private String pid;
    private String state;
    private String parent;
    private String url;
    private List<MenuInf> children;

    public List<MenuInf> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInf> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
