/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 6/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.di.module;

import android.app.Service;

import dagger.Module;


@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }
}
