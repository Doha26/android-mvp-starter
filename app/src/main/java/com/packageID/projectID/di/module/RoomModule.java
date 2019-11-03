/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 3:18 PM
 *
 *
 * <Room Local Database Module>
 */

package com.packageID.projectID.di.module;

import android.app.Application;

import androidx.room.Room;

import com.packageID.projectID.data.local.db.AppDatabase;
import com.packageID.projectID.data.local.db.dao.SampleItemDao;
import com.packageID.projectID.data.local.db.repository.SampleItem.SampleItemDataSource;
import com.packageID.projectID.data.local.db.repository.SampleItem.SampleItemRepository;
import com.packageID.projectID.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private AppDatabase appDatabase;

    public RoomModule(Application mApplication) {
        appDatabase = Room.databaseBuilder(mApplication, AppDatabase.class, AppConstants.DB_NAME).build();
    }

    // Provide the Database for Dagger Graph
    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        return appDatabase;
    }


    ///  Provide DataBase Access Object class
    @Singleton
    @Provides
    SampleItemDao provideSampleItemDao(AppDatabase appDatabase) {
        return appDatabase.getSampleItemDao();
    }


    // ... others


    // Provide Data bases repositories
    @Singleton
    @Provides
    SampleItemRepository sampleItemRepository(SampleItemDao sampleItemDao) {
        return new SampleItemDataSource(sampleItemDao);
    }

    // ... others

}
