package com.wd.admin.androidtemplate.httpservice;

import com.wd.admin.base.http.WDApiEndpoint;
import com.wd.admin.base.http.WDBaseRetrofit;

import okhttp3.OkHttpClient;

/**
 * Created by admin on 2017/4/9.
 */

public class WDGithubRetrofit extends WDBaseRetrofit{
    private static final String END_POINT = "https://api.github.com/";

    WDGithubHttpClient githubHttpClient = new WDGithubHttpClient();

    @Override
    public WDApiEndpoint getApiEndpoint() {
        return new WDApiEndpoint() {
            @Override
            public String getEndpoint() {
                return END_POINT;
            }
        };
    }

    @Override
    public OkHttpClient getHttpClient() {
        return githubHttpClient.get();
    }
}
