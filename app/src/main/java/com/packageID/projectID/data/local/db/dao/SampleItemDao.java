/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/13/19 11:25 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.data.local.db.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.packageID.projectID.data.local.db.bo.SampleItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;


@Dao
public interface SampleItemDao {

    // Interfaces methods goes here , For exemple bellow two methods signatures

    @Query("SELECT * FROM sample_item_table WHERE 'id'=:id")
    Single<SampleItem> findById(int id);

    @Query("SELECT * FROM sample_item_table")
    Flowable<List<SampleItem>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(SampleItem sampleItem);

    @Delete
    int delete(SampleItem sampleItem);

}
