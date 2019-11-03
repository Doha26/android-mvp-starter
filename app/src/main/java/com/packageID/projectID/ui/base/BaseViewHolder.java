/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/13/19 12:50 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.ui.base;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;


public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
