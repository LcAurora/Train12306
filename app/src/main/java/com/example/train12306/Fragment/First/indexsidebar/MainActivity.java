package com.example.train12306.Fragment.First.indexsidebar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.train12306.Fragment.First.HomeFragment;
import com.example.train12306.Fragment.First.indexsidebar.beans.RankLocation;
import com.example.train12306.R;
import com.example.train12306.Fragment.First.indexsidebar.adapter.SelectLocationAdapter;
import com.example.train12306.Fragment.First.indexsidebar.beans.MyLocation;
import com.example.train12306.Fragment.First.indexsidebar.utils.LocationDAO;
import com.example.train12306.Fragment.First.indexsidebar.views.SideBar;


public class MainActivity extends Activity {

    SelectLocationAdapter locationAdapter;


    private List<MyLocation> locationAll;
    private MyLocation location;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_main);

        copyDB();

        initView();

    }

    private void initView() {
        SideBar location_sideBar = findViewById(R.id.location_sideBar);
        final ListView location_listview = findViewById(R.id.location_listview);
        locationAll = LocationDAO.findAll(this);

        if(locationAll!=null){
            locationAdapter = new SelectLocationAdapter(locationAll, this);
            locationAdapter.setSideBar(location_sideBar);
            locationAdapter.setListView(location_listview);
            location_listview.setAdapter(locationAdapter);
        }

        location_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String S = locationAdapter.getCity(i);
                Intent intent = new Intent();
                intent.putExtra("ACity", S);
                intent.putExtra("BCity", S);
                intent.setClass(MainActivity.this, HomeFragment.class);
                setResult(2,intent);
                Log.d(TAG, "onItemClick: "+ S);
                finish();
            }
        });
    }

    /**
     * 把china_city_name.db这个数据库拷贝到data/data/《包名》/files/china_city_name.db
     */
    private void copyDB() {
        InputStream is = null;
        FileOutputStream fos = null;
        // 只要你拷贝了一次，我就不要你再拷贝了
        try {
            File file = new File(getFilesDir(), "china_city_name.db");
            if (file.exists() && file.length() > 0) {
                // 正常了，就不需要拷贝了
            } else {
                is = getAssets().open("china_city_name.db");

                fos = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (Exception e) {

            }
        }
    }
}