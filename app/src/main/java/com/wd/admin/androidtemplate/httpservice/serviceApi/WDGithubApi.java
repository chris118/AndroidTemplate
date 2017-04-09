package com.wd.admin.androidtemplate.httpservice.serviceApi;

import com.wd.admin.androidtemplate.home.model.bean.RepoEntity;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by admin on 2017/4/9.
 */

public interface WDGithubApi {
    @GET("users/{user}/repos")
    Observable<List<RepoEntity>> getRepos(@Path("user") String user);
}
