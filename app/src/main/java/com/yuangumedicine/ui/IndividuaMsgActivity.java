package com.yuangumedicine.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yuangumedicine.cn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by starwrap on 2017-06-01.
 */

public class IndividuaMsgActivity extends Activity {

    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.titlebar_commint)
    TextView titlebarCommint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_indmsg);
        ButterKnife.bind(this);
        setData();
    }

    private void setData() {
        titlebarTitle.setText(R.string.indmsg_title);
        titlebarCommint.setVisibility(View.VISIBLE);
        titlebarCommint.setText(R.string.indmsg_bianji);
    }


    @OnClick({R.id.titlebar_commint, R.id.titlebar_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_commint:
                startActivity(new Intent(this,AllUserMsgActivity.class));
                break;
            case R.id.titlebar_back:
                finish();
                break;
        }
    }
}
