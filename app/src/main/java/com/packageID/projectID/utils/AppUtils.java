/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 5/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 4:26 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

public class AppUtils {

    public static Boolean isActivityRunning(Class activityClass, Context mcontext) {
        ActivityManager activityManager = (ActivityManager) mcontext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

        for (ActivityManager.RunningTaskInfo task : tasks) {
            if (activityClass.getCanonicalName().equalsIgnoreCase(task.baseActivity.getClassName()))
                return true;
        }

        return false;
    }
}
