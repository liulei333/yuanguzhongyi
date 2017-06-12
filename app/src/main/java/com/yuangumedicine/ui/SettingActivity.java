package com.yuangumedicine.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.auth.AuthService;
import com.yuangumedicine.application.App;
import com.yuangumedicine.cn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by starwrap on 2017-06-01.
 */

public class SettingActivity extends Activity {
    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.titlebar_back)
    ImageButton titlebarBack;
    @BindView(R.id.setting_exit)
    TextView settingExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_setting);
        ButterKnife.bind(this);
        setData();
    }

    private void setData() {
        titlebarTitle.setText(R.string.setting_set);
    }

    @OnClick({R.id.titlebar_back, R.id.setting_exit, R.id.setting_aboutme,R.id.setting_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_back:
                finish();
                break;
            case R.id.setting_exit:
                NIMClient.getService(AuthService.class).logout();
                App.getApp().getmSP().setUserToken("");
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                break;
            case R.id.setting_aboutme:

                break;
            case R.id.setting_feedback:
                startActivity(new Intent(SettingActivity.this, FeedbackActivity.class));
                break;

        }
    }

}
