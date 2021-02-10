package com.cjs.drv.dummy;

import com.cjs.drv.recyclerview.model.RecyclerItem;
import com.cjs.third.ResUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据工厂
 *
 * @author JasonChen
 * @email chenjunsen@outlook.com
 * @createTime 2021/2/9 15:07
 */
public class DataFactory {

    public static final String PKG_NAME = "com.cjs.drv";
    public static final String ICON_PREFIX = "calendar_";

    public static List<RecyclerItem> generateRecyclerItemList() {
        List<RecyclerItem> recyclerItemList = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            int iconId = ResUtils.getInstance().getDrawableResId(ICON_PREFIX + i, PKG_NAME);
            String text = "测试数据:" + i;
            recyclerItemList.add(new RecyclerItem(iconId, text));
        }
        return recyclerItemList;
    }
}
