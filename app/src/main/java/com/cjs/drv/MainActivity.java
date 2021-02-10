package com.cjs.drv;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_slide_delete, btn_sort_vertical, btn_sort_grid;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        btn_slide_delete = findViewById(R.id.btn_slide_delete);
        btn_sort_vertical = findViewById(R.id.btn_sort_vertical);
        btn_sort_grid = findViewById(R.id.btn_sort_grid);
    }

    @Override
    protected void initEvents(Bundle savedInstanceState) {
        btn_slide_delete.setOnClickListener(this);
        btn_sort_vertical.setOnClickListener(this);
        btn_sort_grid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_slide_delete) {
            startActivity(SlideDeleteActivity.class);
        } else if (v == btn_sort_vertical) {
            startActivity(SortVerticalActivity.class);
        } else if (v == btn_sort_grid) {
            startActivity(SortGridActivity.class);
        }
    }
}