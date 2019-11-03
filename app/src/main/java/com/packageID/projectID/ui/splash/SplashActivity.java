/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.ui.splash;

import android.content.Context;
import android.os.Bundle;

import com.packageID.projectID.R;
import com.packageID.projectID.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;


    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(SplashActivity.this);
    }

    @Override
    public void openMainActivity() {
        goToActivity(mContext, SplashActivity.class);
        finish();
    }

    @Override
    public void startSamplervice() {

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    // Always use setup method to setup views
    @Override
    protected void setUp() {

    }

    // Init variables here
    @Override
    protected void init() {
        mContext = SplashActivity.this;
    }
}
