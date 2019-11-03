/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Splashscreen MVP Presenter>
 */

package com.packageID.projectID.ui.splash;

import com.packageID.projectID.di.PerActivity;
import com.packageID.projectID.ui.base.MvpPresenter;


@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

}
