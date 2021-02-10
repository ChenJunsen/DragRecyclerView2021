package com.cjs.drv;

import android.os.Bundle;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjs.drv.dummy.DataFactory;
import com.cjs.drv.recyclerview.adapter.SimpleRecyclerListAdapter;
import com.cjs.drv.recyclerview.adapter.holder.SimpleRecyclerViewHolder;
import com.cjs.drv.recyclerview.darghelpercallback.VerticalDragSortHelperCallBack;
import com.cjs.drv.recyclerview.decor.GapDecoration;
import com.cjs.drv.recyclerview.model.RecyclerItem;

import java.util.List;

/**
 * 垂直拖拽排序
 *
 * @author JasonChen
 * @email chenjunsen@outlook.com
 * @createTime 2021/2/9 10:30
 */
public class SortVerticalActivity extends BaseActivity {
    private RecyclerView recycler;
    private SimpleRecyclerListAdapter adapter;
    private List<RecyclerItem> list;
    private ItemTouchHelper itemTouchHelper;
    private VerticalDragSortHelperCallBack verticalDragSortHelperCallBack;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_sort_vertical;
    }

    @Override
    protected int setToolBarId() {
        return R.id.toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        recycler = findViewById(R.id.recycler);
    }

    @Override
    protected void initEvents(Bundle savedInstanceState) {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list = DataFactory.generateRecyclerItemList();
        adapter = new SimpleRecyclerListAdapter(list);
        adapter.setOnItemCLickListener(new SimpleRecyclerListAdapter.OnItemCLickListener() {
            @Override
            public void onItemClick(RecyclerItem item, SimpleRecyclerViewHolder holder, int position) {
                toastShort("点击了Item" + item + ",位置:" + position);
            }
        });
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new GapDecoration());
        VerticalDragSortHelperCallBack callBack = new VerticalDragSortHelperCallBack(list);
        callBack.setOnDragListener(new VerticalDragSortHelperCallBack.OnDragListener() {
            @Override
            public void onItemMoved(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target, int fromPos, int toPos) {
                toastShort("位置发生了改变:" + fromPos + "--->" + toPos);
            }
        });
        itemTouchHelper = new ItemTouchHelper(callBack);
        itemTouchHelper.attachToRecyclerView(recycler);
    }
}