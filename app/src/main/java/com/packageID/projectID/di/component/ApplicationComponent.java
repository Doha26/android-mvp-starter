/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 6/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.di.component;

import android.app.Application;
import android.content.Context;

import com.packageID.projectID.data.DataManager;
import com.packageID.projectID.root.ProjectIDApplication;
import com.packageID.projectID.data.local.db.repository.SampleItem.SampleItemRepository;
import com.packageID.projectID.di.ApplicationContext;
import com.packageID.projectID.di.module.ApplicationModule;
import com.packageID.projectID.di.module.RoomModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(dependencies = {}, modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {


    // Injecting applicaton class
    void inject(ProjectIDApplication aplication);


    // Injecting Service

    //void inject(SampleService serviceName);

    @ApplicationContext
    Context context();

    Application application();

    // Dispose Remote data Manager for Api Call
    DataManager getDataManager();


    // Dispose all local repository here
    SampleItemRepository getSampleItemRepository();

    //..others

}