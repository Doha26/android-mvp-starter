/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:02 PM
 *
 *
 * <Data manager to manage all API Methods call>
 */

package com.packageID.projectID.data;

import android.content.Context;
import com.packageID.projectID.data.prefs.PreferencesHelper;
import com.packageID.projectID.data.remote.RestApiHelper;
import com.packageID.projectID.data.remote.model.ResponseWrapper;
import com.packageID.projectID.data.remote.model.item.AddItemRequest;
import com.packageID.projectID.data.remote.model.item.ItemResponse;
import com.packageID.projectID.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class BaseDataManager implements DataManager {

    private static final String TAG = "BaseDataManager";


    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final RestApiHelper mApiHelper;

    @Inject
    public BaseDataManager(@ApplicationContext Context context,
                           PreferencesHelper preferencesHelper,
                           RestApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


    @Override
    public void isFirstTimeLaunch() {

    }

    @Override
    public Single<ResponseWrapper<List<ItemResponse>>> getItemList() {

        //perform actions here
        return null;
    }

    @Override
    public Single<ResponseWrapper<ItemResponse>> addItem(AddItemRequest request) {

        // Perform actions
        return null;
    }
}
