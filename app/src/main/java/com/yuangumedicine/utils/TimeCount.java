package com.yuangumedicine.utils;

import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.yuangumedicine.cn.R;


public class TimeCount extends CountDownTimer {

	Button v = null;

	public TimeCount(long millisInFuture, long countDownInterval, Button v) {
		super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
		this.v = v;
	}
	@Override
	public void onFinish() {//计时完毕时触发
		v.setText("重新验证");
		v.setClickable(true);
		v.setBackgroundResource(R.drawable.btn_bg_click);
		v.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					v.setBackgroundResource(R.drawable.btn_bg);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					v.setBackgroundResource(R.drawable.btn_bg_click);
				}
				return false;
			}
		});
	}
	@Override
	public void onTick(long millisUntilFinished){//计时过程显示
		v.setClickable(false);
		v.setText(millisUntilFinished / 1000+"秒");

		v.setOnTouchListener(null);
		v.setBackgroundResource(R.drawable.btn_gray_yuan);

	}

}
