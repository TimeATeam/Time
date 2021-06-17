package com.example.time;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;



public class TitleLayout2 extends LinearLayout {


    public TitleLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title2, this);
        Button btn_back = (Button) findViewById(R.id.title_back);
        btn_back.setOnClickListener(v -> {
            ((Activity)getContext()).finish();
        });
    }

}