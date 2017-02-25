package com.iriras.myislamicchannel;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.iriras.myislamicchannel.base.BaseActivity;
import com.iriras.myislamicchannel.pages.channel.ChannelFragment;
import com.iriras.myislamicchannel.pages.event.EventFragment;
import com.iriras.myislamicchannel.pages.news.NewsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.drawer_home)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.btmnav_home)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);

        setToolbarView();

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_channel:
                        onFragmentReplace(ChannelFragment.newInstance());
                        break;
                    case R.id.home_news:
                        onFragmentReplace(NewsFragment.newInstance());
                        break;
                    case R.id.home_event:
                        onFragmentReplace(EventFragment.newInstance());
                        break;
                }
                return true;
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setToolbarView() {
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //initialization
        mToolbarTitle.setText(R.string.app_name);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frm_container, EventFragment.newInstance())
                .commit();
    }

    public void onOpenDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.END, true);
    }

    public void onFragmentReplace(Fragment mFragment) {
        if (mFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frm_container, mFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_top_menu, menu);
        MenuItem mMenuItem = menu.findItem(R.id.home_menu);
        mMenuItem.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOpenDrawer();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.home_menu:
//                onOpenDrawer();
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }
}