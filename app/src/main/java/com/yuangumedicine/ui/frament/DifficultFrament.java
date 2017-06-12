package com.yuangumedicine.ui.frament;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.uinfo.UserService;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.yuangumedicine.adapter.DifficultAdapter;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.ui.DifficultMsgActivity;
import com.yuangumedicine.ui.LoginActivity;
import com.yuangumedicine.utils.Utils;
import com.yuangumedicine.view.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;


/**
 * Created by starwrap on 2017/4/12.
 */

public class DifficultFrament extends Fragment implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {
    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.difficult_list)
    ListView difficultList;
    @BindView(R.id.swiperefr)
    SwipeRefreshLayout swiperefr;
    Unbinder unbinder;
    Unbinder unbinder1;
    private View rootView;
    private DifficultAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(R.layout.difficult_fragment, container, false);
            unbinder = ButterKnife.bind(this, rootView);
            initData();
        }


        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initData() {
        swiperefr.setOnRefreshListener(this);
        swiperefr.setOnLoadListener(this);
        Utils.initRefresh(swiperefr, this, this);
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        adapter = new DifficultAdapter(getActivity(), list);
        difficultList.setAdapter(adapter);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

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

        swiperefr.setRefreshing(false);

    }

    @OnItemClick(R.id.difficult_list)
    void onItemClick(int position) {
        startActivity(new Intent(getActivity(), DifficultMsgActivity.class));

    }


}
