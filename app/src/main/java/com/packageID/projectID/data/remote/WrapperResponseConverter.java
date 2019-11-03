/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:02 PM
 *
 *
 * <API Response wrapper>
 */

package com.packageID.projectID.data.remote;

import com.packageID.projectID.data.remote.model.ResponseWrapper;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class WrapperResponseConverter<T>
        implements Converter<ResponseBody, T> {
    private Converter<ResponseBody, ResponseWrapper<T>> converter;

    public WrapperResponseConverter(Converter<ResponseBody,
            ResponseWrapper<T>> converter) {
        this.converter = converter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        ResponseWrapper<T> response = converter.convert(value);
        if (!response.getError()) {
            return response.getData();
        }
        // RxJava will call onError with this exception
        throw new ErrorWrapper(response.getStatus());
    }
}