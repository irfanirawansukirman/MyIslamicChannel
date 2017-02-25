package com.iriras.myislamicchannel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.iriras.myislamicchannel.utils.helper.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.btmnav_home)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @OnClick(R.id.btmnav_home)
    public void onBottomNavListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_channel:
                        Toast.makeText(HomeActivity.this, "1", Toast.LENGTH_SHORT).show();
                        mToolbarTitle.setText(R.string.txt_channel);
                        break;
                    case R.id.home_news:
                        Toast.makeText(HomeActivity.this, "2", Toast.LENGTH_SHORT).show();
                        mToolbarTitle.setText(R.string.txt_news);
                        break;
                    case R.id.home_event:
                        Toast.makeText(HomeActivity.this, "3", Toast.LENGTH_SHORT).show();
                        mToolbarTitle.setText(R.string.txt_events);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);

        setToolbarView();
    }

    public void setToolbarView(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //initialization
        mToolbarTitle.setText(R.string.txt_channel);
    }
}