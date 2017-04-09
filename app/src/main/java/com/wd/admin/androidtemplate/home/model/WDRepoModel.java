package com.wd.admin.androidtemplate.home.model;

import com.wd.admin.androidtemplate.home.model.bean.RepoEntity;
import com.wd.admin.androidtemplate.httpservice.WDHttpManager;
import com.wd.admin.androidtemplate.httpservice.serviceApi.WDGithubApi;
import com.wd.admin.base.mvp.WDBaseModel;
import com.wd.admin.base.util.WDRxUtil;

import java.util.List;

import rx.Observable;

/**
 * Created by admin on 2017/4/9.
 */

public class WDRepoModel implements WDBaseModel {

    public Observable<List<RepoEntity>> getRepos() {
        return WDHttpManager.getInstance().createGithubApi(WDGithubApi.class).getRepos("JakeWharton");
    }
}
