package com.example.zassmin.fragmentexercise.activities;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.zassmin.fragmentexercise.R;
import com.example.zassmin.fragmentexercise.fragments.ColorDialogFragment;
import com.example.zassmin.fragmentexercise.fragments.ColorFragment;

public class MainActivity extends AppCompatActivity implements ColorFragment.OnButtonClickListener {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView nvDrawer;
    private ColorFragment colorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set tool bar to replace actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = setupDrawerToggle();

        // set up drawer stuff
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        if (savedInstanceState == null) {
            colorFragment = (ColorFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fColorFragment);
            colorFragment.setColor("#f68b1f");
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView nvDrawer) {
        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                selectDrawerItem(menuItem);
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_one:
                colorFragment.setColor("#65416c");
                break;
            case R.id.nav_two:
                colorFragment.setColor("#009688");
                break;
            case R.id.nav_three:
                colorFragment.setColor("#75cbc3");
                break;
            default:
                colorFragment.setColor("#f68b1f");
        }

        // highlight selected item and close the door
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }

    @Override
    public void onButtonClickListener(String hexColor, int colorInt) {
        FragmentManager fm = getSupportFragmentManager();
        String colorIntStr = String.valueOf(colorInt);
        ColorDialogFragment colorDialog = ColorDialogFragment.newInstance(hexColor, colorIntStr);
        colorDialog.show(fm, "fragment_color_dialog");
    }
}
