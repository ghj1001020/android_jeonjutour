package com.ghj.jeonjutour.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.ghj.jeonjutour.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public ActivityMainBinding newBinding() {
        return ActivityMainBinding.inflate(LayoutInflater.from(this));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
