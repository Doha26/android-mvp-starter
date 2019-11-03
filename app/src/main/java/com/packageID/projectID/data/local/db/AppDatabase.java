/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/13/19 11:02 AM
 *
 *
 * <Database class>
 */

package com.packageID.projectID.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.packageID.projectID.data.local.db.dao.SampleItemDao;
import com.packageID.projectID.data.local.db.bo.SampleItem;

@Database(entities = {SampleItem.class /* ... others model here , separated with comma ...*/}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    static final int VERSION = 1;


    // All Data access objects should be defined here
    public abstract SampleItemDao getSampleItemDao();


}
