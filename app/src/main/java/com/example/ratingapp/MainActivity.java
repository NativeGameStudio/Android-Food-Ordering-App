package com.example.ratingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.ratingapp.fragment.MenuFragment;
import com.example.ratingapp.fragment.OrderFragment;
import com.example.ratingapp.fragment.UserFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/** The main activity only in charge of manage page,
 *  and other system wide and hardware requirement.
 *  Please do details setting in each page's fragment
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_main);

        this.initView();

    }

    private void initView(){

        // Initializing cart button
        FloatingActionButton floatingActionButton = findViewById(R.id.btn_cart);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        // Initializing page
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        // Initializing tab
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        // Initializing icon
        tabs.getTabAt(0).setIcon(R.drawable.ic_home);
        tabs.getTabAt(1).setIcon(R.drawable.ic_order);
        tabs.getTabAt(2).setIcon(R.drawable.ic_user);

        // Initializing color
        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        tabs.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
        tabs.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_IN);

        // Change color if selected
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                // Turn write if selected
                tab.getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                // Turn gray if unselected
                tab.getIcon().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /** Adapter to manage page and tab
     */
    private static class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final Context context;
        private final ArrayList<Fragment>fragments;

        public SectionsPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            this.context = context;

            // Add page
            this.fragments = new ArrayList<>();
            fragments.add(new MenuFragment());
            fragments.add(new OrderFragment());
            fragments.add(new UserFragment());
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            // GetItem is called to instantiate the fragment for the given page.
            return fragments.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            // Return tab name
            switch (position){
                case 0:
                    return context.getResources().getString(R.string.tab_1);
                case 1:
                    return context.getResources().getString(R.string.tab_2);
                case 2:
                    return context.getResources().getString(R.string.tab_3);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            // Show total pages.
            return fragments.size();
        }
    }
}