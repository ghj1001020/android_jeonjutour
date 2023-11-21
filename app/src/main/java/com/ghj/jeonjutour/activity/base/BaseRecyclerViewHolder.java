package com.ghj.jeonjutour.activity.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public abstract class BaseRecyclerViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {

    public VB mBinding;

    public BaseRecyclerViewHolder(VB binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public abstract void onBindViewHolder(int position);
}
