package com.murat.enuygun.ApiInterFace;

import com.murat.enuygun.Util.Const;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created Singleton clast Retrofit client
 */
public class RetrofitClient {

    private static  Retrofit ourInstance;

    public static Retrofit getInstance() {
        if (ourInstance == null)
            ourInstance =  new Retrofit.Builder()
                    .baseUrl(Const.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();


        return ourInstance;
    }

    private RetrofitClient() {
    }
}
