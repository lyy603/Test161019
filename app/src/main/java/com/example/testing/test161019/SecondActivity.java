package com.example.testing.test161019;

import android.os.Bundle;

import me.yokeyword.fragmentation.SupportActivity;

public class SecondActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, HomeFragment.newInstance());
        }
    }
}
