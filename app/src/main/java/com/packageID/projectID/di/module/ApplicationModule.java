/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 6/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.di.module;

import android.app.Application;
import android.content.Context;

import com.packageID.projectID.R;
import com.packageID.projectID.data.BaseDataManager;
import com.packageID.projectID.data.DataManager;
import com.packageID.projectID.data.prefs.PreferencesHelper;
import com.packageID.projectID.data.prefs.PreferencesManager;
import com.packageID.projectID.data.remote.ApiInterface;
import com.packageID.projectID.data.remote.RestApiHelper;
import com.packageID.projectID.data.remote.RestApiManager;
import com.packageID.projectID.data.secure.ITokenHelper;
import com.packageID.projectID.data.secure.TokenHelper;
import com.packageID.projectID.di.ApiInfo;
import com.packageID.projectID.di.ApplicationContext;
import com.packageID.projectID.di.PreferenceInfo;
import com.packageID.projectID.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @ApiInfo
    String provideApiKey() {
        return " //**** Api Key ***** // ";
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    ITokenHelper provideTokenHelper(TokenHelper tokenHelper) {
        return tokenHelper;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(BaseDataManager mDataManager) {
        return mDataManager;
    }



    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesManager preferencesManager) {
        return preferencesManager;
    }

    @Provides
    @Singleton
    RestApiHelper provideRestApiHelper(RestApiManager restApiManager) {
        return restApiManager;
    }



    /**
     * @return HTTTP Client
     */
    @Provides
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(chain -> {
            Request request = chain.request();
            return chain.proceed(request);
        }).build();
    }

    /**
     * provide Retrofit instances
     *
     * @param baseURL base url for api calling
     * @param client  OkHttp client
     * @return Retrofit instances
     */

    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Provide Api service
     *
     * @return ApiService instances
     */
    @Provides
    public ApiInterface provideApiInterface() {
        return provideRetrofit("", provideClient()).create(ApiInterface.class);
    }


    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath(" ***** Font path here ********")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

}
