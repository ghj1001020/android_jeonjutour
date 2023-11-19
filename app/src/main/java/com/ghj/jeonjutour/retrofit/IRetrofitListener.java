package com.ghj.jeonjutour.retrofit;

public interface IRetrofitListener<T> {

    void onRetrofitResponse(T response);
}
