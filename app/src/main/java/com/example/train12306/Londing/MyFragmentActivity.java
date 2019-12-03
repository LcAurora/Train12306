package com.example.train12306.Londing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.example.train12306.Adapter.MyFragmentAdapter;
import com.example.train12306.R;

public class MyFragmentActivity extends FragmentActivity implements View.OnClickListener{

    public  static  final  int TAB_HOME = 0;
    public  static  final  int TAB_ORDER = 1;
    public  static  final  int TAB_MINE = 2;

    private ViewPager viewPager;
    private RadioButton homebtn, minebtn, orderbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
        initview();
    }

    private void initview() {
        viewPager = findViewById(R.id.fragment_viewpager);
        homebtn = findViewById(R.id.first);
        minebtn = findViewById(R.id.inthend);
        orderbtn = findViewById(R.id.secend);

        homebtn.setOnClickListener(this);
        minebtn.setOnClickListener(this);
        orderbtn.setOnClickListener(this);

        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case TAB_HOME:
                        homebtn.setChecked(true);
                        break;
                    case TAB_ORDER:
                        minebtn.setChecked(true);
                        break;
                    case TAB_MINE:
                        orderbtn.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.first:
                viewPager.setCurrentItem(TAB_HOME);
                break;
            case R.id.secend:
                viewPager.setCurrentItem(TAB_ORDER);
                break;
            case R.id.inthend:
                viewPager.setCurrentItem(TAB_MINE);
                break;

        }
    }
}
