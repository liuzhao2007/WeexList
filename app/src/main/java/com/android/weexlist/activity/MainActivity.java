package com.android.weexlist.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.android.weexlist.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_native).setOnClickListener(this);
        findViewById(R.id.bt_component).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_native:
                startActivity(new Intent(MainActivity.this,RecommendActivity.class));
                break;
            case R.id.bt_component:
                startActivity(new Intent(MainActivity.this,RecommendComponentActivity.class));
                break;
        }
    }
}
