package com.yuangumedicine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.view.MyImageView;

import java.util.ArrayList;

/**
 * Created by starwrap on 2017-06-05.
 */

public class MyFriendsListAdapter  extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<NimUserInfo> list;

    public MyFriendsListAdapter(Context context, ArrayList<NimUserInfo> list) {
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
            view = inflater.inflate(R.layout.item_myfriends, null);
            holder.usericon = (MyImageView) view.findViewById(R.id.item_myfiend_userimg);
            holder.username = (TextView) view.findViewById(R.id.item_myfiend_username);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
//
//        holder.date.setText();
//        holder.centent.setText("标题"+i);
        holder.username.setText(list.get(i).getName());


        return view;
    }

    public class ViewHolder {
        MyImageView usericon;
        TextView username, title, centent, date;
    }


}
