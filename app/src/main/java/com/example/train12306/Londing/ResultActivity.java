package com.example.train12306.Londing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.train12306.Adapter.ViewChooseAdapter;
import com.example.train12306.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends Activity {

    private TextView textView, textView2;
    private Button Gobtn, Backbtn;
    private int c,x;
    private int i = 1;;

    private ListView listView;
    private List<Map<String, Object>> listItems;
    private ViewChooseAdapter listaAdapter;

    private String[] Id = {"G108", "D29", "D5", "T297", "K291"};
    private String[] GoTime = {"04:47", "07:00", "07:05", "12:00", "16:55"};
    private String[] HereTime = {"14:46", "11:48", "11:55", "20:45", "01:30"};
    private String[] Frist = {"42", "22", "49", "30", "99"};
    private String[] Secend = {"50", "40", "37", "41", "99"};
    private String[] Threend = {"30", "20", "29", "55", "99"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.time1);
        textView2 = findViewById(R.id.textView2);
        Gobtn = findViewById(R.id.Gobtn);
        Backbtn = findViewById(R.id.Backbtn);

        listView = findViewById(R.id.resultlistview);
        listItems = getChooseItems();
        listaAdapter = new ViewChooseAdapter(this, listItems);
        listView.setAdapter(listaAdapter);



        Intent intent = getIntent();
        final int y = intent.getIntExtra("years",0);
        final int m = intent.getIntExtra("month",0);
        final int d = intent.getIntExtra("day",0);

        String A = intent.getStringExtra("ACity");
        String B = intent.getStringExtra("BCity");
        textView.setText((y+"-"+m+"-"+d));

        textView2.setText(A+"-->"+B);

        Gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = d + i;
                textView.setText((y+"-"+m+"-"+x));
                i++;
                c = x;
            }
        });
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = c - 1;
                textView.setText((y+"-"+m+"-"+c));
                x = c;
                i--;
            }
        });

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbal1);
        toolbar.inflateMenu(R.menu.toolbar_menu1);
        toolbar.setNavigationIcon(R.drawable.zjt);
        toolbar.setTitle("车票预定1/5");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private List<Map<String, Object>> getChooseItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < Id.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("Id", Id[i]);
            map.put("GoTime", GoTime[i]);
            map.put("HereTime", HereTime[i]);
            map.put("Frist", Frist[i]);
            map.put("Secend", Secend[i]);
            map.put("Threend", Threend[i]);
            listItems.add(map);
        }
        return listItems;
    }
}
