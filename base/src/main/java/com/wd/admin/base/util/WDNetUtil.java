package com.wd.admin.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.wd.admin.base.WDCoreApp;

/**
 * Created by admin on 2017/4/9.
 */
public class WDNetUtil {
    private WDNetUtil() {
    }

    public static boolean isNetworkConnected() {
        if (WDCoreApp.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) WDCoreApp.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isWifiConnected() {
        if (WDCoreApp.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) WDCoreApp.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isMobileConnected() {
        if (WDCoreApp.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) WDCoreApp.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static int getConnectedType() {
        if (WDCoreApp.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) WDCoreApp.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }
}
