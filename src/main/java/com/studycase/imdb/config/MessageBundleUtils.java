package com.studycase.imdb.config;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Slf4j
public class MessageBundleUtils {

    public static final String APP_RESOURCE_FILE = "locale/messages";

    private static ResourceBundle appResourceBundle;

    private static Locale defaultLocale = new Locale("en");

    static {
        initializeBundles();
    }

    private MessageBundleUtils() {
    }

    public static Locale getLocale() {
        return defaultLocale;
    }

    public static void setLocale(Locale locale) {
        defaultLocale = locale;
        initializeBundles();
    }

    private static void initializeBundles() {
        appResourceBundle = ResourceBundle.getBundle(APP_RESOURCE_FILE, defaultLocale);
    }

    public static String getMessage(String key, Locale locale) {
        try {
            ResourceBundle resource = null;
            if (locale == null) {
                resource = ResourceBundle.getBundle(APP_RESOURCE_FILE, defaultLocale);
            } else {
                resource = ResourceBundle.getBundle(APP_RESOURCE_FILE, locale);
            }
            return resource.getString(key);
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String getMessage(String key, Locale locale, Object... arguments) {
        try {

            ResourceBundle resource = null;
            if (locale == null) {
                resource = ResourceBundle.getBundle(APP_RESOURCE_FILE, defaultLocale);
            } else {
                resource = ResourceBundle.getBundle(APP_RESOURCE_FILE, locale);
            }
            return MessageFormat.format(resource.getString(key), arguments);
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String getMessage(String key) {
        try {
            return appResourceBundle.getString(key);
        } catch (MissingResourceException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static String getMessage(String key, Object... arguments) {
        try {
            return MessageFormat.format(appResourceBundle.getString(key), arguments);
        } catch (MissingResourceException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

}