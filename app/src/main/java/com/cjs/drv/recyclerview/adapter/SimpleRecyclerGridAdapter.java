package com.cjs.drv.recyclerview.adapter;

import com.cjs.drv.R;
import com.cjs.drv.recyclerview.model.RecyclerItem;

import java.util.List;

/**
 * 简单的网格布局拖拽排序适配器
 *
 * @author JasonChen
 * @email chenjunsen@outlook.com
 * @createTime 2021/2/10 15:18
 */
public class SimpleRecyclerGridAdapter extends SimpleRecyclerListAdapter {

    public SimpleRecyclerGridAdapter(List<RecyclerItem> recyclerItemList) {
        super(recyclerItemList);
    }

    @Override
    protected int getItemLayoutRes() {
        return R.layout.item_simple_grid;
    }
}
