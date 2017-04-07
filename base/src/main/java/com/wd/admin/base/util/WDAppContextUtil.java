package com.wd.admin.base.util;

import android.content.Context;

public class WDAppContextUtil {
    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static Context getInstance() {
        if (sContext == null) {
            throw new NullPointerException("the context is null,please init WDAppContextUtil in Application first.");
        }
        return sContext;
    }
}
