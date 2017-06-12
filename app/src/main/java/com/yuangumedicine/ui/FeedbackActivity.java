package com.yuangumedicine.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yuangumedicine.cn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by starwrap on 2017-06-05.
 */

public class FeedbackActivity extends Activity {

    @BindView(R.id.titlebar_title)
    TextView titlebarTitle;
    @BindView(R.id.feedback_et)
    EditText feedbackEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_feedback);
        ButterKnife.bind(this);
        titlebarTitle.setText("反馈意见");
    }

    @OnClick({R.id.titlebar_back, R.id.feedback_commint})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_back:
                finish();
                break;
            case R.id.feedback_commint:

                break;
        }
    }
}
