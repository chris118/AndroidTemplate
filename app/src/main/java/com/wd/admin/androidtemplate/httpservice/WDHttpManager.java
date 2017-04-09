package com.wd.admin.androidtemplate.httpservice;

/**
 * Created by xiaopeng on 16/6/24.
 */
public class WDHttpManager {

    private static WDHttpManager instance = null;
    public static synchronized WDHttpManager getInstance() {
        if (instance == null){
            instance = new WDHttpManager();
        }

        return instance;
    }

    public static <T> T createGithubApi(Class<T> clazz) {
        WDGithubRetrofit retrofit = new WDGithubRetrofit();
        return retrofit.get().create(clazz);
    }

    public static <T> T createXXXApi(Class<T> clazz) {
        WDXXXRetrofit retrofit = new WDXXXRetrofit();
        return retrofit.get().create(clazz);
    }
}
