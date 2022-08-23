package com.w.mhl.service;

import com.w.mhl.dao.BillDAO;
import com.w.mhl.domain.Bill;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

/**
 * @author blue
 * @version 1.0
 * 处理和账单相关的业务逻辑
 */
public class BillService {

    //定义BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //定义MenuService属性
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();

    //编写点餐的的方法
    //1. 生成账单
    //2. 需要更新对应餐桌的状态
    //3. 如果成功
    public boolean orderMenu(int menuId, int nums, int diningTableId) {

        //生成一个订单号. UUID
        String billId = UUID.randomUUID().toString();

        //将账单生成到bill表，要求直接计算账单金额
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if (update <= 0) {
            return false;
        }

        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");

    }

    //返回所有的账单，提供给View调用
    public List<Bill> listBill() {

        List<Bill> bills = billDAO.queryMulti("select * from bill", Bill.class);

        return bills;
    }

    //查看某个餐桌是否有未结账的
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill =
                billDAO.querySingle("select * from bill where diningTableId = ? and state = '未结账' limit 0, 1", Bill.class, diningTableId);
        return bill != null;
    }

    //完成结账[如果餐桌存在，并且该餐桌有未结账的账单]
    public boolean payBill(int diningTableId, String payMode) {

        //1.修改bill表
        int update = billDAO.update("update bill set state = ? where diningTableId = ? and state = '未结账'", payMode, diningTableId);

        //没有更新成功则表示失败
        if (update <= 0) {
            return false;
        }

        //2. 修改diningTable表
        if (!(diningTableService.updateDiningTableToFree(diningTableId, "空"))) {
            return false;
        }

        return true;
    }

}
