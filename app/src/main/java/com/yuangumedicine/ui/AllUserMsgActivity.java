package com.yuangumedicine.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.yalantis.ucrop.entity.LocalMedia;
import com.yuangumedicine.cn.BuildConfig;
import com.yuangumedicine.cn.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.widget.WheelView;

/**
 * Created by starwrap on 2017-05-27.
 */

public class AllUserMsgActivity extends Activity {


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
    @BindView(R.id.allusermsg_name)
    EditText allusermsgName;
    @BindView(R.id.allusermsg_sex_et)
    TextView allusermsgSexEt;
    @BindView(R.id.allusermsg_sex)
    LinearLayout allusermsgSex;
    @BindView(R.id.allusermsg_birthdate_tv)
    TextView allusermsgBirthdateTv;
    @BindView(R.id.allusermsg_birthdate)
    LinearLayout allusermsgBirthdate;
    @BindView(R.id.allusermsg_id)
    EditText allusermsgId;
    @BindView(R.id.allusermsg_zhicheng)
    EditText allusermsgZhicheng;
    @BindView(R.id.allueermsg_practice_qualification)
    ImageView allueermsgPracticeQualification;
    @BindView(R.id.allueermsg_institution)
    EditText allueermsgInstitution;
    @BindView(R.id.allueermsg_practice_license)
    ImageView allueermsgPracticeLicense;

    @BindView(R.id.allueermsg_address)
    EditText allueermsgAddress;
    @BindView(R.id.allueermsg_skilful)
    EditText allueermsgSkilful;
    @BindView(R.id.allueermsg_introduction)
    EditText allueermsgIntroduction;
    @BindView(R.id.allueermsg_specialstatus)
    EditText allueermsgSpecialstatus;
    @BindView(R.id.ceshi)
    ImageView ceshi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_allusermsg);
        ButterKnife.bind(this);
        titlebarTitle.setText("完善信息");
        titlebarCommint.setVisibility(View.VISIBLE);
        titlebarCommint.setText("提交");
    }

    private int showImgFalg;
    @OnClick({R.id.allusermsg_sex,R.id.titlebar_commint, R.id.allusermsg_birthdate,R.id.allueermsg_practice_license,R.id.allueermsg_practice_qualification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.allusermsg_sex:
                showSex();
                break;
            case R.id.allusermsg_birthdate:
                showYear();
                break;
            case R.id.allueermsg_practice_qualification:
                showImgFalg =1;
                xuanzephoto();
                break;
            case R.id.allueermsg_practice_license:
                showImgFalg =2;
                xuanzephoto();
                break;
            case R.id.titlebar_commint:



                
                break;
        }

    }

    private void xuanzephoto() {
        FunctionOptions options = new FunctionOptions.Builder()
                .setType(FunctionConfig.TYPE_IMAGE)
                .setCompress(false) //是否压缩
                .setEnablePixelCompress(true) //是否启用像素压缩
                .setEnableQualityCompress(true) //是否启质量压缩
                .setSelectMode(FunctionConfig.MODE_SINGLE) // 单选 or 多选
                .create();
        PictureConfig.getInstance().init(options).openPhoto(AllUserMsgActivity.this, resultCallback);
    }

    private List<LocalMedia> selectMedia = new ArrayList<>();
    /**
     * 图片回调方法
     */
    private PictureConfig.OnSelectResultCallback resultCallback = new PictureConfig.OnSelectResultCallback() {
        @Override
        public void onSelectSuccess(List<LocalMedia> resultList) {

        }

        @Override
        public void onSelectSuccess(LocalMedia media) {
            // 单选回调
//            selectMedia.add(media);
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                path = media.getCompressPath();
            } else {
                // 原图
                path = media.getPath();
            }
            if(showImgFalg == 1) {
                Glide.with(AllUserMsgActivity.this).load(path).into(allueermsgPracticeQualification);
            }else if(showImgFalg == 2){
                Glide.with(AllUserMsgActivity.this).load(path).into(allueermsgPracticeLicense);
            }
        }
    };
    public String path;


    /**
     * 単独拍照图片回调
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == FunctionConfig.CAMERA_RESULT) {
                if (data != null) {
//                    selectMedia = (List<LocalMedia>) data.getSerializableExtra(FunctionConfig.EXTRA_RESULT);
//                    if (selectMedia != null) {
//                        adapter.setList(selectMedia);
//                        adapter.notifyDataSetChanged();
//                    }

                }
            }
        }
    }
    /**
     * 选择性别的弹窗
     */
    private void showSex() {
        OptionPicker picker = new OptionPicker(this, new String[]{
                "男", "女"
        });
        picker.setCanceledOnTouchOutside(false);
        picker.setDividerRatio(WheelView.DividerConfig.FILL);
        picker.setShadowColor(Color.RED, 40);
        picker.setSelectedIndex(1);
        picker.setCycleDisable(true);
        picker.setTextSize(14);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
//                        showToast("index=" + index + ", item=" + item);
                allusermsgSexEt.setText(item);
            }
        });
        picker.show();
    }

    /**
     * 选择年月日的弹窗
     */
    private void showYear(){
        final DatePicker picker = new DatePicker(this);
        picker.setCanceledOnTouchOutside(true);
        picker.setUseWeight(true);

        picker.setTopPadding(ConvertUtils.toPx(this, 20));
        picker.setRangeEnd(2017, 1, 11);
        picker.setRangeStart(1940, 8, 29);
        picker.setSelectedItem(1980, 6, 14);


        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                allusermsgBirthdateTv.setText(year + "-" + month + "-" + day);
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();
    }

//    private void showFile(){
//        FilePicker picker = new FilePicker(this, FilePicker.FILE);
//        picker.setShowHideDir(false);
//        //picker.setAllowExtensions(new String[]{".apk"});
//        picker.setOnFilePickListener(new FilePicker.OnFilePickListener() {
//            @Override
//            public void onFilePicked(String currentPath) {
//                allueermsgPracticeQualification.setText(currentPath);
//            }
//        });
//        picker.show();
//    }
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.titlebar_back)
    public void onViewClicked() {
        finish();
    }
}
