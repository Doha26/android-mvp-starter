/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 6/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Main app activity>
 */

package com.packageID.projectID.di.component;

import com.packageID.projectID.di.PerActivity;
import com.packageID.projectID.di.module.ActivityModule;
import com.packageID.projectID.di.module.RoomModule;
import com.packageID.projectID.ui.main.MainActivity;
import com.packageID.projectID.ui.splash.SplashActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, RoomModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SplashActivity activity);

}
