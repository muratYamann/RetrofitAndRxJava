package com.murat.enuygun.ApiInterFace;

import com.murat.enuygun.pojo.Post;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IApi {

    @GET("posts")
    Observable<List<Post>> getPosts();
}
