package com.example.ratingapp.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.ratingapp.AccountFragment;
import com.example.ratingapp.MenuFragment;
import com.example.ratingapp.OrderFragment;
import com.example.ratingapp.R;
import com.example.ratingapp.SearchFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        // getItem is called to instantiate the fragment for the given page.

        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new MenuFragment();
                break;
            case 1:
                fragment = new SearchFragment();
                break;
            case 2:
                fragment = new OrderFragment();
                break;
            case 3:
                fragment = new AccountFragment();
                break;
        }

        return fragment;
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
            case 3:
                return context.getResources().getString(R.string.tab_4);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        // Show total pages.
        return 4;
    }
}