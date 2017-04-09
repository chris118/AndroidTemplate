package com.wd.admin.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.wd.admin.base.util.WDTUtil;
import com.wd.admin.base.widget.WDLoadingView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/4/9.
 */

public abstract class WDBaseActivity <P extends WDBasePresenter, M extends WDBaseModel> extends AppCompatActivity implements WDBaseView{

    public P mPresenter;
    public M mModel;
    protected Context mContext;
    Unbinder binder;
    private WDLoadingView mLoadingView;


    public abstract int getLayoutId();
    public abstract void initView(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        binder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = WDTUtil.getT(this, 0);
        mModel = WDTUtil.getT(this, 1);
        if (this instanceof WDBaseView) {
            mPresenter.attachVM(mModel, this);
        }
        mLoadingView = new WDLoadingView(this, "加载中");
        this.initView(savedInstanceState);
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(getLayoutId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binder != null) {
            binder.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachVM();
        }
    }


    @Override
    public void showLoading() {
        mLoadingView.show();
    }

    @Override
    public void dismissLoading() {
        mLoadingView.dismiss();
    }

    @Override
    public void error(Throwable e) {
        //Snackbar.make(getWindow().getDecorView(), e.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}
