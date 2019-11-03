/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/13/19 11:02 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.data.local.db;

import com.packageID.projectID.data.local.db.bo.SampleItem;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class AppDbHelper implements DbHelper {


    @Inject
    public AppDbHelper() {

    }



    // Methods overides
    @Override
    public Observable<List<SampleItem>> getAllSampleItems() {
        return null;
    }

    @Override
    public Observable<Boolean> insertSampleItem(SampleItem user) {
        return null;
    }


}
