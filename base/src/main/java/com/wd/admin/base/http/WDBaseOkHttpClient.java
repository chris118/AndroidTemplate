package com.wd.admin.base.http;

import android.util.Log;

import com.wd.admin.base.WDCoreApp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by admin on 2017/4/9.
 */

public abstract class WDBaseOkHttpClient {
    private static final long TIMEOUT_CONNECT = 15 * 1000;

    public OkHttpClient get() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override public void log(String message) {
                Log.d("OkHttp: ", message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 指定缓存路径,缓存大小100Mb
        Cache cache = new Cache(new File(WDCoreApp.getInstance().getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache)
        .addInterceptor(loggingInterceptor)
        .retryOnConnectionFailure(true)
        .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
        .build();

        builder = customize(builder);

        return builder.build();
    }

    public abstract OkHttpClient.Builder customize(OkHttpClient.Builder builder);
}
