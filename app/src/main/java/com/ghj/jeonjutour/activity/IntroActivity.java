package com.ghj.jeonjutour.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.ghj.jeonjutour.activity.base.BaseActivity;
import com.ghj.jeonjutour.databinding.ActivityIntroBinding;
import com.ghj.jeonjutour.util.IntentUtil;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends BaseActivity<ActivityIntroBinding> {

    @Override
    public ActivityIntroBinding newBinding() {
        return ActivityIntroBinding.inflate(LayoutInflater.from(this));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        moveToMain();
    }

    public void moveToMain() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                IntentUtil.MoveToMain(IntroActivity.this);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 700);
    }
}
