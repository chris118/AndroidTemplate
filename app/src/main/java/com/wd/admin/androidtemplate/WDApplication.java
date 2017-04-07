package com.wd.admin.androidtemplate;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
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

        initApplication();
    }

    private void initBaseModule() {

        // pass context to base module
        WDAppContextUtil.init(this);

        // build the Retrofit Manager
        RetrofitManager.getInstance().builder();
    }

    private void initApplication(){
        Logger.init("AndroidTemplate")                 // default PRETTYLOGGER or use just init()
                .methodCount(2)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(0);               // default 0
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return WDAppContextUtil.getInstance();
    }
}
