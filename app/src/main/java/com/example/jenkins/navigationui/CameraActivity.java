package com.example.jenkins.navigationui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CameraActivity extends BaseNavActivity {


    @Override
    protected int resourceLayout() {
        return R.layout.activity_camera;
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle("Camera");
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
        navigationView.getMenu().getItem(1).setChecked(true);
    }

}
