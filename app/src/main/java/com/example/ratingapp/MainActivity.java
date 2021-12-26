package com.example.ratingapp;

import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.ratingapp.databinding.ActivityMainBinding;
import com.example.ratingapp.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        // Initializing page
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        // Initializing tab
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setIcon(R.drawable.ic_home);
        tabs.getTabAt(1).setIcon(R.drawable.ic_search);
        tabs.getTabAt(2).setIcon(R.drawable.ic_order);
        tabs.getTabAt(3).setIcon(R.drawable.ic_account);

        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        tabs.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
        tabs.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
        tabs.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_IN);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}