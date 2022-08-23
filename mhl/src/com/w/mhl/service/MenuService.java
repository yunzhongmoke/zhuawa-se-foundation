package com.w.mhl.service;

import com.w.mhl.dao.MenuDAO;
import com.w.mhl.domain.Menu;

import java.util.List;

/**
 * @author blue
 * @version 1.0
 */
public class MenuService {

    //定义MenuDAO属性
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有的菜品，返回给界面使用
    public List<Menu> list() {
        List<Menu> menuList = menuDAO.queryMulti("select * from menu", Menu.class);
        return menuList;
    }

    //需要方法，根据id，返回Menu对象
    public Menu getMenuById(int id) {
        Menu menu = menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
        return menu;
    }

}
