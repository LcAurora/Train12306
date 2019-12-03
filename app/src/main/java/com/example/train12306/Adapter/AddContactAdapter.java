package com.example.train12306.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.train12306.R;

import java.util.List;
import java.util.Map;

public class AddContactAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> listItem;
    private LayoutInflater listContainer;

    public void updata(int i, ListView listView) {
        int visiblePosition = listView.getFirstVisiblePosition();
        //得到指定位置的视图，对listview的缓存机制不清楚的可以去了解下
        View view = listView.getChildAt(i - visiblePosition);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.content2 = (TextView) view.findViewById(R.id.content2);
        setData(holder,i);
    }

    private void setData(ViewHolder holder,int index){
        Map<String, Object>map = listItem.get(index);
        holder.content2.setText(map.get("data").toString());
    }


    public class ViewHolder{
        public TextView content1;
        public TextView content2;
    }

    public AddContactAdapter(Context context, List<Map<String, Object>>listItem){
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int selectId = i;
        ViewHolder holder = null;
        if (view == null){
            holder = new ViewHolder();
            view = listContainer.inflate(R.layout.add_contact_1, null);
            holder.content1 = view.findViewById(R.id.content1);
            holder.content2 = view.findViewById(R.id.content2);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.content1.setText((String)listItem.get(i).get("type"));
        holder.content2.setText((String)listItem.get(i).get("data"));
        return view;
    }
}
