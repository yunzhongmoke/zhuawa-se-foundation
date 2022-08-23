package com.w.jdbc.dao_.test;

import com.w.jdbc.dao_.dao.AdminDAO;
import com.w.jdbc.dao_.dao.GoodsDAO;
import com.w.jdbc.dao_.domain.Admin;
import com.w.jdbc.dao_.domain.Goods;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author blue
 * @version 1.0
 */
public class TestDAO {

    @Test
    public void testAdminDAO() {
        AdminDAO adminDAO = new AdminDAO();
//        Admin admin = adminDAO.querySingle("select * from admin where name = ?", Admin.class, "blue");
//        System.out.println("1");
//        System.out.println(adminDAO.getConnection());
//        System.out.println(admin);
//        List<Admin> admins = adminDAO.queryMulti("select * from admin", Admin.class);
//        System.out.println("2");
//        System.out.println(adminDAO.getConnection());
//        for (Admin a : admins){
//            System.out.print(a);
//        }

//        Object blue = adminDAO.queryScalar("select password from admin where name = ?", "blue");
//        System.out.println("blue: " + blue);

//        int affectedRows = adminDAO.update("insert into admin values(?, ?)", "lalala", "123456");
//        int affectedRows = adminDAO.update("update admin set password = '1234' where name = ?", "lalala");
        int affectedRows = adminDAO.update("delete from admin where name = ?", "lalala");

        System.out.println(affectedRows > 0 ? "执行成功" : "未能影响表");

    }

    @Test
    public void testGoodsDAO() {
        GoodsDAO goodsDAO = new GoodsDAO();
//        int affectedRows = goodsDAO.update("insert into goods values(?, ?, ?)", 10, "华为手机", 2000);
//        int affectedRows = goodsDAO.update("insert into goods values(?, ?, ?)", 40, "vivo手机", 1000);
//        int affectedRows = goodsDAO.update("update goods set price = null where id = ?", 40);
//        int affectedRows = goodsDAO.update("delete from goods where id = ?", 40);

//        System.out.println(affectedRows > 0 ? "执行成功" : "未能影响表");

//        Goods goods = goodsDAO.querySingle("select * from goods where id = ?", Goods.class, 10);
//        List<Goods> goods = goodsDAO.queryMulti("select * from goods", Goods.class);
//        for (Goods good : goods){
//            System.out.println(good);
//        }
        Object goods_name = goodsDAO.queryScalar("select goods_name from goods where id = ?", 10);
        System.out.println(goods_name);
    }
}
