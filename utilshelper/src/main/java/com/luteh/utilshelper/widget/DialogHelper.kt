package com.luteh.utilshelper.widget

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import com.luteh.utilshelper.R

/**
 * Created by Luthfan Maftuh on 30/04/2019.
 * Email luthfanmaftuh@gmail.com
 */
object DialogHelper {
    /** The loading progress dialog object */
    var progressDialog: ProgressDialog? = null

    /**
     * Shows a loading progress dialog.
     * @param context the context
     * @param message the dialog message string
     * @param onBackPressListener the back button press listener when loading is shown
     */
    fun showProgressDialog(context: Context, message: String) {
        dismissProgressDialog()
        progressDialog = ProgressDialog(context)
        progressDialog!!.setMessage(message)
        progressDialog!!.setCancelable(false)
        if (context is Activity && !context.isFinishing) progressDialog!!.show()
    }

    /** Hides the currently shown loading progress dialog */
    fun dismissProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
            progressDialog = null
        }
    }

    /**
     * Sets the progress dialog progress in percent.
     * @param progress The loading progress in percent
     */
    fun setProgressDialogProgress(progress: Int) {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.progress = progress
            progressDialog!!.setMessage("$progress%")
        }
    }

    /**
     * Sets the progress dialog progress indeterminate state.
     * @param isIndeterminate Determines if progress dialog is indeterminate
     */
    fun setProgressDialogIndeterminate(isIndeterminate: Boolean) {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.isIndeterminate = isIndeterminate
        }
    }

    /**
     * Sets the progress dialog message.
     * @param message The dialog message string
     */
    fun setProgressDialogMessage(message: String) {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.setMessage(message)
        }
    }

    /**
     * Display a simple [AlertDialog] with a simple OK button.
     * If the dismiss listener is specified, the dialog becomes uncancellable
     * @param context The context
     * @param title The title string
     * @param message The message string
     * @param dismissListener The dismiss listener
     */
    fun showMessageDialog(
        context: Context, title: String?, message: String?,
        dismissListener: DialogInterface.OnDismissListener? = null
    ) {
        val builder = AlertDialog.Builder(context, R.style.AppTheme_Dialog_Alert)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(android.R.string.ok, { dialog, _ -> dialog.dismiss() })

        val dialog = builder.create()
        if (dismissListener != null) {
            dialog.setOnDismissListener(dismissListener)
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
        }
        dialog.show()
    }
}