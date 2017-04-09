package com.wd.admin.base.mvp;

/**
 * Created by admin on 2017/4/7.
 */

public abstract class WDBasePresenter<M, V > {
    public M mModel;
    public V mView;

    public void attachVM(M m, V v){
        this.mModel = m;
        this.mView = v;
    }

    public void detachVM() {
        mView = null;
        mModel = null;
    }
}
