package com.yuangumedicine.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.friend.constant.VerifyType;
import com.netease.nimlib.sdk.friend.model.AddFriendData;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.view.MyImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by starwrap on 2017-06-01.
 */

public class DifficultMsgActivity extends Activity {

    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.titlebar_commint)
    TextView titlebarCommint;
    @BindView(R.id.difficult_usermsg_img)
    MyImageView difficultUsermsgImg;
    @BindView(R.id.difficult_username)
    TextView difficultUsername;
    @BindView(R.id.difficult_useraddress)
    TextView difficultUseraddress;
    @BindView(R.id.difficult_time)
    TextView difficultTime;
    @BindView(R.id.difficult_content)
    TextView difficultContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_difficultmsg);
        ButterKnife.bind(this);
        titlebarCommint.setText("加为好友");
        titlebarCommint.setVisibility(View.VISIBLE);
        titlebarTitle.setText("");
    }

    @OnClick({R.id.titlebar_commint, R.id.titlebar_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_commint:
                addFriend();
                break;
            case R.id.titlebar_back:
                finish();
                break;
        }
    }

    private void addFriend() {
        final VerifyType verifyType = VerifyType.DIRECT_ADD; // 发起好友验证请求
        String msg = "好友请求附言";
        NIMClient.getService(FriendService.class).addFriend(new AddFriendData("111", verifyType, msg))
                .setCallback(new RequestCallback<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(DifficultMsgActivity.this,"发送成功",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed(int i) {

                    }

                    @Override
                    public void onException(Throwable throwable) {
                        Toast.makeText(DifficultMsgActivity.this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
