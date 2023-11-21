package com.ghj.jeonjutour.activity.base;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    private Context mContext;
    public IItemListener Listener;

    public BaseRecyclerViewAdapter(Context context) {
        super();
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }


    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {
        holder.onBindViewHolder(position);
    }
}
