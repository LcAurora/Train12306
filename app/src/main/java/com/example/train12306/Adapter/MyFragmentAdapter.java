package com.example.train12306.Adapter;
;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.train12306.Fragment.First.HomeFragment;
import com.example.train12306.Fragment.Three.MimeFragment;
import com.example.train12306.Fragment.Secend.MineFragment;
import com.example.train12306.Londing.MyFragmentActivity;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    public final static  int TAB_COUNT = 3;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case MyFragmentActivity.TAB_HOME:
                fragment = new HomeFragment();
                break;
            case MyFragmentActivity.TAB_ORDER:
                fragment = new MineFragment();
                break;
            case MyFragmentActivity.TAB_MINE:
                fragment= new MimeFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}

