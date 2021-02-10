package com.cjs.drv;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.cjs.third.ToastUtils;


/**
 * Activity基类
 *
 * @author JasonChen
 * @email chenjunsen@outlook.com
 * @createTime 2021/2/9 10:36
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity = this;
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        int toolBarId = setToolBarId();
        if (toolBarId != -1) {
            initToolBar(toolBarId);
        }
        initView(savedInstanceState);
        initEvents(savedInstanceState);
    }

    /**
     * 设置布局Id
     *
     * @return
     */
    protected abstract int setLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initEvents(Bundle savedInstanceState);

    public void startActivity(Class<? extends Activity> clazz, Bundle data) {
        Intent i = new Intent(this, clazz);
        if (data != null) {
            i.putExtras(data);
        }
        startActivity(i);
    }

    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(clazz, null);
    }

    /**
     * 设置ToolBarId
     *
     * @return
     */
    protected @IdRes
    int setToolBarId() {
        return -1;
    }


    public int getColorResCompat(@ColorRes int colorSrc) {
        return ContextCompat.getColor(this.getApplicationContext(), colorSrc);
    }

    public Drawable getDrawableResCompat(@DrawableRes int drawableRes) {
        return ContextCompat.getDrawable(this.getApplicationContext(), drawableRes);
    }

    public void toastShort(String msg) {
        ToastUtils.showShort(this, msg);
    }

    public void toastLong(String msg) {
        ToastUtils.showLong(this, msg);
    }

    private void initToolBar(@IdRes int toolBarId) {
        toolbar = findViewById(toolBarId);
        toolbar.setBackgroundResource(R.color.pink);
        toolbar.setTitleTextColor(getColorResCompat(R.color.white));
        toolbar.setNavigationIcon(getDrawableResCompat(R.drawable.ic_back));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}