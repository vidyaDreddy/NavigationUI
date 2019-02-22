package com.example.jenkins.navigationui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public abstract class BaseNavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;
    public FrameLayout frameLayout;
    public Toolbar toolbar;
    public NavigationView navigationView;

    protected abstract int resourceLayout();

    protected abstract void setToolbarTitle();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frameLayout = findViewById(R.id.content_frame);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        //to prevent current item select over and over
        if (item.isChecked()) {
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }


        int id = item.getItemId();
        Intent intent;
        if (id == R.id.nav_gallery) {
            intent = new Intent(getApplicationContext(), DashBoardActivity.class);
            navigateToMenuItemClick(intent);
        } else if (id == R.id.nav_camera) {
            intent = new Intent(getApplicationContext(), CameraActivity.class);
            navigateToMenuItemClick(intent);
        } else if (id == R.id.nav_slideshow) {
            intent = new Intent(getApplicationContext(), SettingsActivity.class);
            navigateToMenuItemClick(intent);

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void navigateToMenuItemClick(Intent intent) {
        Bundle bundle = new Bundle();
        startActivity(intent);
    }
}
