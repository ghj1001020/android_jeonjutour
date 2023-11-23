package com.ghj.jeonjutour.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ghj.jeonjutour.activity.base.BaseViewModelActivity;
import com.ghj.jeonjutour.activity.viewmodel.DetailViewModel;
import com.ghj.jeonjutour.databinding.ActivityDetailBinding;
import com.ghj.jeonjutour.dto.CultureExpDto;
import com.ghj.jeonjutour.dto.DetailData;

public class DetailActivity extends BaseViewModelActivity<DetailViewModel, ActivityDetailBinding> {

    @Override
    public ActivityDetailBinding newBinding() {
        return ActivityDetailBinding.inflate(LayoutInflater.from(this));
    }

    @Override
    public DetailViewModel newViewModel() {
        return new ViewModelProvider(this).get(DetailViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.appBar.setTitle("문화체험");

        // 데이터가져오기
        getViewModel().setCEItem( (CultureExpDto.CEItem) getIntent().getSerializableExtra("detail"));

        // 옵저버등록
        getViewModel().detailData.observe(this, detailDataObserber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getViewModel().detailData.removeObserver(detailDataObserber);
    }

    // 상세데이터 변경 옵저버
    Observer<DetailData> detailDataObserber = new Observer<DetailData>() {
        @Override
        public void onChanged(DetailData detailData) {
            mBinding.txtTitle.setText(detailData.title);
            mBinding.txtAddress.setText(detailData.address);
            mBinding.txtContents.setText(detailData.contents);
            mBinding.detailAddress.setText(detailData.fullAddress);
            mBinding.detailTel.setText(detailData.tel);
            mBinding.detailHomepage.setText(detailData.homepage);
        }
    };
}
