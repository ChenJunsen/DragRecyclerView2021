package com.cjs.drv;

import android.os.Bundle;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjs.drv.dummy.DataFactory;
import com.cjs.drv.recyclerview.adapter.SimpleRecyclerListAdapter;
import com.cjs.drv.recyclerview.adapter.holder.SimpleRecyclerViewHolder;
import com.cjs.drv.recyclerview.darghelpercallback.SlideDeleteHelperCallBack;
import com.cjs.drv.recyclerview.decor.GapDecoration;
import com.cjs.drv.recyclerview.model.RecyclerItem;

import java.util.List;

/**
 * 侧滑删除案例
 *
 * @author JasonChen
 * @email chenjunsen@outlook.com
 * @createTime 2021/2/10 10:39
 */
public class SlideDeleteActivity extends BaseActivity {
    private RecyclerView recycler;
    private List<RecyclerItem> list;
    private SimpleRecyclerListAdapter adapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_slide_delete;
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
        adapter = new SimpleRecyclerListAdapter(list);
        adapter.setOnItemCLickListener(new SimpleRecyclerListAdapter.OnItemCLickListener() {
            @Override
            public void onItemClick(RecyclerItem recyclerItem, SimpleRecyclerViewHolder holder, int position) {
                toastShort("点击了:" + recyclerItem + " 位置:" + position);
            }
        });
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new GapDecoration());

        SlideDeleteHelperCallBack callBack = new SlideDeleteHelperCallBack(recycler, list);
        callBack.setOnSwipedListener(new SlideDeleteHelperCallBack.OnSwipedListener() {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, RecyclerItem deletedItem, int deletedPos) {
                toastShort("删除了:" + deletedItem + " 位置:" + deletedPos);
            }
        });
        itemTouchHelper = new ItemTouchHelper(callBack);
        itemTouchHelper.attachToRecyclerView(recycler);
    }
}