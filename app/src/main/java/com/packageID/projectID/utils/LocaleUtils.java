/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 5/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 1/22/19 8:20 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

public class LocaleUtils {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ENGLISH, FRENCH})
    public @interface LocaleDef {
        String[] SUPPORTED_LOCALES = {ENGLISH, FRENCH};
    }

    public static final String ENGLISH = "en";
    public static final String FRENCH = "fr";

    public static void initialize(Context context) {
        setLocale(context, ENGLISH);
    }

    public static void initialize(Context context, @LocaleDef String defaultLanguage) {
        setLocale(context, defaultLanguage);
    }

    public static boolean setLocale(Context context, @LocaleDef String language) {
        return updateResources(context, language);
    }

    public static boolean setLocale(Context context, int languageIndex) {
        if (languageIndex >= LocaleDef.SUPPORTED_LOCALES.length) {
            return false;
        }

        return updateResources(context, LocaleDef.SUPPORTED_LOCALES[languageIndex]);
    }


    private static boolean updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return true;
    }

    public static boolean CheckLocale(Context context, String app_language) {
        Locale myLocale = new Locale(app_language);
        Resources res = context.getResources();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        return res.getConfiguration().locale == myLocale;

    }
}