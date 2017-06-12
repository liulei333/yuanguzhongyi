package com.yuangumedicine.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.netease.nim.uikit.NimUIKit;
import com.netease.nim.uikit.session.activity.P2PMessageActivity;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.uinfo.UserService;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.yuangumedicine.adapter.MyFriendsListAdapter;
import com.yuangumedicine.adapter.MyarticleAdapter;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.utils.Utils;
import com.yuangumedicine.view.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by starwrap on 2017-06-05.
 */

public class FriendsListActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {

    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.myfriends_list)
    ListView myfriendsList;
    @BindView(R.id.myarticle_swiperefr)
    SwipeRefreshLayout myarticleSwiperefr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_friendslist);
        ButterKnife.bind(this);
        String title = getIntent().getStringExtra("title");
        titlebarTitle.setText(title);
        setData();
        if("新朋友".equals(title)){
            getList();
        }else{

        }


    }


    private void setData() {
        View v=getLayoutInflater().inflate(R.layout.layout_seach,null);
        myfriendsList.addHeaderView(v);
        myarticleSwiperefr.setOnRefreshListener(this);
        myarticleSwiperefr.setOnLoadListener(this);
        Utils.initRefresh(myarticleSwiperefr, this, this);
    }


    @OnItemClick(R.id.myfriends_list)
    void onItemClick(int position) {
        if(position != 0){
            NimUIKit.startP2PSession(FriendsListActivity.this, users.get(position-1).getAccount(),null);
        }else{

        }

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
    ArrayList<NimUserInfo> users;
    public void getList() {
        List<String> accounts = NIMClient.getService(FriendService.class).getFriendAccounts();
        users = (ArrayList<NimUserInfo>) NIMClient.getService(UserService.class).getUserInfoList(accounts);
        myarticleSwiperefr.setRefreshing(false);
        myfriendsList.setAdapter(new MyFriendsListAdapter(this,users));
    }
}
