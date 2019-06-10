package com.kazee.utilshelper.utils

import android.util.Log
import com.kazee.utilshelper.BuildConfig

/**
 * Created by Luthfan Maftuh on 30/04/2019.
 * Email luthfanmaftuh@gmail.com
 */
object LogUtils {

    /**
     * Prints an exception's stack trace.
     * Stack traces printed via this method will only show up on debug builds.
     * @param throwable the throwable
     */
    fun printStackTrace(throwable: Throwable) {
        if (BuildConfig.DEBUG) throwable.printStackTrace()
    }

    /**
     * Prints a [Log] message.
     * Log messages printed via this method will only show up on debug builds.
     * @param type The specified log type, may be [Log.DEBUG], [Log.INFO], and other log types
     * @param tag The log tag to print
     * @param message The log message to print
     */
    fun log(type: Int = Log.DEBUG, tag: String? = "BaseProject", message: String?) {
        if (BuildConfig.DEBUG) {
            var logMessage = message
            if (logMessage.isNullOrEmpty()) logMessage =
                "Message is null, what exactly do you want to print?"
            Log.println(type, tag, logMessage)
        }
    }
}