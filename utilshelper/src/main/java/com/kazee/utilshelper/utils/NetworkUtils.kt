package com.kazee.utilshelper.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import androidx.core.content.getSystemService

/**
 * Created by Luthfan Maftuh on 24/03/2019.
 * Email luthfanmaftuh@gmail.com
 *
 * A helper class to check connection
 */
object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    fun wifiInfo(context: Context): WifiInfo {
        val wifiManager =
            context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.connectionInfo
    }
}