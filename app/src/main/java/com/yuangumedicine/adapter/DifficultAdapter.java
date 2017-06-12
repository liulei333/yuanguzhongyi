package com.yuangumedicine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuangumedicine.cn.R;
import com.yuangumedicine.ui.frament.DifficultFrament;

import java.util.ArrayList;

/**
 * Created by starwrap on 2017-05-31.
 */

public class DifficultAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<String> list;

    public DifficultAdapter(Context context, ArrayList<String> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_difficult, null);
            holder.username = (TextView) view.findViewById(R.id.item_difficult_username);
            holder.date = (TextView) view.findViewById(R.id.item_difficult_time);
            holder.title = (TextView) view.findViewById(R.id.item_difficult_title);
            holder.centent = (TextView) view.findViewById(R.id.item_difficult_centent);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
//
//        holder.date.setText();
//        holder.title.setText();
//        holder.centent.setText();


        return view;
    }

    public class ViewHolder {

        TextView username, title, centent, date;
    }


}
