package com.example.wen.lifeassistant;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wen.lifeassistant.Fragment.DetailedlistFragment;
import com.example.wen.lifeassistant.Fragment.DiaryFragment;
import com.example.wen.lifeassistant.Fragment.PhotoFragment;
import com.example.wen.lifeassistant.Fragment.SettingFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    // 底部菜单4个Linearlayout
    private LinearLayout ll_diary;
    private LinearLayout ll_photo;
    private LinearLayout ll_detailed_list;
    private LinearLayout ll_setting;

    // 底部菜单4个ImageView
    private ImageView iv_diary;
    private ImageView iv_photo;
    private ImageView iv_detailed_list;
    private ImageView iv_setting;

    // 底部菜单4个菜单标题
    private TextView tv_diary;
    private TextView tv_photo;
    private TextView tv_detailed_list;
    private TextView tv_setting;

    // 4个Fragment
    private Fragment diaryFragment;
    private Fragment photoFragment;
    private Fragment detailed_listFragment;
    private Fragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
        // 初始化并设置当前Fragment
        initFragment(0);

    }

    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (diaryFragment == null) {
                    diaryFragment = new DiaryFragment();
                    transaction.add(R.id.fl_content, diaryFragment);
                } else {
                    transaction.show(diaryFragment);
                }
                break;
            case 1:
                if (photoFragment == null) {
                    photoFragment = new PhotoFragment();
                    transaction.add(R.id.fl_content, photoFragment);
                } else {
                    transaction.show(photoFragment);
                }

                break;
            case 2:
                if (detailed_listFragment == null) {
                    detailed_listFragment = new DetailedlistFragment();
                    transaction.add(R.id.fl_content, detailed_listFragment);
                } else {
                    transaction.show(detailed_listFragment);
                }

                break;
            case 3:
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.fl_content, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }

                break;

            default:
                break;
        }

        // 提交事务
        transaction.commit();

    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (diaryFragment != null) {
            transaction.hide(diaryFragment);
        }
        if (photoFragment != null) {
            transaction.hide(photoFragment);
        }
        if (detailed_listFragment != null) {
            transaction.hide(detailed_listFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }

    }

    private void initEvent() {
        // 设置按钮监听
        ll_diary.setOnClickListener(this);
        ll_photo.setOnClickListener(this);
        ll_detailed_list.setOnClickListener(this);
        ll_setting.setOnClickListener(this);

    }

    private void initView() {

        // 底部菜单4个Linearlayout
        this.ll_diary = (LinearLayout) findViewById(R.id.ll_diary);
        this.ll_photo = (LinearLayout) findViewById(R.id.ll_photo);
        this.ll_detailed_list = (LinearLayout) findViewById(R.id.ll_detailed_list);
        this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

        // 底部菜单4个ImageView
        this.iv_diary = (ImageView) findViewById(R.id.iv_diary);
        this.iv_photo = (ImageView) findViewById(R.id.iv_photo);
        this.iv_detailed_list = (ImageView) findViewById(R.id.iv_detailed_list);
        this.iv_setting = (ImageView) findViewById(R.id.iv_setting);

        // 底部菜单4个菜单标题
        this.tv_diary = (TextView) findViewById(R.id.tv_diary);
        this.tv_photo = (TextView) findViewById(R.id.tv_photo);
        this.tv_detailed_list = (TextView) findViewById(R.id.tv_detailed_list);
        this.tv_setting = (TextView) findViewById(R.id.tv_setting);

    }

    @Override
    public void onClick(View v) {

        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_diary:
                //iv_home.setImageResource(R.drawable.tab_weixin_pressed);
                tv_diary.setTextColor(0xff1B940A);
                initFragment(0);
                break;
            case R.id.ll_photo:
                //iv_address.setImageResource(R.drawable.tab_address_pressed);
                tv_photo.setTextColor(0xff1B940A);
                initFragment(1);
                break;
            case R.id.ll_detailed_list:
                //iv_friend.setImageResource(R.drawable.tab_find_frd_pressed);
                tv_detailed_list.setTextColor(0xff1B940A);
                initFragment(2);
                break;
            case R.id.ll_setting:
                //iv_setting.setImageResource(R.drawable.tab_find_frd_pressed);
                tv_setting.setTextColor(0xff1B940A);
                initFragment(3);
                break;

            default:
                break;
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
//        iv_home.setImageResource(R.drawable.tab_weixin_normal);
//        iv_address.setImageResource(R.drawable.tab_address_normal);
//        iv_friend.setImageResource(R.drawable.tab_find_frd_normal);
//        iv_setting.setImageResource(R.drawable.tab_settings_normal);
        // TextView置为白色
        tv_diary.setTextColor(0xffffffff);
        tv_photo.setTextColor(0xffffffff);
        tv_detailed_list.setTextColor(0xffffffff);
        tv_setting.setTextColor(0xffffffff);
    }

}

