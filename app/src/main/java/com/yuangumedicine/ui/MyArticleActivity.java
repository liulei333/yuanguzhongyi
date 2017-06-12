package com.yuangumedicine.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yuangumedicine.adapter.MyarticleAdapter;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.utils.Utils;
import com.yuangumedicine.view.SwipeRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by starwrap on 2017-06-01.
 */

public class MyArticleActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {

    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.myarticle_list)
    ListView myarticleList;
    @BindView(R.id.myarticle_swiperefr)
    SwipeRefreshLayout myarticleSwiperefr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_myarticle);
        ButterKnife.bind(this);
        titlebarTitle.setText("我的文章");
        setData();
    }

    private void setData() {
        View v=getLayoutInflater().inflate(R.layout.layout_seach,null);
        myarticleList.addHeaderView(v);
        myarticleSwiperefr.setOnRefreshListener(this);
        myarticleSwiperefr.setOnLoadListener(this);
        Utils.initRefresh(myarticleSwiperefr, this, this);
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        list.add("");
        list.add("");
        list.add("");
        list.add("");

        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        myarticleList.setAdapter(new MyarticleAdapter(this,list));

    }


    @OnItemClick(R.id.myarticle_list)
    void onItemClick(int position) {
//        Toast.makeText(this,position+"",Toast.LENGTH_SHORT).show();
    }
    @OnClick({R.id.titlebar_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_back:
                finish();
                break;

        }
    }

    @Override
    public void onLoad() {
        myarticleSwiperefr.setLoading(false);
    }

    @Override
    public void onRefresh() {
        myarticleSwiperefr.setRefreshing(false);
    }
}
