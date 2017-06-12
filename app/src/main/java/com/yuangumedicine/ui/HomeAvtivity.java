package com.yuangumedicine.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.yuangumedicine.adapter.HomeAdapter;
import com.yuangumedicine.cn.R;
import com.yuangumedicine.ui.frament.MyPatientsFrament;
import com.yuangumedicine.ui.frament.DifficultFrament;
import com.yuangumedicine.ui.frament.MaillistFrament;
import com.yuangumedicine.ui.frament.IndividuaFrament;
import com.yuangumedicine.view.MyViewPager;

import java.util.ArrayList;

import butterknife.ButterKnife;


/**
 * Created by starwrap on 2017/4/12.
 */

public class HomeAvtivity extends FragmentActivity implements View.OnClickListener {


    private MyViewPager home_pager;
    private LinearLayout home_message,home_woke,home_project,home_individual;
    private ImageView home_message_img,home_woke_img,home_project_img,home_individual_img;
    private TextView home_message_tv,home_woke_tv,home_project_tv,home_individual_tv;
    private ArrayList<Fragment> fragmentnts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);
        initView();
        onOpen();
        home_message_img.setImageResource(R.mipmap.zhanweitu_on);
        home_message_tv.setTextColor(Color.parseColor("#336699"));

        fragmentnts = new ArrayList<Fragment>();
        fragmentnts.add(new MyPatientsFrament());
        fragmentnts.add(new DifficultFrament());
        fragmentnts.add(new MaillistFrament());
        fragmentnts.add(new IndividuaFrament());
        home_pager.setNoScroll(true);
        home_pager.setAdapter(new HomeAdapter(getSupportFragmentManager(),fragmentnts));
    }

    private void initView() {
        home_pager= (MyViewPager) findViewById(R.id.home_pager);
        home_message= (LinearLayout) findViewById(R.id.home_message);
        home_woke= (LinearLayout) findViewById(R.id.home_woke);
        home_project= (LinearLayout) findViewById(R.id.home_project);
        home_individual= (LinearLayout) findViewById(R.id.home_individual);
        home_message_img= (ImageView) findViewById(R.id.home_message_img);
        home_woke_img= (ImageView) findViewById(R.id.home_woke_img);
        home_project_img= (ImageView) findViewById(R.id.home_project_img);
        home_individual_img= (ImageView) findViewById(R.id.home_individual_img);
        home_message_tv= (TextView) findViewById(R.id.home_message_tv);
        home_woke_tv= (TextView) findViewById(R.id.home_woke_tv);
        home_project_tv= (TextView) findViewById(R.id.home_project_tv);
        home_individual_tv= (TextView) findViewById(R.id.home_individual_tv);

    }

    private void onOpen() {
        home_message.setOnClickListener(this);
        home_woke.setOnClickListener(this);
        home_project.setOnClickListener(this);
        home_individual.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        setTextData();
        if(home_message.equals(view)){
            home_message_img.setImageResource(R.mipmap.zhanweitu_on);
            home_message_tv.setTextColor(Color.parseColor("#336699"));
            home_pager.setCurrentItem(0);
        }else if(home_woke.equals(view)){
            home_woke_img.setImageResource(R.mipmap.zhanweitu_on);
            home_woke_tv.setTextColor(Color.parseColor("#336699"));
            home_pager.setCurrentItem(1);
        }else if(home_project.equals(view)){
            home_project_img.setImageResource(R.mipmap.zhanweitu_on);
            home_project_tv.setTextColor(Color.parseColor("#336699"));
            home_pager.setCurrentItem(2);
        }else if(home_individual.equals(view)){
            home_individual_img.setImageResource(R.mipmap.zhanweitu_on);
            home_individual_tv.setTextColor(Color.parseColor("#336699"));
            home_pager.setCurrentItem(3);
        }
    }

    public void setTextData(){
        home_message_img.setImageResource(R.mipmap.zhanweitu);
        home_woke_img.setImageResource(R.mipmap.zhanweitu);
        home_project_img.setImageResource(R.mipmap.zhanweitu);
        home_individual_img.setImageResource(R.mipmap.zhanweitu);
        home_message_tv.setTextColor(Color.parseColor("#000000"));
        home_woke_tv.setTextColor(Color.parseColor("#000000"));
        home_project_tv.setTextColor(Color.parseColor("#000000"));
        home_individual_tv.setTextColor(Color.parseColor("#000000"));
    }
}
