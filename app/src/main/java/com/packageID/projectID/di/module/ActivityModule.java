/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 6/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.packageID.projectID.di.ActivityContext;
import com.packageID.projectID.di.PerActivity;
import com.packageID.projectID.rx.AppSchedulerProvider;
import com.packageID.projectID.rx.SchedulerProvider;
import com.packageID.projectID.ui.splash.SplashMvpPresenter;
import com.packageID.projectID.ui.splash.SplashMvpView;
import com.packageID.projectID.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

}
