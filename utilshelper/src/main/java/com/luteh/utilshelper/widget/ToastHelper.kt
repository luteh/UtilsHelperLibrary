package com.luteh.utilshelper.widget

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.luteh.utilshelper.R
import kotlinx.android.synthetic.main.toast_icon_text.view.*

/**
 * Created by Luthfan Maftuh on 30/04/2019.
 * Email luthfanmaftuh@gmail.com
 */
object ToastHelper {
    /**
     * Display a simple [Toast].
     * @param stringRes The message string resource id
     */
    fun showToast(context: Context, stringRes: Int) {
        showToast(context, context.getString(stringRes))
    }

    /**
     * Display a simple [Toast].
     * @param message The message string
     * @param toastLength The toast length int
     */
    fun showToast(context: Context, message: String, toastLength: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, toastLength).show()
    }

    /**
     * Display a custom success [Toast]
     * @param context The context
     * @param stringRes The message string resource id
     */
    fun showToastSuccess(context: Context, stringRes: Int) {
        showToastSuccess(context, context.getString(stringRes))
    }

    /**
     * Display a custom success [Toast]
     * @param context The context
     * @param stringRes The message string
     */
    fun showToastSuccess(context: Context, message: String) {
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val customView =
            (context as Activity).layoutInflater.inflate(R.layout.toast_icon_text, null)
        customView.message.text = message
        customView.icon.setImageResource(R.drawable.ic_done)
        customView.parent_view.setCardBackgroundColor(
            context.getResources().getColor(R.color.green_500)
        )

        toast.view = customView
        toast.show()
    }

    /**
     * Display a custom info [Toast]
     * @param context The context
     * @param stringRes The message string resource id
     */
    fun showToastInfo(context: Context, stringRes: Int) {
        showToastInfo(context, context.getString(stringRes))
    }

    /**
     * Display a custom info [Toast]
     * @param context The context
     * @param stringRes The message string
     */
    fun showToastInfo(context: Context, message: String) {
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val customView =
            (context as Activity).layoutInflater.inflate(R.layout.toast_icon_text, null)
        customView.message.text = message
        customView.icon.setImageResource(R.drawable.ic_info)
        customView.parent_view.setCardBackgroundColor(
            context.getResources().getColor(R.color.blue_500)
        )

        toast.view = customView
        toast.show()
    }

    /**
     * Display a custom error [Toast]
     * @param context The context
     * @param stringRes The message string resource id
     */
    fun showToastError(context: Context, stringRes: Int) {
        showToastError(context, context.getString(stringRes))
    }

    /**
     * Display a custom error [Toast]
     * @param context The context
     * @param stringRes The message string
     */
    fun showToastError(context: Context, message: String) {
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG

        //inflate view
        val customView =
            (context as Activity).layoutInflater.inflate(R.layout.toast_icon_text, null)
        customView.message.text = message
        customView.icon.setImageResource(R.drawable.ic_close)
        customView.parent_view.setCardBackgroundColor(
            context.getResources().getColor(R.color.red_600)
        )

        toast.view = customView
        toast.show()
    }
}