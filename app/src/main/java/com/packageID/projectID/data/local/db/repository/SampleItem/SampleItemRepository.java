/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 3:09 PM
 *
 *
 * <Methods signatures goes here>
 */

package com.packageID.projectID.data.local.db.repository.SampleItem;


import com.packageID.projectID.data.local.db.bo.SampleItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface SampleItemRepository {

    // Example method
    Single<SampleItem> findById(int id);

    Flowable<List<SampleItem>> findAll();

    Completable insert(SampleItem product);

    int delete(SampleItem product);

}
