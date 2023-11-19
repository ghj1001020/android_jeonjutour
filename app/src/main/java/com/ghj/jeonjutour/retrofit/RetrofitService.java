package com.ghj.jeonjutour.retrofit;

import com.ghj.jeonjutour.BuildConfig;
import com.ghj.jeonjutour.dto.CultureExpDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    // 문화체험
    @GET(BuildConfig.CURTURE_EXP_LIST)
    Call<CultureExpDto> getCultureExpList(@Query("authApiKey") String authKey, @Query("dataValue") String search, @Query("startPage") String pageStart, @Query("pageSize") String pageSize);

    // 문화공간
    @GET(BuildConfig.CURTURE_SPC)
    Call<CultureExpDto> getCultureSpc(@Query("authApiKey") String authKey, @Query("dataValue") String search, @Query("startPage") String pageStart, @Query("pageSize") String pageSize);

}
