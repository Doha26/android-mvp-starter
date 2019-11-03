/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/13/19 3:31 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.data.local.db.bo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sample_item_table")
public class SampleItem {

   @PrimaryKey
   @NonNull
   @ColumnInfo(name = "sample_item")
   private String name;

   @NonNull
   public String getName() {
      return name;
   }

   public void setName(@NonNull String name) {
      this.name = name;
   }
}