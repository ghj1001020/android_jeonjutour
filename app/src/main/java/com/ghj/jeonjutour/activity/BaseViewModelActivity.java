package com.ghj.jeonjutour.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;

public abstract class BaseViewModelActivity<VM extends ViewModel, VB extends ViewBinding> extends BaseActivity<VB>{
    // 뷰모델
    public VM mViewModel;

    public abstract VM newViewModel();

    public VM getViewModel() {
        if(mViewModel == null) {
            mViewModel = newViewModel();
        }
        return mViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newViewModel();
    }
}
