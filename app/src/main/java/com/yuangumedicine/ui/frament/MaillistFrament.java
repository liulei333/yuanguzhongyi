package com.yuangumedicine.ui.frament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuangumedicine.cn.R;
import com.yuangumedicine.ui.FriendsListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by starwrap on 2017/4/12.
 */

public class MaillistFrament extends Fragment {
    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.maillist_newfri)
    TextView maillistNewfri;
    @BindView(R.id.maillist_groupchat)
    TextView maillistGroupchat;
    @BindView(R.id.maillist_freeconsultation)
    TextView maillistFreeconsultation;
    @BindView(R.id.maillist_difficulthelp)
    TextView maillistDifficulthelp;
    @BindView(R.id.maillist_registernum)
    TextView maillistRegisternum;
    @BindView(R.id.maillist_familydoctor)
    TextView maillistFamilydoctor;
    @BindView(R.id.maillist_doctorfriends)
    TextView maillistDoctorfriends;
    Unbinder unbinder;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(R.layout.maillist_fragment, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.maillist_newfri, R.id.maillist_groupchat, R.id.maillist_freeconsultation, R.id.maillist_difficulthelp, R.id.maillist_registernum, R.id.maillist_familydoctor, R.id.maillist_doctorfriends})
    public void onViewClicked(View view) {
        Intent intent = new Intent(getActivity(), FriendsListActivity.class);
        switch (view.getId()) {
            case R.id.maillist_newfri:
                intent.putExtra("title","新朋友");
                break;
            case R.id.maillist_groupchat:
                intent.putExtra("title","群聊");
                break;
            case R.id.maillist_freeconsultation:
                intent.putExtra("title","免费咨询");
                break;
            case R.id.maillist_difficulthelp:
                intent.putExtra("title","疑难求助");
                break;
            case R.id.maillist_registernum:
                intent.putExtra("title","预约挂号");
                break;
            case R.id.maillist_familydoctor:
                intent.putExtra("title","家庭医生");
                break;
            case R.id.maillist_doctorfriends:
                intent.putExtra("title","医生好友");
                break;
        }
        startActivity(intent);
    }
}
