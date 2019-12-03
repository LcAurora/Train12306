package com.example.train12306.Fragment.Three;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.train12306.R;

import java.util.ArrayList;
import java.util.List;

public class MimeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout. mylinkman, container, false);
    }

    private ListView listView;
    private List<String> dataList;
    private ArrayAdapter<String> adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getActivity().findViewById(R.id.array_listview);
        dataList = new ArrayList<String>();

        dataList.add("我的联系人");
        dataList.add("我的账户");
        dataList.add("我的密码");

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.array_adapter_item, R.id.textView4, dataList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                switch (i){
                    case 0:
                        intent.setClass(getActivity(), LinkmanActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(getActivity(), MyAccount.class);
                        startActivity(intent);
                        break;
                    case 2:
                        break;
                }
            }
        });


//        inthend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(getActivity(), MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
//    View.OnClickListener MyOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent();
//            intent.setClass(getActivity(), LinkmanActivity.class);
//            startActivity(intent);
//        }
//    };
}
