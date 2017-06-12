package com.yuangumedicine.ui.frament;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuangumedicine.cn.R;
import com.yuangumedicine.ui.HomeAvtivity;
import com.yuangumedicine.ui.IndividuaMsgActivity;
import com.yuangumedicine.ui.LoginActivity;
import com.yuangumedicine.ui.MyArticleActivity;
import com.yuangumedicine.ui.SettingActivity;
import com.yuangumedicine.view.MyImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by starwrap on 2017/4/12.
 */

public class IndividuaFrament extends Fragment {

    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.individua_usermsg_img)
    MyImageView individuaUsermsgImg;
    @BindView(R.id.individua_username)
    TextView individuaUsername;
    @BindView(R.id.individua_usermsg)
    LinearLayout individuaUsermsg;
    @BindView(R.id.individua_usersetting)
    TextView individuaUsersetting;
    @BindView(R.id.individua_myarticle)
    TextView individuaMyarticle;
    @BindView(R.id.individua_mycase)
    TextView individuaMycase;
    @BindView(R.id.individua_mymessage)
    TextView individuaMymessage;
    @BindView(R.id.individua_talentmarket)
    TextView individuaTalentmarket;
    private View rootView;
    Unbinder unbinder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(R.layout.individua_fragment, container, false);
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.individua_usermsg, R.id.individua_usersetting, R.id.individua_myarticle, R.id.individua_mycase, R.id.individua_mymessage, R.id.individua_talentmarket})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.individua_usermsg:
                startActivity(new Intent(getActivity(),IndividuaMsgActivity.class));
                break;
            case R.id.individua_usersetting:
                startActivity(new Intent(getActivity(),SettingActivity.class));
                break;
            case R.id.individua_myarticle:
                startActivity(new Intent(getActivity(),MyArticleActivity.class));
                break;
            case R.id.individua_mycase:
                break;
            case R.id.individua_mymessage:
                break;
            case R.id.individua_talentmarket:
                break;
        }
    }
}

