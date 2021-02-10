package com.cjs.drv;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.cjs.drv.dummy.DataFactory;
import com.cjs.drv.recyclerview.adapter.SimpleRecyclerGridAdapter;
import com.cjs.drv.recyclerview.adapter.SimpleRecyclerListAdapter;
import com.cjs.drv.recyclerview.adapter.holder.SimpleRecyclerViewHolder;
import com.cjs.drv.recyclerview.darghelpercallback.GridSortHelperCallBack;
import com.cjs.drv.recyclerview.darghelpercallback.VerticalDragSortHelperCallBack;
import com.cjs.drv.recyclerview.decor.GapGridDecoration;
import com.cjs.drv.recyclerview.model.RecyclerItem;

import java.util.List;

public class SortGridActivity extends BaseActivity {
    private RecyclerView recycler;
    private SimpleRecyclerGridAdapter adapter;
    private List<RecyclerItem> list;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_sort_grid;
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
        list = DataFactory.generateRecyclerItemList();
        adapter = new SimpleRecyclerGridAdapter(list);
        adapter.setOnItemCLickListener(new SimpleRecyclerListAdapter.OnItemCLickListener() {
            @Override
            public void onItemClick(RecyclerItem recyclerItem, SimpleRecyclerViewHolder holder, int position) {
                toastShort("点击了:" + recyclerItem + " 位置:" + position);
            }
        });
        recycler.setAdapter(adapter);
        int spanCount = 4;
        recycler.setLayoutManager(new GridLayoutManager(this, spanCount));
        recycler.addItemDecoration(new GapGridDecoration(spanCount));

        GridSortHelperCallBack callBack = new GridSortHelperCallBack(list);
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