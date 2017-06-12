package com.yuangumedicine.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.yuangumedicine.cn.R;
import com.yuangumedicine.utils.TimeCount;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by starwrap on 2017-05-26.
 */

public class RegisterActivity extends Activity {

    @BindView(R.id.register_username)
    EditText registerUsername;
    @BindView(R.id.register_user)
    EditText registerUser;
    @BindView(R.id.register_verification_code)
    EditText registerVerificationCode;
    @BindView(R.id.register_getcode)
    Button registerGetcode;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_pwd2)
    EditText registerPwd2;
    @BindView(R.id.register_commint)
    Button registerCommint;
    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_register);
        ButterKnife.bind(this);
        setData();
    }

    private void setData() {
        titlebarTitle.setText("注册");
    }


    @OnClick({R.id.register_getcode, R.id.register_commint})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.register_getcode:
                time = new TimeCount(60000, 1000, registerGetcode);//构造CountDownTimer对象
                time.start();
                break;
            case R.id.register_commint:

                break;
        }
    }

    @OnClick(R.id.titlebar_back)
    public void onViewClicked() {
        finish();
    }
}
