package com.yao.feicui.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ProviderInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mTableWX;
    private LinearLayout mTableAb;
    private LinearLayout mTableAc;
    private LinearLayout mTableAd;

    private ImageButton mImgWX;
    private ImageButton mImgAb;
    private ImageButton mImgAc;
    private ImageButton mImgAd;

    private Fragment mF01;
    private Fragment mF02;
    private Fragment mF03;
    private Fragment mF04;

    private Button mButton;
    private Snackbar mSnack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.snack);
        mButton.setOnClickListener(this);
        initView();
        initEvent();
        setSelect(0);
    }
    private void initView(){
        mTableWX= (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTableAb= (LinearLayout) findViewById(R.id.id_tab_frd);
        mTableAc= (LinearLayout) findViewById(R.id.id_tab_address);
        mTableAd= (LinearLayout) findViewById(R.id.id_tab_settings);

        mImgWX= (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgAb= (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgAc= (ImageButton) findViewById(R.id.id_tab_address_img);
        mImgAd= (ImageButton) findViewById(R.id.id_tab_settings_img);


    }
    private void initEvent(){
        mTableWX.setOnClickListener(this);
        mTableAb.setOnClickListener(this);
        mTableAc.setOnClickListener(this);
        mTableAd.setOnClickListener(this);
    }
public void setSelect(int i){
    FragmentManager fm=getFragmentManager();
    FragmentTransaction transaction=fm.beginTransaction();
    hideFragment(transaction);
    switch (i)
    {
        case 0:
            if (mF01 == null)
            {
                mF01 = new WXFragment();
                transaction.replace(R.id.id_content, mF01);
            } else
            {
                transaction.show(mF01);
            }
            mImgWX.setImageResource(R.drawable.tab_weixin_pressed);
            break;
        case 1:
            if (mF02 == null)
            {
                mF02 = new AbFragment();transaction.add(R.id.id_content, mF02);
            } else
            {
                transaction.show(mF02);

            }
            mImgAb.setImageResource(R.drawable.tab_find_frd_pressed);
            break;
        case 2:
            if (mF03 == null)
            {
                mF03 = new AcFragment();
                transaction.add(R.id.id_content, mF03);
            } else
            {
                transaction.show(mF03);
            }
            mImgAc.setImageResource(R.drawable.tab_address_pressed);
            break;
        case 3:
            if (mF04 == null)
            {
                mF04 = new AdFragment();
                transaction.add(R.id.id_content, mF04);
            } else
            {
                transaction.show(mF04);
            }
            mImgAd.setImageResource(R.drawable.tab_settings_pressed);
            break;

        default:
            break;
    }

    transaction.commit();
}

    private void hideFragment(FragmentTransaction transaction) {
        if (mF01 != null)
        {
            transaction.hide(mF01);
        }
        if (mF02 != null)
        {
            transaction.hide(mF02);
        }
        if (mF03 != null)
        {
            transaction.hide(mF03);
        }
        if (mF04 != null)
        {
            transaction.hide(mF04);
        }
    }

    @Override
    public void onClick(View v) {
        resetImgs();

            switch (v.getId()) {
                case R.id.id_tab_weixin:
                    setSelect(0);
                    break;
                case R.id.id_tab_frd:
                    setSelect(1);
                    break;
                case R.id.id_tab_address:
                    setSelect(2);
                    break;
                case R.id.id_tab_settings:
                    setSelect(3);
                    break;

                case R.id.snack:
                   mSnack.make(mButton,"shadiao",mSnack.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    /**
     * 切换图片至暗色
     */
    private void resetImgs()
    {
      mImgWX.setImageResource(R.drawable.tab_weixin_normal);
      mImgAb.setImageResource(R.drawable.tab_find_frd_normal);
      mImgAc.setImageResource(R.drawable.tab_address_normal);
      mImgAd.setImageResource(R.drawable.tab_settings_normal);
    }
}
