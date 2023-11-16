package com.ghj.jeonjutour.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.ghj.jeonjutour.activity.viewmodel.ListViewModel;
import com.ghj.jeonjutour.databinding.ActivityListBinding;

public class ListActivity extends BaseViewModelActivity<ListViewModel, ActivityListBinding> {

    @Override
    public ActivityListBinding newBinding() {
        return ActivityListBinding.inflate(LayoutInflater.from(this));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
