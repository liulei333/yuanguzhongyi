package com.yuangumedicine.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.netease.nim.uikit.NimUIKit;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.yuangumedicine.application.App;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.utils.MySharedPreference;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



/**
 * Created by starwrap on 2017/4/11.
 */

public class LoginActivity extends Activity {


    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.login_user)
    EditText loginUser;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.forget_pwd)
    TextView forgetPwd;
    @BindView(R.id.register)
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);

    }

    boolean isQuit = false;
    Timer timer = new Timer();
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                if (isQuit == false) {
                    isQuit = true;
                    Toast.makeText(getBaseContext(), "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
                    TimerTask task = null;
                    task = new TimerTask() {
                        public void run() {
                            isQuit = false;
                        }
                    };
                    timer.schedule(task, 2000);
                } else {
                    finish();
                    System.exit(0);
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @OnClick({R.id.login, R.id.forget_pwd, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                loginCheck();
//
                break;
            case R.id.forget_pwd:
                startActivity(new Intent(LoginActivity.this,ForgetActivity.class));
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }
    }


    private void loginCheck() {
        LoginInfo info = new LoginInfo(loginUser.getText().toString(), loginPwd.getText().toString()); // config...
                RequestCallback<LoginInfo> callback =
                new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo param) {
                        Toast.makeText(LoginActivity.this,"成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,HomeAvtivity.class));
                        NimUIKit.setAccount(param.getAccount());
                        MySharedPreference.instance(LoginActivity.this).setUserName(param.getAccount()+"");
                        MySharedPreference.instance(LoginActivity.this).setUserToken(param.getToken()+"");
                        finish();
                    }

                    @Override
                    public void onFailed(int code) {
                        Toast.makeText(LoginActivity.this,code+"",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onException(Throwable exception) {
                        Toast.makeText(LoginActivity.this,exception.getMessage()+"",Toast.LENGTH_SHORT).show();
                    }
                    // 可以在此保存LoginInfo到本地，下次启动APP做自动登录用
                };
        NIMClient.getService(AuthService.class).login(info).setCallback(callback);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
