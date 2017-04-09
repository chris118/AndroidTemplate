package com.wd.admin.androidtemplate.home.activity;

import android.os.Bundle;

import com.wd.admin.androidtemplate.R;
import com.wd.admin.androidtemplate.home.model.bean.RepoEntity;
import com.wd.admin.androidtemplate.home.model.WDRepoModel;
import com.wd.admin.androidtemplate.home.presenter.WDRepoPresenter;
import com.wd.admin.androidtemplate.home.view.WDHomeView;
import com.wd.admin.base.mvp.WDBaseActivity;

import java.util.List;

public class MainActivity extends WDBaseActivity<WDRepoPresenter, WDRepoModel> implements WDHomeView {

    @Override
    public int getLayoutId() {
        return R.id.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mPresenter.getRepos();
    }

    @Override
    public void updateRepoList(List<RepoEntity> repos) {

    }
}
