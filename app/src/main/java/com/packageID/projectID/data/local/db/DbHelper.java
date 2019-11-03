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

import io.reactivex.Observable;
import java.util.List;

public interface DbHelper {


    /* Sample Item hooks signature */

    Observable<List<SampleItem>> getAllSampleItems();

    Observable<Boolean> insertSampleItem(final SampleItem user);


    /* Other model hooks signature */
    //...



}
