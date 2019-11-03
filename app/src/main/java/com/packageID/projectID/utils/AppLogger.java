/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 5/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 4:14 PM
 *
 *
 * This class contain all Logging method for timber library.
 *
 */

package com.packageID.projectID.utils;


import com.packageID.projectID.BuildConfig;

import timber.log.Timber;


public class AppLogger {

    public static void init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
    }

    public static void d(Throwable throwable, String s, Object... objects) {
        Timber.d(throwable, s, objects);
    }

    public static void i(String s, Object... objects) {
        Timber.i(s, objects);
    }

    public static void i(Throwable throwable, String s, Object... objects) {
        Timber.i(throwable, s, objects);
    }

    public static void w(String s, Object... objects) {
        Timber.w(s, objects);
    }

    public static void w(Throwable throwable, String s, Object... objects) {
        Timber.w(throwable, s, objects);
    }

    public static void e(String s, Object... objects) {
        Timber.e(s, objects);
    }

    public static void e(Throwable throwable, String s, Object... objects) {
        Timber.e(throwable, s, objects);
    }

}
