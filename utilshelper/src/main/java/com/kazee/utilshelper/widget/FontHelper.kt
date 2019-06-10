package com.kazee.utilshelper.widget

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.view.ViewGroup
import android.widget.TextView
import java.util.HashMap

/**
 * Created by Luthfan Maftuh on 21/03/2019.
 * Email luthfanmaftuh@gmail.com
 */
object FontHelper {
    fun setDefaultFont(
        context: Context,
        staticTypefaceFieldName: String, fontAssetName: String
    ) {
        val regular = Typeface.createFromAsset(
            context.assets,
            fontAssetName
        )
        replaceFont(staticTypefaceFieldName, regular)
    }

    private fun replaceFont(
        staticTypefaceFieldName: String,
        newTypeface: Typeface
    ) {
        //Regular override
        try {
            val staticField = Typeface::class.java
                .getDeclaredField(staticTypefaceFieldName)
            staticField.isAccessible = true
            staticField.set(null, newTypeface)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //Also override font for lollipop or above version
        if (Build.VERSION.SDK_INT >= 21) {
            val newMap = HashMap<String, Typeface>()
            newMap["sans-serif"] = newTypeface
            try {
                val staticField = Typeface::class.java
                    .getDeclaredField("sSystemFontMap")
                staticField.isAccessible = true
                staticField.set(null, newMap)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    /**
     * Customize font to specific font face.
     * @param textView TextView component
     */
    fun customizeFont(context: Context, textView: TextView, fontFace: String) {
        val typeFace = Typeface.createFromAsset(context.assets, fontFace)
        textView.typeface = typeFace
        textView.invalidate()
    }

    fun setAllTextView(context: Context, parent: ViewGroup, fontFace: String) {
        for (i in parent.childCount - 1 downTo 0) {
            val child = parent.getChildAt(i)
            if (child is ViewGroup) {
                setAllTextView(context, child, fontFace)
            } else if (child is TextView) {
                customizeFont(context, child, fontFace)
            }
        }
    }
}