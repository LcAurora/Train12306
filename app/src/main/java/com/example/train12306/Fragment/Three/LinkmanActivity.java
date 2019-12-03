package com.example.train12306.Fragment.Three;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import com.example.train12306.Adapter.MyAdapter_inf;
import com.example.train12306.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkmanActivity extends Activity {

    private ListView listView;
    private MyAdapter_inf listaAdapter;
    private List<Map<String, Object>> listItems;
    Map<String, Object> map;
    int i = 2;
    int index;

    private String[] Names = {"胡伟","李培峰","廉洁", "", "", "", "", ""};
    private String[] Numbers = {"0000001", "0000002", "0000003", "", "", "", "", ""};
    private String[] Ids = {"00000000001", "00000000002", "00000000003", "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linkman);

        listView = findViewById(R.id.listview);
        listItems = getItems();
        listaAdapter = new MyAdapter_inf(this, listItems);
        listView.setAdapter(listaAdapter);

        Toolbar toolbar = findViewById(R.id.toolbal);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setNavigationIcon(R.drawable.zjt);
        toolbar.setTitle("我的联系人");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            Intent intent = new Intent();
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.toolbal_search:
                        Toast.makeText(LinkmanActivity.this,"搜索",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.toolbar_notification:
                        Toast.makeText(LinkmanActivity.this,"点击了添加联系人",Toast.LENGTH_SHORT).show();
                        intent.setClass(LinkmanActivity.this, AddContact.class);
                        startActivityForResult(intent,1);

                        i++;
                        index = i;
                        return true;
                        default:
                            return false;
                }
            }
        });
    }

    private List<Map<String, Object>> getItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < Names.length; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("Name", Names[i]);
            map.put("Id", Ids[i]);
            map.put("Number", Numbers[i]);
            map.put("Image", R.drawable.forward_25);
            listItems.add(map);
        }
        return listItems;
    }

    private static final String TAG = "Linkman";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2){
            if(requestCode == 1){
                String name = data.getStringExtra("Name");
                String id = data.getStringExtra("Id");
                String number = data.getStringExtra("Number");
                map = listItems.get(index);
                map.put("Name", name);
                map.put("Id", id);
                map.put("Number", number);
                listaAdapter.updata(index, listView);
            }
        }
    }
}

