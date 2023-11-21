package com.ghj.jeonjutour.activity.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.ghj.jeonjutour.activity.base.BaseRecyclerViewAdapter;
import com.ghj.jeonjutour.activity.base.BaseRecyclerViewHolder;
import com.ghj.jeonjutour.activity.viewmodel.ListViewModel;
import com.ghj.jeonjutour.databinding.ItemListBinding;
import com.ghj.jeonjutour.dto.BaseListDto;
import com.ghj.jeonjutour.dto.CultureExpDto;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseRecyclerViewAdapter {

    private ListViewModel mViewModel;

    public ListAdapter(Context context, ListViewModel model) {
        super(context);
        mViewModel = model;
    }

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(ItemListBinding.inflate(LayoutInflater.from(getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        return mViewModel.getItemCount();
    }


    class ListViewHolder extends BaseRecyclerViewHolder<ItemListBinding> {

        public ListViewHolder(ItemListBinding binding) {
            super(binding);
        }

        @Override
        public void onBindViewHolder(int position) {
            BaseListDto data = mViewModel.getItem(position);
            mBinding.txtHead.setText(data.LIST_TITLE);
            mBinding.txtBody.setText(data.LIST_BODY);
            mBinding.txtBody.setVisibility(TextUtils.isEmpty(data.LIST_BODY) ? View.GONE : View.VISIBLE);
        }
    }
}
