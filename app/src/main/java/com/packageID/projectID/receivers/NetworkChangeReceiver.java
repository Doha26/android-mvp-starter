/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/13/19 12:33 PM
 *
 *
 * <This class detect network availlability>
 */

package com.packageID.projectID.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.packageID.projectID.root.ProjectIDApplication;
import com.packageID.projectID.utils.NetworkUtils;

public class NetworkChangeReceiver extends BroadcastReceiver {
    public static ConnectivityReceiverListener connectivityReceiverListener;
    boolean isConnected = false;

    public NetworkChangeReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent arg1) {
       // ConnectivityManager cm = (ConnectivityManager) context
         //       .getSystemService(Context.CONNECTIVITY_SERVICE);
        //NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        // boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
         isConnected = NetworkUtils.getConnectivityStatus(ProjectIDApplication.getInstance().getApplicationContext()) > 0;

        Log.d("CONORI", String.valueOf(NetworkUtils.getConnectivityStatus(ProjectIDApplication.getInstance().getApplicationContext())));

        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }

    public static boolean isConnected() {
       // ConnectivityManager cm = (ConnectivityManager) MyApplication.getInstance().getAppContext().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        //NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
       // return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return NetworkUtils.getConnectivityStatus(ProjectIDApplication.getInstance().getAppContext().getApplicationContext()) > 0;
    }

    public static void connectionNotAvaillable() {
        connectivityReceiverListener.onInternetUnavailable();
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);

        void onInternetUnavailable();

    }
}