package com.ghj.jeonjutour;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

public class JJApp extends Application {

    private static WeakReference<Context> mContext;
    private static WeakReference<Activity> mActivity;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Context getContext() {
        if(mContext == null) return null;
        return mContext.get();
    }

    public static void setContext(Context context) {
        mContext = new WeakReference<>(context);
    }

    public static Activity getActivity() {
        if(mActivity == null) return null;
        return mActivity.get();
    }

    public static void setActivity(Activity activity) {
        mActivity = new WeakReference<>(activity);
    }
}
