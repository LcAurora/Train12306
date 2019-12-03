package com.example.train12306.Fragment.Three;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.example.train12306.Adapter.AddContactAdapter;
import com.example.train12306.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddContact extends Activity {

    private ListView listView;
    private AddContactAdapter listAdapter;
    private List<Map<String, Object>> listItem;
    private Button save;
    Map<String, Object> map;

    private String[] type = {"姓名", "证件类型", "证件号码", "乘客类型", "电话"};
    private static final String TAG = "AddContact";
    private String S, A, B, C, D;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        init();
        OnClickListener();
    }

    private void init() {
        listView = findViewById(R.id.listView);
        listItem = Array();
        listAdapter = new AddContactAdapter(this, listItem);
        listView.setAdapter(listAdapter);

        save = findViewById(R.id.save);
    }

    private List<Map<String, Object>> Array(){
        List<Map<String, Object>> listItem = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < type.length; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type",type[i]);
            listItem.add(map);
        }
        return listItem;

    }

    private void Dialog(){
        View v = getLayoutInflater().inflate(R.layout.put_inf, null);
        final EditText editText = v.findViewById(R.id.Edittext);
        new AlertDialog.Builder(AddContact.this)
                .setTitle("请输入姓名")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        S = editText.getText().toString();
                        map = listItem.get(0);
                        map.put("data",S);
                        listAdapter.updata(0, listView);
                        Log.d(TAG, "onClick: "+map);
                    }
                }).create().show();
    }

    private void DialogA(){
        final String[] types = {"身份证", "户口本", "其他"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddContact.this);
        builder.setTitle("请选择证件类型");
        builder.setCancelable(false);
        builder.setSingleChoiceItems(types, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                A = types[i];
                map = listItem.get(1);
                map.put("data",A);
                listAdapter.updata(1, listView);
                Log.d(TAG, "onClick: "+A);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                map = listItem.get(1);
                map.put("data"," ");
                listAdapter.updata(1, listView);
            }
        });
        builder.create().show();
    }

    private void DialogB(){
        View v = getLayoutInflater().inflate(R.layout.put_inf, null);
        final EditText editText = v.findViewById(R.id.Edittext);
        new AlertDialog.Builder(AddContact.this)
                .setTitle("请输入证件号码")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        B = editText.getText().toString();
                        map = listItem.get(2);
                        map.put("data",B);
                        listAdapter.updata(2, listView);
                    }
                }).create().show();
    }

    private void DialogC(){
        final String[]types = {"成人", "儿童","学生", "其他"};
        AlertDialog.Builder builder = new AlertDialog.Builder(AddContact.this);
        builder.setTitle("请选择乘客类型");
        builder.setCancelable(false);
        builder.setSingleChoiceItems(types, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                C = types[i];
                map = listItem.get(3);
                map.put("data",C);
                listAdapter.updata(3, listView);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                map = listItem.get(3);
                map.put("data"," ");
                listAdapter.updata(3, listView);
            }
        });
        builder.create().show();
    }

    private void DialogD(){
        View v = getLayoutInflater().inflate(R.layout.put_inf, null);
        final EditText editText = v.findViewById(R.id.Edittext);
        new AlertDialog.Builder(AddContact.this)
                .setTitle("请输入电话")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        D = editText.getText().toString();
                        map = listItem.get(4);
                        map.put("data", D);
                        listAdapter.updata(4, listView);
                    }
                }).create().show();
    }

    private void OnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Dialog();
                        break;
                    case 1:
                        DialogA();
                        break;
                    case 2:
                        DialogB();
                        break;
                    case 3:
                        DialogC();
                        break;
                    case 4:
                        DialogD();
                        break;
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(AddContact.this,LinkmanActivity.class);
                intent.putExtra("Name", S);
                intent.putExtra("Id", B);
                intent.putExtra("Number", D);
                Log.d(TAG, "onClick: "+S+B+D);
                setResult(2, intent);
                finish();
            }
        });
    }
}
