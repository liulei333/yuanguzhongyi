package com.yuangumedicine.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.utils.TimeCount;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ForgetActivity extends Activity {


    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.titlebar_commint)
    TextView titlebarCommint;
    @BindView(R.id.titlebar_back)
    ImageButton titlebarBack;
    @BindView(R.id.titlebar_back_ll)
    LinearLayout titlebarBackLl;
    @BindView(R.id.titlebar_problem)
    ImageButton titlebarProblem;
    @BindView(R.id.titlebar_problem2)
    ImageButton titlebarProblem2;
    @BindView(R.id.title_bar)
    RelativeLayout titleBar;
    @BindView(R.id.forget_user)
    EditText forgetUser;
    @BindView(R.id.forget_code)
    EditText forgetCode;
    @BindView(R.id.forget_getcode)
    Button forgetGetcode;
    @BindView(R.id.forget_pwd)
    EditText forgetPwd;
    @BindView(R.id.forget_pwd2)
    EditText forgetPwd2;
    @BindView(R.id.forget_commint)
    Button forgetCommint;
    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_forget);
        ButterKnife.bind(this);
        titlebarTitle.setText("找回密码");
    }

    @OnClick({R.id.titlebar_back, R.id.forget_getcode, R.id.forget_commint})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_back:
                finish();
                break;
            case R.id.forget_getcode:
                time = new TimeCount(60000, 1000 , forgetGetcode);//构造CountDownTimer对象
			    time.start();
                break;
            case R.id.forget_commint:
                break;
        }
    }



}
