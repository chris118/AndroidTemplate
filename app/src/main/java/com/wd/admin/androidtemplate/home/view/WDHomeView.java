package com.wd.admin.androidtemplate.home.view;

import com.wd.admin.androidtemplate.home.model.bean.RepoEntity;
import com.wd.admin.base.mvp.WDBaseView;

import java.util.List;

/**
 * Created by admin on 2017/4/9.
 */

public interface WDHomeView extends WDBaseView {
    void updateRepoList(List<RepoEntity> repos);
}
