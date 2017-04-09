package com.wd.admin.base.mvp;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by admin on 2017/4/7.
 */

public abstract class WDBasePresenter<M, V > {
    public M mModel;
    public V mView;

    protected CompositeSubscription mCompositeSubscription;

    public void attachVM(M m, V v){
        this.mModel = m;
        this.mView = v;
        mCompositeSubscription = new CompositeSubscription();
    }

    public void detachVM() {
        mView = null;
        mModel = null;

        mCompositeSubscription.clear();
        mCompositeSubscription = null;
    }
}
