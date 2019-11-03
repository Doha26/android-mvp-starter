/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 8:43 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.root;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.packageID.projectID.di.component.ApplicationComponent;
import com.packageID.projectID.di.component.DaggerApplicationComponent;
import com.packageID.projectID.di.module.ApplicationModule;
import com.packageID.projectID.di.module.RoomModule;
import com.packageID.projectID.listeners.InternetConnectionListener;
import com.packageID.projectID.receivers.NetworkChangeReceiver;
import com.packageID.projectID.utils.AppLogger;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


@SuppressLint("Registered")
public class ProjectIDApplication extends Application {


    private ApplicationComponent mApplicationComponent;


    @Inject
    CalligraphyConfig mCalligraphyConfig;
    
    private static ProjectIDApplication mInstance;

    @Override
    public void onCreate() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); // Allow to load drawable dynamiccaly to solve RessourceNotFoundException with drawable vectors

        super.onCreate();
        mInstance = this;
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();
        mApplicationComponent.inject(this);




        AppLogger.init();

        initStetho();
        initCalligraphy();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }



    public Context getAppContext() {
        return mInstance.getApplicationContext();
    }
    public static synchronized ProjectIDApplication getInstance() {
        return mInstance;
    }



    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }




    //****  Class Methods


    void initStetho() {
        Stetho.initializeWithDefaults(this);
    }

    void initCalligraphy() {
        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }


    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void setConnectivityListener(NetworkChangeReceiver.ConnectivityReceiverListener listener) {
        NetworkChangeReceiver.connectivityReceiverListener = listener;

    }

    public void setInternetConnectionListener(InternetConnectionListener listener) {
        InternetConnectionListener mInternetConnectionListener = listener;
    }

    public void removeInternetConnectionListener() {
        NetworkChangeReceiver.connectivityReceiverListener = null;
    }



}
