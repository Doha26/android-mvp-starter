/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Splachscreen MVP View>
 */

package com.packageID.projectID.ui.splash;


import com.packageID.projectID.ui.base.MvpView;


public interface SplashMvpView extends MvpView {


    // Open main activity method
    void openMainActivity();

    // Optionaly start service wich concern this view here
    void startSamplervice();
}
