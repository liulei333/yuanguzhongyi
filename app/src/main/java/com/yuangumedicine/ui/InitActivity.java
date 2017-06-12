package com.yuangumedicine.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import com.yuangumedicine.application.App;
import com.yuangumedicine.cn.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InitActivity extends Activity {


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.ACCESS_COARSE_LOCATION,//位置信息
            Manifest.permission.READ_EXTERNAL_STORAGE,//读取文件
            Manifest.permission.WRITE_EXTERNAL_STORAGE,//写入
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        ButterKnife.bind(this);
        verifyStoragePermissions(InitActivity.this);

    }

    public void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions( activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
        }else{
            startActivity();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        startActivity();
    }

    /**
     * 跳转到登录页面
     */
    public  void startActivity() {

        new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {

                if(!App.getApp().getmSP().getUserToken().equals("")){
                    startActivity(new Intent(InitActivity.this,HomeAvtivity.class));
                }else{
                    startActivity(new Intent(InitActivity.this,LoginActivity.class));
                }
                int VERSION = Integer.parseInt(android.os.Build.VERSION.SDK);
                if (VERSION >= 5) {
                    InitActivity.this.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
                }
                finish();
            }
        }.start();

    }
}
