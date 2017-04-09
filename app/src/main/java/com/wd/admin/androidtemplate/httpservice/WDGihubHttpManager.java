package com.wd.admin.androidtemplate.httpservice;

/**
 * Created by xiaopeng on 16/6/24.
 */
public class WDGihubHttpManager {

    private static WDGihubHttpManager instance = null;
    public static synchronized WDGihubHttpManager getInstance() {
        if (instance == null){
            instance = new WDGihubHttpManager();
        }

        return instance;
    }

    public static <T> T createApi(Class<T> clazz) {
        WDGithubRetrofit retrofit = new WDGithubRetrofit();
        return retrofit.get().create(clazz);
    }
}
