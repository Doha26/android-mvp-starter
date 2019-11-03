/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:02 PM
 *
 *
 * <Manage All Rest Api Calls here>
 */

package com.packageID.projectID.data.remote;

import com.packageID.projectID.data.remote.model.ResponseWrapper;
import com.packageID.projectID.data.remote.model.item.ItemResponse;
import com.packageID.projectID.data.remote.model.item.AddItemRequest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class RestApiManager implements RestApiHelper {

    ApiInterface mApiInterface;

    @Inject
    public RestApiManager(ApiInterface apiInterface) {
        mApiInterface = apiInterface;
    }



    @Override
    public Single<ResponseWrapper<List<ItemResponse>>> getItemList() {
        return mApiInterface.getItemList();
    }

    @Override
    public Single<ResponseWrapper<ItemResponse>> addItem(AddItemRequest addItemRequest) {
        return mApiInterface.addItem(addItemRequest);
    }
}
