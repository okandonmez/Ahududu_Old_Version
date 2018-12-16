package com.ahududu.ahududu;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    private static final String TAG = "MainPage";
    private SectionPageAdapter mSectionPageAdapter;
    Button btnDudula;

    ViewPager mViewPager;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        btnDudula = findViewById(R.id.btnDudula);

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        setTabLayout();

    }

    @SuppressLint("ResourceAsColor")
    private void setTabLayout(){
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setTabTextColors(ColorStateList.valueOf(R.color.colorPrimary));

        tabLayout.getTabAt(0).setIcon(R.drawable.anasayfaicon);
        tabLayout.getTabAt(0).setText("Anasayfa");

        tabLayout.getTabAt(1).setIcon(R.drawable.kafadengi);
        tabLayout.getTabAt(1).setText("Kafa Dengi");

        tabLayout.getTabAt(3).setIcon(R.drawable.notification);
        tabLayout.getTabAt(3).setText("Bildirimler");

        tabLayout.getTabAt(4).setIcon(R.drawable.avatar);
        tabLayout.getTabAt(4).setText("Profil");

        btnDudula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });

    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(),"TAB1");
        adapter.addFragment(new Tab2Fragment(),"TAB2");
        adapter.addFragment(new Tab3Fragment(),"TAB3");
        adapter.addFragment(new Tab4Fragment(),"TAB4");
        adapter.addFragment(new Tab5Fragment(), "TAB5");

        viewPager.setAdapter(adapter);
    }

}
