package com.ghj.jeonjutour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.ghj.jeonjutour.JJApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity implements View.OnClickListener {

    // 뒤로가기
    OnBackPressedCallback mBackCallBack = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            onBackPressed();
        }
    };

    public void onBackPressed() {
        finish();
    }

    // 액티비티 요청
    private int mReqCodeActivity = 0;
    private ActivityResultLauncher<Intent> mActivityLauncher =  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            onRequestActivityResult(mReqCodeActivity, o.getResultCode(), o.getData());
        }
    });

    public void onRequestActivityResult(int requestCode, int resultCode, Intent data) {}


    // 권한
    private int mReqCodePermission = 0;
    private ActivityResultLauncher<String[]> mPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
        @Override
        public void onActivityResult(Map<String, Boolean> result) {
            if(result.size() == 0) return;

            List<String> deniedPermission = new ArrayList<>();
            for (String key : result.keySet()) {
                if(!result.get(key)) {
                    deniedPermission.add(key);
                }
            }
            onRequestPermissionsResult(mReqCodePermission, deniedPermission);
        }
    });

    public void onRequestPermissionsResult(int requestCode, List<String> deniedPermission) {}


    // 뷰바인드
    public VB mBinding;

    public abstract VB newBinding();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JJApp.setContext(this);
        JJApp.setActivity(this);
        mBinding = newBinding();
        setContentView(mBinding.getRoot());

        // 뒤로가기
        getOnBackPressedDispatcher().addCallback(this, mBackCallBack);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JJApp.setContext(this);
        JJApp.setActivity(this);
    }

    @Override
    public void onClick(View v) { }
}
