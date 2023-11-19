package com.ghj.jeonjutour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

import com.ghj.jeonjutour.R;
import com.ghj.jeonjutour.databinding.ActivityMainBinding;
import com.ghj.jeonjutour.define.DEFINE;

import java.util.Properties;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public ActivityMainBinding newBinding() {
        return ActivityMainBinding.inflate(LayoutInflater.from(this));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.btnMuseum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnMuseum) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("menu", DEFINE.Menu.CULTURE_EXP);
            startActivity(intent);
        }
    }
}
