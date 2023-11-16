package com.ghj.jeonjutour.util;

import android.content.Context;
import android.content.Intent;

import com.ghj.jeonjutour.activity.MainActivity;

public class IntentUtil {

    // 메인으로 이동
    public static void MoveToMain(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
}
