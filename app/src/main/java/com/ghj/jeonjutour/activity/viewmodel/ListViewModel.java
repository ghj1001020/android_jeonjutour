package com.ghj.jeonjutour.activity.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ghj.jeonjutour.BuildConfig;
import com.ghj.jeonjutour.dto.CultureExpDto;
import com.ghj.jeonjutour.retrofit.IRetrofitListener;
import com.ghj.jeonjutour.retrofit.RetrofitFactory;

import retrofit2.Call;

public class ListViewModel extends ViewModel {

    // 목록데이터 변경여부
    public MutableLiveData<Boolean> dataList = new MutableLiveData<>();

    // 메뉴타입
    public int MENU_TYPE;

    // 문화체험
    public void requestCultureExpList() {
        Call<CultureExpDto> api = RetrofitFactory.create().getCultureExpList(BuildConfig.DATA_KEY, "", "1", "20");
        RetrofitFactory.execute(api, new IRetrofitListener<CultureExpDto>() {
            @Override
            public void onRetrofitResponse(CultureExpDto response) {

                Log.d("aaaa", response.body.pageIndex + " , " + response.body.pageSize);
            }
        });
    }
}
