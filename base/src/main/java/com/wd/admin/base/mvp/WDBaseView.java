package com.wd.admin.base.mvp;

import android.support.annotation.UiThread;

/**
 * Created by admin on 2017/4/7.
 */

public interface WDBaseView {
    @UiThread
    public void showLoading();

    @UiThread
    public void dismissLoading();

    @UiThread
    public void error(Throwable e);
}
