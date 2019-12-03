package com.example.train12306.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.train12306.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

public class MyAdapter_inf extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;

    public void updata(int i, ListView listView) {
        int visiblePosition = listView.getFirstVisiblePosition();
        //得到指定位置的视图，对listview的缓存机制不清楚的可以去了解下
        View view = listView.getChildAt(i - visiblePosition);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.Id = view.findViewById(R.id.id);
        holder.Number = view.findViewById(R.id.number);
        holder.Name =  view.findViewById(R.id.name);
        setData(holder,i);
    }

    private void setData(ViewHolder holder, int i) {
        Map<String, Object>map = listItems.get(i);
        holder.Id.setText(map.get("Id").toString());
        holder.Number.setText(map.get("Number").toString());
        holder.Name.setText(map.get("Name").toString());
    }

    public class  ViewHolder{

        public TextView Name;
        public TextView Id;
        public TextView Number;
        public ImageView ImageView;
        //private TextView tet;
    }

    public MyAdapter_inf(Context context, List<Map<String, Object>>listItems){
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
    }



    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int selectId = i;
        ViewHolder holder = null;
        if(view == null){
            holder = new ViewHolder();
            view = listContainer.inflate(R.layout.link_layout,null);
            holder.Name = view.findViewById(R.id.name);
            holder.Id = view.findViewById(R.id.id);
            holder.Number = view.findViewById(R.id.number);
            holder.ImageView = view.findViewById(R.id.imageView4);
            view.setTag(holder);
        }else{

            holder = (ViewHolder) view.getTag();
        }
        holder.Name.setText((String)listItems.get(i).get("Name"));
        holder.Id.setText((String)listItems.get(i).get("Id"));
        holder.Number.setText((String)listItems.get(i).get("Number"));
        holder.ImageView.setImageResource((Integer) listItems.get(i).get("Image"));
        return view;
    }

}
