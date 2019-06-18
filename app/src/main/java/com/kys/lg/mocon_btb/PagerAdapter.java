package com.kys.lg.mocon_btb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){

            case 0: return new LibraryFragment();
            case 1: return new FragmentSearchScreen();
            case 2: return  new MyLibraryFragment();
            case 3: return new FragmentProfile();

            default: return null;
    }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
