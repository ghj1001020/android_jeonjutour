package com.ghj.jeonjutour.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ghj.jeonjutour.activity.adapter.ListAdapter;
import com.ghj.jeonjutour.activity.base.BaseViewModelActivity;
import com.ghj.jeonjutour.activity.viewmodel.ListViewModel;
import com.ghj.jeonjutour.databinding.ActivityListBinding;
import com.ghj.jeonjutour.define.DEFINE;

public class ListActivity extends BaseViewModelActivity<ListViewModel, ActivityListBinding> {

    ListAdapter mListAdapter;


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

        getViewModel().MENU_TYPE = getIntent().getIntExtra("menu", 0);

        initLayout();

        // 옵저버등록
        getViewModel().isDataChange.observe(this, dataListObserber);
        // 데이터요청
        requestList();
    }

    public void initLayout() {
        mListAdapter = new ListAdapter(this, getViewModel());
        mBinding.list.setLayoutManager(new LinearLayoutManager(this));
        mBinding.list.setAdapter(mListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getViewModel().isDataChange.removeObserver(dataListObserber);
    }

    public void requestList() {
        switch (getViewModel().MENU_TYPE) {
            case DEFINE.Menu.CULTURE_EXP:
                getViewModel().requestCultureExpList();
                break;
        }
    }

    // 목록데이터 변경 옵저버
    Observer<Boolean> dataListObserber = aBoolean -> {
        mListAdapter.getItemCount();
        mListAdapter.notifyDataSetChanged();
    };
}
