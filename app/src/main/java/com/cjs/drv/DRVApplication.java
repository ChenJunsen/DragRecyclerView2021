package com.cjs.drv;

import android.app.Application;

import com.cjs.third.ResUtils;

public class DRVApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ResUtils.init(this);
    }
}
