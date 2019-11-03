/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:02 PM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.ui.base;
import com.google.gson.JsonSyntaxException;
import com.packageID.projectID.data.DataManager;
import com.packageID.projectID.data.remote.ErrorWrapper;
import com.packageID.projectID.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;



public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private final DataManager manager;
    private V mMvpView;

    @Inject
    public BasePresenter(DataManager manager, SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.manager = manager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new ViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return manager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    @Override
    public void handleApiError(Throwable error) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    mMvpView.onError("Unauthorised UserProfile ");
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    mMvpView.onError("Forbidden");
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    mMvpView.onError("Internal Server Error");
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    mMvpView.onError("Bad Request");
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    mMvpView.onError("No Internet Connection");
                    break;
                default:
                    mMvpView.onError(error.getLocalizedMessage());

            }
        } else if (error instanceof ErrorWrapper) {
            mMvpView.onError(error.getMessage());
        } else if (error instanceof JsonSyntaxException) {
            mMvpView.onError("Something Went Wrong API is not responding properly!");
        } else {
            mMvpView.onError(error.getMessage());
        }

    }


    public static class ViewNotAttachedException extends RuntimeException {
        public ViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}

