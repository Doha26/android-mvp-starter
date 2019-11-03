/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/13/19 12:47 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.ui.main;

import android.os.Bundle;

import com.packageID.projectID.R;
import com.packageID.projectID.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void init() {

    }
}
