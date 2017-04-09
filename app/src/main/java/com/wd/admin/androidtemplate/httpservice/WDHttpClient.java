package com.wd.admin.androidtemplate.httpservice;

import com.wd.admin.base.http.WDBaseOkHttpClient;
import com.wd.admin.base.util.WDNetUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2017/4/9.
 */

public class WDHttpClient extends WDBaseOkHttpClient{

    public static final int CACHE_STALE_LONG = 60 * 60 * 24 * 7;

    @Override
    public OkHttpClient.Builder customize(OkHttpClient.Builder builder) {

        builder.addNetworkInterceptor(mRewriteCacheControlInterceptor);
        return builder;
    }

    /**
     *
     * 配置缓存策略
     */

    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!WDNetUtil.isNetworkConnected()) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (WDNetUtil.isNetworkConnected()) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder().header("Cache-Control", cacheControl)
                        .removeHeader("Pragma").build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_LONG)
                        .removeHeader("Pragma").build();
            }
        }
    };
}
