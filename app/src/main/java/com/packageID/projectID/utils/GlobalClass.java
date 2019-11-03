/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 5/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 4:14 PM
 *
 *
 * This class contains global variables that can be accessed in the application
 *
 * */

package com.packageID.projectID.utils;

import android.app.Application;

public class GlobalClass extends Application {

    // Exemple
    public static String myvar;



    // public static Getter and setter

    public static String getMyvar() {
        return myvar;
    }

    public static void setMyvar(String myvar) {
        GlobalClass.myvar = myvar;
    }
}
