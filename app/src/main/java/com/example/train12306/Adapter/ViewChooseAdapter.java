package com.example.train12306.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.train12306.R;

import java.util.List;
import java.util.Map;

public class ViewChooseAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;

    public class  ViewHolder{

        public TextView Id;
        public TextView GoTime,HereTime;
        private TextView Frist,Secend,Threend;
    }

    public ViewChooseAdapter(Context context, List<Map<String, Object>>listItems){
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
            view = listContainer.inflate(R.layout.trainchoose,null);

            holder.Id = view.findViewById(R.id.Id);
            holder.GoTime = view.findViewById(R.id.GoTime);
            holder.HereTime = view.findViewById(R.id.HereTime);
            holder.Frist = view.findViewById(R.id.First);
            holder.Secend = view.findViewById(R.id.Secend);
            holder.Threend = view.findViewById(R.id.Threend);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.Id.setText((String)listItems.get(i).get("Id"));
        holder.GoTime.setText("出发时间"+(String)listItems.get(i).get("GoTime"));
        holder.HereTime.setText("到达时间"+(String)listItems.get(i).get("HereTime"));
        holder.Frist.setText("商务座"+(String)listItems.get(i).get("Frist"));
        holder.Secend.setText("一等座"+(String)listItems.get(i).get("Secend"));
        holder.Threend.setText("无座"+(String)listItems.get(i).get("Threend"));
        return view;
    }
}
