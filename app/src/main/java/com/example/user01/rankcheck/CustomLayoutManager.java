package com.example.user01.rankcheck;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

public class CustomLayoutManager extends LinearLayoutManager {

    CustomLayoutManager(Context context) {
        super(context);
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
