package com.wd.admin.androidtemplate.application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.wd.admin.base.WDCoreApp;

/**
 * Created by admin on 2017/4/8.
 */

public class WDApplication extends WDCoreApp {
    @Override
    public void onCreate() {
        super.onCreate();

        Logger.init("AndroidTemplate")                 // default PRETTYLOGGER or use just init()
                .methodCount(2)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(0);               // default 0
    }
}
