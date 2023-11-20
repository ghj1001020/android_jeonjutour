package com.ghj.jeonjutour.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ghj.jeonjutour.activity.viewmodel.ListViewModel;
import com.ghj.jeonjutour.databinding.ActivityListBinding;
import com.ghj.jeonjutour.define.DEFINE;

public class ListActivity extends BaseViewModelActivity<ListViewModel, ActivityListBinding> {

    @Override
    public ActivityListBinding newBinding() {
        return ActivityListBinding.inflate(LayoutInflater.from(this));
    }

    @Override
    public ListViewModel newViewModel() {
        return new ViewModelProvider(this).get(ListViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent().hasExtra("menu")) {
            getViewModel().MENU_TYPE = getIntent().getIntExtra("menu", 0);
        }
        getViewModel().dataList.observe(this, dataListObserber);
        requestList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getViewModel().dataList.removeObserver(dataListObserber);
    }

    public void requestList() {
        switch (getViewModel().MENU_TYPE) {
            case DEFINE.Menu.CULTURE_EXP:
                getViewModel().requestCultureExpList();
                break;
        }
    }

    Observer<Boolean> dataListObserber = aBoolean -> {

    };
}
