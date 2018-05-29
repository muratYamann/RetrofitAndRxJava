package com.murat.enuygun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bahamasoft.retrofitandrxjava.R;
import com.murat.enuygun.Adapter.PostAdapter;
import com.murat.enuygun.ApiInterFace.IApi;
import com.murat.enuygun.ApiInterFace.RetrofitClient;
import com.murat.enuygun.pojo.Post;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IApi myApi;
    RecyclerView recyclerPost;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        myApi = retrofit.create(IApi.class);


        recyclerPost = findViewById(R.id.rcycler_post);
        recyclerPost.setHasFixedSize(true);
        recyclerPost.setLayoutManager(new LinearLayoutManager(this));


        getData();

    }

    private void getData() {

        compositeDisposable.add(myApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {
                        displayPostData(posts);
                    }
                }));

    }

    private void displayPostData(List<Post> posts) {

        PostAdapter adapter = new PostAdapter(this, posts);
        recyclerPost.setAdapter(adapter);

    }

    @Override
    protected void onStop() {

        compositeDisposable.clear();

        super.onStop();

    }
}
