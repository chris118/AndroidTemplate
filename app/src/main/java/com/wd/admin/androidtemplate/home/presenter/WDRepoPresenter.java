package com.wd.admin.androidtemplate.home.presenter;

import com.wd.admin.androidtemplate.home.model.bean.RepoEntity;
import com.wd.admin.androidtemplate.home.model.WDRepoModel;
import com.wd.admin.androidtemplate.home.view.WDHomeView;
import com.wd.admin.base.mvp.WDBasePresenter;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/4/9.
 */

public  class WDRepoPresenter extends WDBasePresenter<WDRepoModel, WDHomeView> {
    public void getRepos() {
        mCompositeSubscription.add(mModel.getRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        mView.dismissLoading();
                    }
                })
                .subscribe(new Observer<List<RepoEntity>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<RepoEntity> repoEntities) {
                        mView.updateRepoList(repoEntities);
                    }
                })
        );
    }
}
