package com.wd.admin.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by admin on 2017/4/9.
 */

public class WDCoreApp extends Application {
    private static WDCoreApp mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static synchronized WDCoreApp getInstance() {
        return mApp;
    }

    public static Context getAppContext() {
        return mApp.getApplicationContext();
    }

    public static Resources getAppResources() {
        return mApp.getResources();
    }
}
