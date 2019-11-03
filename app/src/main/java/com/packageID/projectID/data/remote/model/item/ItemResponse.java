
/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:27 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.data.remote.model.item;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ItemResponse {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
