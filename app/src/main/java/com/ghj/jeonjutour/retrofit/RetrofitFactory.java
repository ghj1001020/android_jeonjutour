package com.ghj.jeonjutour.retrofit;

import android.util.Log;

import com.ghj.jeonjutour.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitFactory {

    private static Retrofit mRetrofit;
    private static RetrofitService mRetrofitService;

    // 레트로핏 객체 생성
    public static RetrofitService create() {
        synchronized (RetrofitFactory.class) {
            if(mRetrofitService == null) {
                if(mRetrofit == null) {
                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();
                    TikXml tikXml = new TikXml.Builder().exceptionOnUnreadXml(false).build();
                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(BuildConfig.BASE_URL)
                            .addConverterFactory(TikXmlConverterFactory.create(tikXml))
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .build();
                }
                mRetrofitService = mRetrofit.create(RetrofitService.class);
            }
        }

        return mRetrofitService;
    }

    public static <T> void execute(Call<T> service, IRetrofitListener<T> listener) {
        service.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.isSuccessful()) {
                    if(listener != null) {
                        listener.onRetrofitResponse(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d("ADFADF", "ASDFADSF");
            }
        });
    }
}
