/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 13/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Base Activity. all Activities must extends this class>
 */

package com.packageID.projectID.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.snackbar.Snackbar;
import com.packageID.projectID.di.component.DaggerActivityComponent;
import com.packageID.projectID.di.module.RoomModule;
import com.packageID.projectID.root.ProjectIDApplication;
import com.packageID.projectID.R;
import com.packageID.projectID.di.component.ActivityComponent;
import com.packageID.projectID.di.module.ActivityModule;
import com.packageID.projectID.receivers.NetworkChangeReceiver;
import com.packageID.projectID.utils.CommonUtils;
import com.packageID.projectID.utils.NetworkUtils;

import butterknife.Unbinder;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public abstract class BaseActivity extends AppCompatActivity
        implements MvpView, BaseFragment.Callback,NetworkChangeReceiver.ConnectivityReceiverListener {


    // Main BaseActivity component
    private ActivityComponent mActivityComponent;


    private ProgressDialog mProgressDialog;
    boolean isConnected = false;
    IntentFilter intentFilter;
    final static String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    private BroadcastReceiver mConnectivityReceiver;


    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .roomModule(new RoomModule(getApplication()))
                .applicationComponent(((ProjectIDApplication) getApplication()).getComponent())
                .build();

        initConectionStatus();

    }
    @Override
    protected void onResume() {
        super.onResume();

        // Register Receiver here

        // register internet connectivity listener
        registerConnectivityReceiver();

        initConectionStatus();

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Unregister all broadcast receiver here
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mConnectivityReceiver);

    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();


        // Unregister all broadcast receiver here
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mConnectivityReceiver); // Network connection broadcast receiver

    }



    /* Activity Component */

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }








    /* Activity Methods */

    public  void goToActivity(Context context , Class classToGo) {
        Intent intent = new Intent(context, classToGo);
        context.startActivity(intent);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    private void checkConnection() {
        boolean isConnected = NetworkChangeReceiver.isConnected();
        handleNetworkStatus(isConnected);
    }

    protected void handleNetworkStatus(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = getString(R.string.good_connected_to_internet);
            color = Color.WHITE;
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    String message = getString(R.string.sorry_not_connected);
                    int color = Color.RED;
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE);
                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(getResources().getColor(R.color.white));
                    TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                    snackbar.setAction(R.string.retry_text, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            checkConnection();
                        }
                    }).setActionTextColor(getResources().getColor(R.color.colorAccent)).show();

                    snackbar.show();
                }
            });
        }
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    @Override
    public  void initConectionStatus() {
        intentFilter = new IntentFilter(CONNECTIVITY_ACTION);
        mConnectivityReceiver = new NetworkChangeReceiver();
        isConnected = NetworkUtils.getConnectivityStatus(ProjectIDApplication.getInstance().getApplicationContext()) > 0;
        handleNetworkStatus(isConnected);
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onTokenExpire() {

        // Handle action for token expiration here
        //...

        // Finish activity
        finish();
    }

    @Override
    public void registerConnectivityReceiver() {
        try {
            ProjectIDApplication.getInstance().getApplicationContext().registerReceiver(mConnectivityReceiver, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Register Error", e.getMessage());
        }
    }

    @Override
    public void unregisterConnectivityReceiver() {
        if (mConnectivityReceiver != null) {
            try {
                ProjectIDApplication.getInstance().getApplicationContext().unregisterReceiver(mConnectivityReceiver);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("Register Error", e.getMessage());
            }
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        handleNetworkStatus(isConnected);
    }

    @Override
    public void onInternetUnavailable() {
        handleNetworkStatus(false);
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }



    protected abstract void setUp();



    protected abstract void init();
}
