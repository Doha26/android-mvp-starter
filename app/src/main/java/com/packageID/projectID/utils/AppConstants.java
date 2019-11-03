/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 5/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 4:14 PM
 *
 *
 * This class contains all app CONSTANTS
 *
 */

package com.packageID.projectID.utils;



public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "SUCCESS";
    public static final String STATUS_CODE_FAILED = "FAILLED";
    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    public static final String DB_NAME = "DigitBank2019-db";
    public static final String PREF_NAME = "DigitalBank_pref";
    public static final long NULL_INDEX = -1L;
    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";
    public static final String CONNECT_TO_WIFI = "WIFI";
    public static final String CONNECT_TO_MOBILE = "MOBILE";
    public static final String NOT_CONNECT = "NOT_CONNECT";
    public final static String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
