package com.yuangumedicine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuangumedicine.cn.R;
import com.yuangumedicine.view.MyImageView;

import java.util.ArrayList;

/**
 * Created by starwrap on 2017-06-01.
 */

public class MyarticleAdapter  extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<String> list;

    public MyarticleAdapter(Context context, ArrayList<String> list) {
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
            view = inflater.inflate(R.layout.item_myarticle, null);
            holder.usericon = (MyImageView) view.findViewById(R.id.item_myarticle_usermsg_img);
            holder.username = (TextView) view.findViewById(R.id.item_myarticle_username);
            holder.date = (TextView) view.findViewById(R.id.item_myarticle_time);
            holder.centent = (TextView) view.findViewById(R.id.item_myarticle_content);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
//
//        holder.date.setText();
        holder.centent.setText("标题"+i);
//        holder.centent.setText();


        return view;
    }

    public class ViewHolder {
        MyImageView usericon;
        TextView username, title, centent, date;
    }


}
