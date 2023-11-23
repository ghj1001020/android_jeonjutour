package com.ghj.jeonjutour.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.ghj.jeonjutour.JJApp;
import com.ghj.jeonjutour.R;
import com.ghj.jeonjutour.databinding.AppbarMainBinding;

public class AppBar extends RelativeLayout {

    private Context mContext;
    private AttributeSet mAttrs;
    private AppbarMainBinding mBinding;

    private String mTitle;


    public AppBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AppBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public AppBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, Context mContext, AttributeSet mAttrs) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        mContext = context;
        mAttrs = attrs;
        mBinding = AppbarMainBinding.inflate(LayoutInflater.from(mContext), this, true);

        TypedArray ta = null;
        try {
            ta = mContext.getTheme().obtainStyledAttributes(mAttrs, R.styleable.AppBar, 0, 0);
            mTitle = ta.getString(R.styleable.AppBar_title);
            initLayout();
        }
        finally {
            if(ta != null) ta.recycle();
        }
    }

    public void initLayout() {
        mBinding.AppBarTitle.setText(mTitle);
        mBinding.AppBarBack.setOnClickListener(v -> {
            JJApp.getActivity().onBackPressed();
        });
    }

    // 타이틀
    public void setTitle(String title) {
        mBinding.AppBarTitle.setText(title);
    }
}
