package com.luteh.utilshelper.widget

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.luteh.utilshelper.R
import kotlinx.android.synthetic.main.snackbar_icon_text.view.*

/**
 * Created by Luthfan Maftuh on 5/4/2019.
 * Email luthfanmaftuh@gmail.com
 */
object SnackbarHelper {

    fun showSnackbarSuccess(context: Context, stringRes: Int) {
        showSnackbarSuccess(context, context.getString(stringRes))
    }

    fun showSnackbarSuccess(context: Context, message: String) {
        val snackbar = Snackbar.make((android.R.id.content as View), "", Snackbar.LENGTH_LONG)
        //inflate view
        val customView =
            (context as Activity).layoutInflater.inflate(R.layout.snackbar_icon_text, null)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            snackbar.view.background = context.getDrawable(R.drawable.bg_snackbar_success)
        }
        val snackBarView = snackbar.view as Snackbar.SnackbarLayout
        snackBarView.setPadding(0, 0, 0, 0)

        customView.message.text = message
        customView.icon.setImageResource(R.drawable.ic_done)
        snackBarView.addView(customView, 0)
        snackbar.show()
    }

    fun showSnackbarError(context: Context, stringRes: Int) {
        showSnackbarError(context, context.getString(stringRes))
    }

    fun showSnackbarError(context: Context, message: String) {
        val snackbar = Snackbar.make(
            (context as Activity).findViewById(android.R.id.content),
            "",
            Snackbar.LENGTH_LONG
        )
        //inflate view
        val customView =
            context.layoutInflater.inflate(R.layout.snackbar_icon_text, null)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            snackbar.view.background = context.getDrawable(R.drawable.bg_snackbar_error)
        }
        val snackBarView = snackbar.view as Snackbar.SnackbarLayout
        snackBarView.setPadding(0, 0, 0, 0)

        customView.message.text = message
        customView.icon.setImageResource(R.drawable.ic_close)
        snackBarView.addView(customView, 0)
        snackbar.show()
    }

    fun showSnackbarInfo(context: Context, stringRes: Int) {
        showSnackbarInfo(context, context.getString(stringRes))
    }

    fun showSnackbarInfo(context: Context, message: String) {
        val snackbar = Snackbar.make(
            (context as Activity).findViewById(android.R.id.content),
            "",
            Snackbar.LENGTH_LONG
        )
        //inflate view
        val customView =
            context.layoutInflater.inflate(R.layout.snackbar_icon_text, null)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            snackbar.view.background = context.getDrawable(R.drawable.bg_snackbar_info)
        }
        val snackBarView = snackbar.view as Snackbar.SnackbarLayout
        snackBarView.setPadding(0, 0, 0, 0)

        customView.message.text = message
        customView.icon.setImageResource(R.drawable.ic_info)
        snackBarView.addView(customView, 0)
        snackbar.show()
    }
}