package com.luteh.utilshelper.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import com.luteh.utilshelper.constant.Constants
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Luthfan Maftuh on 30/04/2019.
 * Email luthfanmaftuh@gmail.com
 */
object FileUtils {

    private val TAG = "FileUtils"

    fun createImageFile(imgBitmap: Bitmap): File {
//create a file to write bitmap data
        val mediaStorageDir = File(
            Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            Constants.IMAGE_DIRECTORY_NAME
        )
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(
                    TAG, "Oops! Failed create "
                            + Constants.IMAGE_DIRECTORY_NAME + " directory"
                )
            }
        }

        val timeStamp = SimpleDateFormat(
            "yyyyMMdd_HHmmss",
            Locale.getDefault()
        ).format(Date())

        val f = File(
            mediaStorageDir.path + File.separator
                    + "IMG_" + timeStamp + ".jpg"
        )

        f.createNewFile()

        //Convert bitmap to byte array
        val bos = ByteArrayOutputStream()
        assert(imgBitmap != null)
        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 75, bos)
        val bitmapdata = bos.toByteArray()

        val fos = FileOutputStream(f)
        fos.write(bitmapdata)
        fos.flush()
        fos.close()

        return f
    }

    fun createImageFile(context: Context, imgUri: Uri): File {
        val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

        // Get the cursor
        val cursor = context.contentResolver.query(
            imgUri,
            filePathColumn, null, null, null
        )!!
        // Move to first row
        cursor!!.moveToFirst()

        val columnIndex = cursor!!.getColumnIndex(filePathColumn[0])
        val imgDecodableString = cursor!!.getString(columnIndex)
        cursor!!.close()

        val imgBitmap = BitmapFactory
            .decodeFile(imgDecodableString)

        return createImageFile(imgBitmap)
    }
}