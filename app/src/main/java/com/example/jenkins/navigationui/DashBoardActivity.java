package com.example.jenkins.navigationui;

import android.os.Bundle;

public class DashBoardActivity extends BaseNavActivity {


    @Override
    protected int resourceLayout() {
        return R.layout.activity_dashboard;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(resourceLayout(), frameLayout);
        setToolbarTitle();

    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle("Dashboard");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        navigationView.getMenu().getItem(0).setChecked(true);
    }

}
