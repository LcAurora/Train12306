package com.example.train12306.Fragment.First;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.train12306.Fragment.First.indexsidebar.MainActivity;
import com.example.train12306.R;
import com.example.train12306.Londing.ResultActivity;


import java.util.Calendar;

public class HomeFragment extends Fragment{

    private  String x,y,z;
    private Button ChooseCity, ChooseCity2, Query;
    private ImageButton Exchange;
    private TextView Time;
    int year, month, dayOfMonth;
    int q, w, e;
    private Animation translateAnimation,translateAnimation2,animation;
    Calendar calendar = Calendar.getInstance();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        time();
        animations();
        onclicklistener();

    }

    private void onclicklistener() {
        ChooseCity.setOnClickListener(new MyButtonClickListener());
        ChooseCity2.setOnClickListener(new MyButtonClickListener());
        Exchange.setOnClickListener(new MyButtonClickListener());
        Query.setOnClickListener(new MyButtonClickListener());
        Time.setOnClickListener(new MyButtonClickListener());
    }

    private void init() {
        ChooseCity = getActivity().findViewById(R.id.choose);
        ChooseCity2 = getActivity().findViewById(R.id.choose2);
        Exchange = getActivity().findViewById(R.id.Exchange);;
        Query = getActivity().findViewById(R.id.Query);
        Time = getActivity().findViewById(R.id.Time);
    }

    private void animations() {
        translateAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_anim);
        translateAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_anim);
        Interpolator interpolator = new LinearInterpolator();
        translateAnimation.setInterpolator(interpolator);
        translateAnimation2.setInterpolator(interpolator);
    }

    private void time(){
        year = calendar.get(Calendar.YEAR);
        month =1 + calendar.get(Calendar.MONDAY);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        Time.setText(year+"-"+month+"-"+dayOfMonth);
    }


    private void code() {
        TranslateAnimation translateAnimation1 = new TranslateAnimation(0,610,0,0);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0,-610,0,0);
        translateAnimation1.setDuration(500);
        translateAnimation2.setDuration(500);
        translateAnimation1.setInterpolator(new DecelerateInterpolator());
        translateAnimation2.setInterpolator(new DecelerateInterpolator());
        ChooseCity.startAnimation(translateAnimation1);
        translateAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                ChooseCity.clearAnimation();
                ChooseCity.setText(x);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复
            }
        });
        ChooseCity2.startAnimation(translateAnimation2);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                ChooseCity2.clearAnimation();
                ChooseCity2.setText(y);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复
            }
        });

    }

    private void xml(){
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_anim);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始回调方法
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                Exchange.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复执行
            }
        });
        Exchange.startAnimation(animation);
    }



    private class MyButtonClickListener implements View.OnClickListener, Runnable{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()){
                case R.id.Time:
                    DatePickerDialog.OnDateSetListener listener1 = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int m_year, int m_month, int m_dayOfMonth) {
                            year = m_year;
                            month = m_month+1;
                            dayOfMonth = m_dayOfMonth;
                            Time.setText(year+"-"+month+"-"+dayOfMonth);

                            q = year;
                            w = month;
                            e = dayOfMonth;
                        }
                    };
                    DatePickerDialog dpDialog = new DatePickerDialog(getActivity(), listener1, year, month, dayOfMonth);
                    dpDialog.setIcon(R.drawable.ic_launcher_foreground);
                    dpDialog.setMessage("请选择日期");
                    dpDialog.show();
                    break;
                case R.id.choose:
                    intent.setClass(getActivity(), MainActivity.class);
                    startActivityForResult(intent,1);
                    break;
                case R.id.choose2:
                    intent.setClass(getActivity(), MainActivity.class);
                    startActivityForResult(intent,2);
                    break;
                case R.id.Exchange:

                    z = x;
                    x = y;
                    y = z;

                   code();
                   xml();
                   break;
                case R.id.Query:
                    int a = q;
                    int s = w;
                    int d = e;

                    intent.putExtra("years", a);
                    intent.putExtra("month", s);
                    intent.putExtra("day", d);

                    intent.putExtra("ACity", x);
                    intent.putExtra("BCity", y);

                    intent.setClass(getActivity(), ResultActivity.class);
                    startActivity(intent);
                    break;
                };
            }

        @Override
        public void run() {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2){
            if(requestCode ==1){
                String n = data.getStringExtra("ACity");
                x = n;
                ChooseCity.setText(n);
                ;
            }else if(requestCode == 2){
                String n = data.getStringExtra("BCity");
                y = n;
                ChooseCity2.setText(n);

            }

        }
    }

}


