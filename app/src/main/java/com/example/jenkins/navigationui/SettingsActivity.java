package com.example.jenkins.navigationui;

import android.os.Bundle;

public class SettingsActivity extends BaseNavActivity {


    @Override
    protected int resourceLayout() {
        return R.layout.activity_settings;
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle("Settings");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(resourceLayout(), frameLayout);
        setToolbarTitle();
    }




    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        navigationView.getMenu().getItem(2).setChecked(true);
    }

}
