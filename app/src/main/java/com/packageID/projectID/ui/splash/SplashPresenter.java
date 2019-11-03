/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <SplashScreen Presenter >
 */

package com.packageID.projectID.ui.splash;
import com.packageID.projectID.data.DataManager;
import com.packageID.projectID.rx.SchedulerProvider;
import com.packageID.projectID.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        // Sart a service if exist
        getMvpView().startSamplervice();


        // Method here


    }

    private void decideNextActivity() {
        /*  Permorm actions here and decide where to go by calling appropriate activity method */
        getMvpView().openMainActivity();
    }
}
