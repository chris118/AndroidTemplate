package com.wd.admin.androidtemplate;

import android.app.Application;
import android.content.Context;

import com.wd.admin.base.retrofit.RetrofitManager;
import com.wd.admin.base.util.WDAppContextUtil;

/**
 * Created by admin on 2017/4/8.
 */

public class WDApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initBaseModule();
    }

    private void initBaseModule() {

        // pass context to base module
        WDAppContextUtil.init(this);

        // build the Retrofit Manager
        RetrofitManager.getInstance().builder();
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return WDAppContextUtil.getInstance();
    }
}
