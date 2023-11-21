package com.ghj.jeonjutour.activity.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ghj.jeonjutour.BuildConfig;
import com.ghj.jeonjutour.dto.BaseListDto;
import com.ghj.jeonjutour.dto.CultureExpDto;
import com.ghj.jeonjutour.retrofit.IRetrofitListener;
import com.ghj.jeonjutour.retrofit.RetrofitFactory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ListViewModel extends ViewModel {

    // 메뉴타입
    public int MENU_TYPE;
    // 데이터
    public List<CultureExpDto.CEItem> cultureExpItems = new ArrayList<>();

    // 목록데이터 변경여부
    public MutableLiveData<Boolean> isDataChange = new MutableLiveData<>();

    // 문화체험
    public void requestCultureExpList() {
        Call<CultureExpDto> api = RetrofitFactory.create().getCultureExpList(BuildConfig.DATA_KEY, "", "1", "20");
        RetrofitFactory.execute(api, new IRetrofitListener<CultureExpDto>() {
            @Override
            public void onRetrofitResponse(CultureExpDto response) {
                cultureExpItems = response.body.data.item;
                for(CultureExpDto.CEItem item : cultureExpItems) {
                    item.LIST_TITLE = item.dataTitle;
                    item.LIST_BODY = item.addr;
                    item.LIST_TEL = item.tel;
                }
                isDataChange.setValue(true);
            }
        });
    }

    // 리스트 갯수
    public int getItemCount() {
        return cultureExpItems.size();
    }

    // 리스트아이템
    public BaseListDto getItem(int position) {
        return cultureExpItems.get(position);
    }
}
