/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:02 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.data.remote;

import com.packageID.projectID.data.remote.model.item.ItemResponse;
import com.packageID.projectID.data.remote.model.ResponseWrapper;
import com.packageID.projectID.data.remote.model.item.AddItemRequest;

import java.util.List;

import io.reactivex.Single;

public interface RestApiHelper {

    // Item

    Single<ResponseWrapper<List<ItemResponse>>> getItemList();

    Single<ResponseWrapper<ItemResponse>> addItem(AddItemRequest request);

    // transactions


}
