package com.yuangumedicine.ui.frament;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.netease.nim.uikit.recent.RecentContactsCallback;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.msg.MsgServiceObserve;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.netease.nimlib.sdk.uinfo.UserService;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.utils.Utils;
import com.yuangumedicine.view.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by starwrap on 2017/4/12.
 */

public class MyPatientsFrament extends Fragment implements SwipeRefreshLayout.OnRefreshListener,SwipeRefreshLayout.OnLoadListener{


    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.swiperefr)
    SwipeRefreshLayout swiperefr;
    Unbinder unbinder;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(R.layout.fra_mypatient, container, false);
            unbinder = ButterKnife.bind(this, rootView);
            initData();
        }

        return rootView;
    }



    private void initData() {
        swiperefr.setOnRefreshListener(this);
        swiperefr.setOnLoadListener(this);
        Utils.initRefresh(swiperefr,this,this);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Observer<List<IMMessage>> incomingMessageObserver =
                new Observer<List<IMMessage>>() {
                    @Override
                    public void onEvent(List<IMMessage> messages) {
                        // 处理新收到的消息，为了上传处理方便，SDK 保证参数 messages 全部来自同一个聊天对象。
                        Toast.makeText(getActivity(),messages.get(0).getContent(),Toast.LENGTH_SHORT).show();
                    }
                };
        NIMClient.getService(MsgServiceObserve.class)
                .observeReceiveMessage(incomingMessageObserver, true);

    }

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


    private ArrayList<String> mListItems;

    private void initDatas() {
        // 初始化数据和数据源
        mListItems = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mListItems.add("mListItems" + i);
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoad() {
        swiperefr.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        getList();

    }
    public void  getList() {

    }



}
