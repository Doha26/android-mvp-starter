/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 3:11 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.data.local.db.repository.SampleItem;

import com.packageID.projectID.data.local.db.dao.SampleItemDao;
import com.packageID.projectID.data.local.db.bo.SampleItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class SampleItemDataSource  implements SampleItemRepository{

    private SampleItemDao sampleItemDao;

    @Inject
    public SampleItemDataSource(SampleItemDao sampleItemDao) {
        this.sampleItemDao = sampleItemDao;
    }

    @Override
    public Single<SampleItem> findById(int id) {
        return sampleItemDao.findById(id);
    }

    @Override
    public Flowable<List<SampleItem>> findAll() {
        return sampleItemDao.findAll();
    }

    @Override
    public Completable insert(SampleItem sampleItem) {
        return sampleItemDao.insert(sampleItem);
    }

    @Override
    public int delete(SampleItem sampleItem) {
        return sampleItemDao.delete(sampleItem);
    }
}
