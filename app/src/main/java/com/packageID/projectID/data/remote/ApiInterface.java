/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:02 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.data.remote;

import com.packageID.projectID.data.remote.model.item.AddItemRequest;
import com.packageID.projectID.data.remote.model.item.ItemResponse;
import com.packageID.projectID.data.remote.model.ResponseWrapper;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {

    /**
     * @return Observable Item response
     */


    @GET("** Api endpoint here ***")
    Single<ResponseWrapper<List<ItemResponse>>> getItemList();


    @POST("** Api endpoint here ***")
    Single<ResponseWrapper<ItemResponse>> addItem(@Body AddItemRequest addItemRequest);

}
